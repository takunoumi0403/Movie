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

@WebServlet("/movieReservationCheck")
public class U19_MovieReservationCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションの生成
		HttpSession session = request.getSession();

		//チェックボックスの内容を配列型で受け取る。
		String[] selectSeats = request.getParameterValues("vacantSeat");

		//Beansの生成
		UserInfoBeans userInfoBeans = (UserInfoBeans)session.getAttribute("userInfoBeans");

		//モデルのインスタンスを生成する
		MovieReservationModel reservationModel = new MovieReservationModel();

		//上映コードを受け取る
		String showCode = request.getParameter("showCode");

		//選択した席、上映コード、ユーザーの情報を元に、予約する映画の詳細をリスト型で受け取る。
		List<UserReservationBeans> list = reservationModel.getReservationInfo(selectSeats,showCode);

		//リクエストスコープにListを格納する
		session.setAttribute("list", list);


		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u19_movieReservationCheck.jsp");
		dispatcher.forward(request, response);
	}

}
