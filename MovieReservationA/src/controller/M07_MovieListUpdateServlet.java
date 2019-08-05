package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MovieListBeans;
import beans.MovieRegistBeans;
import model.MasterMovieUpdateModel;

@WebServlet("/movie_ListUpdate")
public class M07_MovieListUpdateServlet extends HttpServlet{
	
	public int MOVIE_CODE;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		int number=Integer.parseInt(request.getParameter("number"));
		List<MovieListBeans> movieList=(List<MovieListBeans>)session.getAttribute("movieList");
		
		MOVIE_CODE=movieList.get(number).getMovieCode();
		MasterMovieUpdateModel MMUModel=new MasterMovieUpdateModel();
		
		MovieRegistBeans MRBeans = MMUModel.getMovieInfo(MOVIE_CODE);
		
		//List<MovieTheaterUpdateBeans> MTUBeansList=MMUModel.getShowsInfo(MOVIE_CODE);
		
		//List<MovieTheaterRegistBeans> MTRBeansList=MMUModel.changeRegist(MTUBeansList);
		
		int hour=MRBeans.getMovieTime()/60;
		int minute=MRBeans.getMovieTime()%60;
		
		//request.setAttribute("MTRBenasList", MTRBeansList);
		session.setAttribute("MOVIE_CODE",MOVIE_CODE);
		request.setAttribute("MRBeans",MRBeans);
		request.setAttribute("hour",hour);
		request.setAttribute("minute",minute);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m07_movieListUpdateServlet.jsp");
		dispatcher.forward(request, response);
	}

}
