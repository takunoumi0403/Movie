package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserInfoBeans;
import model.UserDeleteModel;

@WebServlet("/deleteUserComplete")
public class U16_DeleteUserCompleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserInfoBeans beans = new UserInfoBeans();
		beans = (UserInfoBeans) session.getAttribute("userInfoBeans");

		UserDeleteModel model = new UserDeleteModel();
		try {
			model.deleteUser(beans.getUserCode());
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		session.invalidate();


		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u16_deleteUserComplete.jsp");
		dispatcher.forward(request, response);
	}

}
