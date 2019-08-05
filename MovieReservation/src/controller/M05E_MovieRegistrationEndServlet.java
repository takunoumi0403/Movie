package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MovieRegistBeans;
import beans.MovieTheaterRegistBeans;
import model.Date_Change;

@WebServlet("/regist_end")
public class M05E_MovieRegistrationEndServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//Beansに格納されていた登録情報を削除し、登録完了画面に遷移
		HttpSession session=request.getSession();
		
		MovieRegistBeans MRBeans=(MovieRegistBeans)session.getAttribute("MRBeans");
		List<MovieTheaterRegistBeans> MTRBeansList=(List<MovieTheaterRegistBeans>)session.getAttribute("MTRBeansList");
		String name=MRBeans.getMovieName();
		String description=MRBeans.getMovieDescription();
		int time=MRBeans.getMovieTime();
		Date start=MRBeans.getStartDate();
		Date end=MRBeans.getEndDate();
		Date_Change DSC=new Date_Change();
		
		request.setAttribute("name",name);
		request.setAttribute("description",description);
		request.setAttribute("time",time);
		request.setAttribute("start",DSC.StringChange(start));
		request.setAttribute("end", DSC.StringChange(end));
		request.setAttribute("MTRBeansList",MTRBeansList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m05_movieRegistrationComplete.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
