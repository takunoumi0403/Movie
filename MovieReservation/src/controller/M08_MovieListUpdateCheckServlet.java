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

import beans.MovieRegistBeans;

@WebServlet("/update_check")

public class M08_MovieListUpdateCheckServlet extends HttpServlet{
	String errorMsg;
	final int sabun=30;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException  {
		
		HttpSession session=request.getSession();
		int MOVIE_CODE = (int)session.getAttribute("MOVIE_CODE");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//エラーメッセージ一覧
		List<String> errorMsgs=new ArrayList<String>();
		
		//映画情報Beans呼び出し
		MovieRegistBeans MRBeans=new MovieRegistBeans();
		//映画名取得
		MRBeans.setMovieName(request.getParameter("movie_name"));
		
		
		//映画説明文取得
		MRBeans.setMovieDescription(request.getParameter("movie_description"));
		if(MRBeans.getMovieDescription().length()==0) {
			errorMsgs.add("映画の説明文が入力されていません");
		}
		//HPアドレス取得
		MRBeans.setMovieAddress(HtmlUtil.nl2be(request.getParameter("movie_address")));
		
		if(errorMsgs.size()==0) {
			session.setAttribute("MRBeans", MRBeans);
			session.setAttribute("MOVIE_CODE",MOVIE_CODE);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("WEB-INF/jsp/m08_movieListUpdateCheckServlet.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errorMsgs",errorMsgs);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("WEB-INF/jsp/m07_movieListUpdateServlet.jsp");
			dispatcher.forward(request, response);
		}
	}
}