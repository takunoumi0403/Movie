package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserMovieListBeans;
import model.UserMovieListModel;


@WebServlet("/movieList")
public class U17_MovieListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserMovieListModel userMovieModel = new UserMovieListModel();
		List<List<UserMovieListBeans>> oList = null;

		try {
			oList = userMovieModel.getMovieList();
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		String[] dList = userMovieModel.getWeek();


		request.setAttribute("oList", oList);
		request.setAttribute("dList", dList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u17_movieList.jsp");
		dispatcher.forward(request, response);
	}

}
