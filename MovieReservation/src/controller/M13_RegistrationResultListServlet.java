package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReservationListBeans;
import model.MasterMovieListModel;

@WebServlet("/registration_resultList")
public class M13_RegistrationResultListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Sessioを生成する
		HttpSession session = request.getSession();
		
		//JSPから予約番号か予約者名を取得
		int number = Integer.parseInt(request.getParameter("numbersearch"));
		String name = request.getParameter("namesearch");

		//Modelを呼び出しDBの値と照合する
		MasterMovieListModel listModel = new MasterMovieListModel();
		List<ReservationListBeans> reservationList =  listModel.getList(number,name);

		
		//予約情報の有無
		if(reservationList != null) {
			//予約情報がある時
			session.setAttribute("reservationList", reservationList);
		}else {
			//予約情報がない時
			response.sendRedirect("m12_registration_list?erro=1");
			return;
		}

		//セッションにセットする
		session.setAttribute("reservationList", reservationList);

		////////////////////////////////////////////////////////
		//画面を転送する（リダイレクト）
		response.sendRedirect("m13_registration_resultList");
	}

}