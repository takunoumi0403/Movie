package controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/movie_list")
public class M06_MovieListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		////////////////////////////////////////////////////////////
		//DBから映画名を取得
		MasterMovieListModel listModel = new MasterMovieListModel();
		List<MovieListBeans> movieList = new ArrayList<MovieListBeans>();
		movieList=listModel.getMovieList();
		movieList=listModel.statusSet(movieList);

		HttpSession session = request.getSession();

		session.setAttribute("movieList",movieList);
		request.setAttribute("ReleaseFlag",0);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m06_movieList.jsp");
		dispatcher.forward(request, response);

	}

}