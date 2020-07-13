package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.UserInfo;
import status.LunchStatus;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//取得
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		boolean isLogin = false;

		//DAOを利用してテーブルの照会結果をDTOのリストで受けとる
		List<UserInfo> list = UserDAO.getUserInfoList();


		UserInfo userinfo = null;
		//idとpasswordが一致しているか判定
		for(UserInfo work : list) {
			if (name.equals(work.getName()) && password.equals(work.getPassword())) {
				userinfo = new UserInfo(name, password);
				isLogin = true;
				break;
			}
		}
		request.getSession().setAttribute("user", userinfo);

		if (isLogin) {
			request.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(request, response);
		}else {
			request.setAttribute("status", LunchStatus.login_fail);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}
}


