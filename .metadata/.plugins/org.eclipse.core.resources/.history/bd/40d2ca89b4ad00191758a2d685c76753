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
import model.MovieReservationModel;

@WebServlet("/deleteUserReservationCheck")
public class U12_DeleteUserResevationCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションの生成
		HttpSession session = request.getSession();

		//値を受け取る
		UserInfoBeans userInfoBeans = (UserInfoBeans)session.getAttribute("userInfoBeans");
		String userCode = userInfoBeans.getUserCode();
		String reservationCode = request.getParameter("reservationCode");
		String reservationDetailsCode = request.getParameter("reservationDetailsCode");


		//モデルの作成
		MovieReservationModel movieReservationModel = new MovieReservationModel();

		try{
			//予約の削除
			movieReservationModel.deleteUserReservation(userCode,reservationCode,reservationDetailsCode);
		}catch(Exception e) {
			request.setAttribute("error", "実行中にエラーが発生しました。");
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u11_reservationDeleteCheck.jsp");
		dispatcher.forward(request, response);
	}

}
