package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import dao.ShopDAO;
import model.Shop;
import model.User;
import status.LunchStatus;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String shopIdstr = request.getParameter("shopId");
    	request.setAttribute("shopId", shopIdstr);
    	ShopDAO shopDAO = new ShopDAO();
    	int shopId = -1;
    	try {
    		shopId = Integer.parseInt(shopIdstr);
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}

    	if(shopId == -1) {
			request.setAttribute("status", LunchStatus.input_error);
			request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp").forward(request, response);
			return;
		}

    	Shop shop = shopDAO.get(shopId);
    	if(shop == null) {
			request.setAttribute("status", LunchStatus.input_error);
			request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp").forward(request, response);
			return;
		}

    	String name = shop.getName();

    	request.setAttribute("shopId", shopId);
    	request.setAttribute("name", name);

    	request.getRequestDispatcher("/WEB-INF/jsp/review.jsp").forward(request, response);

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopIdstr = request.getParameter("shopId");
		String scorestr = request.getParameter("score");

		User user = (User)request.getSession().getAttribute("user");

		int shopId = -1;
		int score = -1;
		int userId = user.getId();

		try {
			shopId = Integer.parseInt(shopIdstr);
			score = Integer.parseInt(scorestr);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}


		if(shopId == -1) {
			request.setAttribute("status", LunchStatus.input_error);
			request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp").forward(request, response);
			return;
		}


		ReviewDAO reviewDAO = new ReviewDAO();
		reviewDAO.add(shopId, userId, score);

		request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);

	}

}
