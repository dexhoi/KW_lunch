package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenreDAO;
import dao.ImageDAO;
import dao.ReviewDAO;
import dao.ShopDAO;
import dao.VacationDAO;
import model.Shop;
import model.ShopChecker;
import model.User;
import status.LunchStatus;

/**
 * 店の追加
 */
@WebServlet("/registry_shop")
public class RegistryShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SEPARATOR = System.getProperty("file.separator");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistryShopController() {
		super();
	}


	/**
	 * Base64文字コードから画像ファイルに変換し保存する
	 * @param bs Base64文字列
	 * @param idx 番号
	 * @return ファイル名
	 */
	public String transImg(String bs, int shopId, File temp, int idx) {
		String fileName = "";
    	if(bs.contains("jpeg")) {
    		bs = bs.replace("data:image/jpeg;base64,", "");
    		fileName = idx + ".jpeg";
    	}

    	if(bs.contains("png")) {
    		bs = bs.replace("data:image/png;base64,", "");
    		fileName = idx + ".png";
    	}

    	String root = temp + SEPARATOR + shopId;
    	//フォルダ作成
    	File file = new File(root);
    	if(!file.exists()) {
    		file.mkdir();
    	}

        String path = root + SEPARATOR + fileName;
        System.out.println(path);
        byte[] bytes = Base64.getDecoder().decode(bs.getBytes());
        try(var writer = new FileOutputStream(path)) {
        	writer.write(bytes);
        	writer.flush();
        }catch(IOException e) {
        	e.printStackTrace();
        }

        return fileName;
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenreDAO genreDAO = new GenreDAO();
		List<String> genres = genreDAO.getAll();

		request.setAttribute("genres", genres);
		request.getRequestDispatcher("/WEB-INF/jsp/registry_shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String nameStr = request.getParameter("name");
		String priceStr = request.getParameter("price");
		String genreStr = request.getParameter("genre");
		String timeStr = request.getParameter("time");
		String addressStr = request.getParameter("address");
		String[] vacationsStr = request.getParameterValues("vac");
		String scoreStr = request.getParameter("score");
		String[] imgDataStrs = request.getParameterValues("imgData");

		if(!ShopChecker.isAvailable(nameStr, priceStr, genreStr, timeStr, vacationsStr, addressStr, scoreStr)) {
			var genreDAO = new GenreDAO();
			request.setAttribute("genres", genreDAO.getAll());
			request.setAttribute("status", LunchStatus.input_error);
			request.getRequestDispatcher("/WEB-INF/jsp/registry_shop.jsp").forward(request, response);
			return;
		}


		int[] vacations = null;
		if(vacationsStr != null) {
			vacations = new int[vacationsStr.length];
			for(int i = 0; i < vacationsStr.length; i++) {
				vacations[i] = Integer.parseInt(vacationsStr[i]);
			}
		}

		LocalTime time = LocalTime.parse(timeStr);
		int price = Integer.parseInt(priceStr);
		int score = Integer.parseInt(scoreStr);

		int genreId = Integer.parseInt(genreStr);

		time = LocalTime.parse(timeStr);

		User user = (User)request.getSession().getAttribute("user");
		int userId = user.getId();

		var shop = new Shop(userId, nameStr, genreId, price, time, addressStr);
		var shopDAO = new ShopDAO();
		var reviewDAO = new ReviewDAO();
		var vacationDAO = new VacationDAO();

		shopDAO.add(shop);
		reviewDAO.add(shop.getId(), userId, score);
		vacationDAO.addAll(shop.getId(), vacations);

		// 画像 がアップロードされていたら
		if(imgDataStrs != null && imgDataStrs.length > 0) {
			int idx = 0;
			for(var imgData : imgDataStrs) {
				var tempDir = (File)request.getServletContext().getAttribute("javax.servlet.context.tempdir");
				String fileName = transImg(imgData, shop.getId(), tempDir, idx);
				new ImageDAO().add(shop.getId(), fileName);
				idx++;
			}
		}

		request.setAttribute("status", LunchStatus.add_success);
		request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
	}

}
