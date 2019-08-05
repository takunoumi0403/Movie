package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MovieListBeans;
import model.MasterMovieDeleteModel;

@WebServlet("/movie_delete")
public class M10_MovieDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MasterMovieDeleteModel MMDModel=new MasterMovieDeleteModel();
		List<MovieListBeans> movieList=(List<MovieListBeans>)session.getAttribute("movieList");
		int number=Integer.parseInt(request.getParameter("number"));
		
		String Filename=MMDModel.delete(movieList.get(number).getMovieCode());
		
		File file = new File(M04_MovieRegistrationCheckServlet.UPLOADED+Filename);
		if (file.exists()==true){
		    file.delete();
		}

		
		((HttpServletResponse)response).sendRedirect("movie_list");
	}

}