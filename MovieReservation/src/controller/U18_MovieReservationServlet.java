package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MovieReservationModel;

@WebServlet("/movieReservation")
public class U18_MovieReservationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//どの映画が選ばれたのか判定するために、ShowCodeを受け取る。
		String showCode = request.getParameter("showCode");

		//インスタンスを生成し、取得した映画情報を元に座席の最大数を取得する
		MovieReservationModel movieReservationModel = new MovieReservationModel();
		int maxSeatSpace = movieReservationModel.getMaxSeatSpace(showCode);

		System.out.println("1:"+maxSeatSpace);

		//すでに予約がされている座席を取得する。
		List<Integer> reservedSeatList = movieReservationModel.getReservedSeat(showCode);

		for(int i : reservedSeatList) {
			System.out.println(i+":"+i);
		}

		//リクエストスコープに、最大座席数を設定する。
		request.setAttribute("maxSeatSpace", maxSeatSpace);
		request.setAttribute("reservedSeatList", reservedSeatList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u18_movieReservation.jsp");
		dispatcher.forward(request, response);
	}
}
