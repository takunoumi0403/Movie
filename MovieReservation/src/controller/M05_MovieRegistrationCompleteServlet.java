package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regist_complete")
public class M05_MovieRegistrationCompleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*HttpSession session=request.getSession();
		MasterInfoBeans masterInfoBeans=(MasterInfoBeans)session.getAttribute("masterInfoBeans");
		MovieRegistBeans movieRegistBeans=(MovieRegistBeans)session.getAttribute("movieRegistBeans");
		
		MovieMasterModel masterModel=new MovieMasterModel();
		/*int errorFlag=masterModel.regist(movieRegistBeans);*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m05_movieRegistrationComplete.jsp");
		dispatcher.forward(request, response);
	}

}
