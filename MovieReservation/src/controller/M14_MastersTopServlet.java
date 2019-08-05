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


@WebServlet("/masters_top")
public class M14_MastersTopServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		UserInfoBeans loginInfo = (UserInfoBeans)session.getAttribute("loginInfo");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m14_mastersTop.jsp");

		dispatcher.forward(request, response);
	}

}
