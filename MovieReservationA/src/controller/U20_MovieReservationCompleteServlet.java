package controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/movieReservationComplete")
public class U20_MovieReservationCompleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sessionの生成
		HttpSession session = request.getSession();

		//sessionから情報を受け取る
		List<UserReservationBeans> list = (ArrayList<UserReservationBeans>)session.getAttribute("list");
		UserInfoBeans userInfoBeans = (UserInfoBeans)session.getAttribute("userInfoBeans");

		//Modelのインスタンス生成
		MovieReservationModel reservationModel = new MovieReservationModel();

		//listを元に予約を行う
		boolean flg = reservationModel.insertReservation(list,userInfoBeans);

		//セッションの吐き
		session.removeAttribute("list");

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u20_movieReservationComplete.jsp");
		dispatcher.forward(request, response);

	}

}
