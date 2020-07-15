package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShopDAO;
import model.Shop;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String keyword = request.getParameter("keyword");
		String genreStr = request.getParameter("genre");
		int genreId = -1;

		if(genreStr != null) {
			try {
				genreId = Integer.parseInt(genreStr);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}

		var shopDAO = new ShopDAO();

		List<Shop> shops = new ArrayList<Shop>();

		//keyword
		if(keyword != null) { shops = shopDAO.searchByKeyword(keyword);  }

		//genre
		if(genreId != -1) {shops = shopDAO.searchByGenre(genreId);}

		request.setAttribute("keyword", keyword);
		request.setAttribute("shops", shops);
		request.setAttribute("size", shops.size());
		request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp").forward(request, response);
	}

}
