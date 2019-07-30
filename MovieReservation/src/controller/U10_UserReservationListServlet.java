package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserInfoBeans;
import beans.UserReservationBeans;
import model.MovieReservationModel;

@WebServlet("/userReservationList")
public class U10_UserReservationListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザ情報を取得
		HttpSession session = request.getSession();
		UserInfoBeans userInfoBeans = (UserInfoBeans)session.getAttribute("userInfoBeans");
		session.removeAttribute("list");
		request.removeAttribute("list");

		//
		MovieReservationModel reservationModel = new MovieReservationModel();
		List<UserReservationBeans> list = reservationModel.getUserReservationList(userInfoBeans);

		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u10_userReservationList.jsp");
		dispatcher.forward(request, response);
	}

}
