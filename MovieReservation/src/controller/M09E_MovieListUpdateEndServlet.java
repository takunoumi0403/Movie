package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MovieRegistBeans;
@WebServlet("/update_end")
public class M09E_MovieListUpdateEndServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//Beansに格納されていた登録情報を削除し、登録完了画面に遷移
		HttpSession session=request.getSession();
		
		MovieRegistBeans MRBeans=(MovieRegistBeans)session.getAttribute("MRBeans");
		String name=MRBeans.getMovieName();
		String description=MRBeans.getMovieDescription();
		String hpaddress=MRBeans.getMovieAddress();
		
		request.setAttribute("name",name);
		request.setAttribute("description",description);
		request.setAttribute("hpaddress",hpaddress);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m09_movieListUpdateComplete.jsp");
		dispatcher.forward(request, response);
	}
	
	
}


