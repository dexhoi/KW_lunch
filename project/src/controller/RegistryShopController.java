package controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GenreDAO;
import dao.ReviewDAO;
import dao.ShopDAO;
import dao.VacationDAO;
import model.Shop;
import model.ShopChecker;
import model.User;
import status.LunchStatus;

/**
 * Servlet implementation class RegistryController
 */
@WebServlet("/registry_shop")
public class RegistryShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistryShopController() {
		super();
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

		request.setAttribute("status", LunchStatus.add_success);
		request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
	}

}
