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
import model.MasterMovieListModel;

@WebServlet("/movie_list_search")
public class M06R_MovieListSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		List<MovieListBeans> movieList = (List<MovieListBeans>)session.getAttribute("movieList");
		MasterMovieListModel listModel = new MasterMovieListModel();
		String keyword=request.getParameter("keyword");
		int ReleaseFlag=Integer.parseInt(request.getParameter("Release"));
		movieList=listModel.searchList(keyword,ReleaseFlag,movieList);
		
		session.setAttribute("movieList",movieList);
		request.setAttribute("ReleaseFlag",ReleaseFlag);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m06_movieList.jsp");
		dispatcher.forward(request, response);
		////////////////////////////////////////////////////////
		//画面を転送する（リダイレクト）
//		response.sendRedirect("movie_list");
	}

}