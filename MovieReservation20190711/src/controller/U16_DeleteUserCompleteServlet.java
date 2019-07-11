package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDeleteModel;

@WebServlet("/deleteUserComplete")
public class U16_DeleteUserCompleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDeleteModel model = new UserDeleteModel();
		model.deleteUser();

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u16_deleteUserComplete.jsp");
		dispatcher.forward(request, response);
	}

}
