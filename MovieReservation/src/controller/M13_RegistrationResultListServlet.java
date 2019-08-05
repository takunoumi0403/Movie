package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReservationListBeans;
import model.MasterMovieListModel;

@WebServlet("/registration_resultList")
public class M13_RegistrationResultListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//JSPから予約番号か予約者名を取得
		int number = Integer.parseInt(request.getParameter("numbersearch"));
		String name = request.getParameter("namesearch");

		//Modelを呼び出しDBの値と照合する
		MasterMovieListModel listModel = new MasterMovieListModel();
		List<ReservationListBeans> reservationList =  listModel.getList(number,name);

		//リクエストにセット
		request.setAttribute("reservationList", reservationList);

		/////////////////////////////////////////////////////////
		//画面転送
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration_resultList.jsp");
		dispatcher.forward(request, response);

		////////////////////////////////////////////////////////
		//画面を転送する（リダイレクト）
//		response.sendRedirect("registration_list");
	}

}