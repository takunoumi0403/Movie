package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteUserReservation")
public class U11_DeleteUserResevationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//値を受け取る
		String reservationCode = request.getParameter("reservationCode");
		String reservationDetailsCode = request.getParameter("reservationDetailsCode");

		request.setAttribute("reservationCode", reservationCode);
		request.setAttribute("reservationDetailsCode", reservationDetailsCode);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u11_reservationDeleteCheck.jsp");
		dispatcher.forward(request, response);
	}
}
