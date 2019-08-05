package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MovieRegistBeans;
import model.MasterMovieUpdateModel;

@WebServlet("/update_complete")
public class M09_MovieListUpdateCompleteServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int MOVIE_CODE=(int)session.getAttribute("MOVIE_CODE");
		MovieRegistBeans MRBeans=(MovieRegistBeans)session.getAttribute("MRBeans");
		
		MasterMovieUpdateModel MMUModel=new MasterMovieUpdateModel();
		int errorFlag=MMUModel.update(MRBeans,MOVIE_CODE);
		session.setAttribute("errorFlag",errorFlag);
		((HttpServletResponse)response).sendRedirect("update_end");
	}
}
