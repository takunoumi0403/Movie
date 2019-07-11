package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/movieReservation")
public class U18_MovieReservationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//どの映画が選ばれたのか番号で受け取る。
//		int movieNumber = Integer.parseInt(request.getParameter("名前"));
//
//		//Listから選択された映画の情報を取得する。
//		List<UserMovieListBeans> list = (List<UserMovieListBeans>)request.getAttribute("list");
//		UserMovieListBeans userMovieListBeans = list.get(movieNumber);
//
//		//インスタンスを生成し、取得した映画情報を元に座席の最大数を取得する
//		MovieReservationModel movieReservationModel = new MovieReservationModel();
//		int maxSeatSpace = movieReservationModel.createSeats(userMovieListBeans);
//
//		//リクエストスコープに、最大座席数を設定する。
//		request.setAttribute("maxSeatSpace", maxSeatSpace);
		HttpSession session = request.getSession();
		session.setAttribute("a", "a");

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u18_movieReservation.jsp");
		dispatcher.forward(request, response);
	}

}
