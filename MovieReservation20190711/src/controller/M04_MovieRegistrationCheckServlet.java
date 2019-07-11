package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regist_check")
public class M04_MovieRegistrationCheckServlet extends HttpServlet{
	
	 
	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session=request.getSession();
		String movieName=HtmlUtil.nl2be(request.getParameter("movieName"));
		String movieDescription=HtmlUtil.nl2be(request.getParameter("movieDescription"));
		String startYear=HtmlUtil.nl2be(request.getParameter("movieName"));
		String startMonth=HtmlUtil.nl2be(request.getParameter("movieName"));
		String startDay=HtmlUtil.nl2be(request.getParameter("movieName"));
		String endYear=HtmlUtil.nl2be(request.getParameter("movieName"));
		String endMonth=HtmlUtil.nl2be(request.getParameter("movieName"));
		String endDay=HtmlUtil.nl2be(request.getParameter("movieName"));
		//不明点
		String theaterNumber=HtmlUtil.nl2be(request.getParameter("movieName"));
		String startTime=HtmlUtil.nl2be(request.getParameter("movieName"));
		
		String movieAddress=HtmlUtil.nl2be(request.getParameter("movieName"));
		
		//不明点
		String thumbnail=HtmlUtil.nl2be(request.getParameter("movieName"));
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m04_movieRegistrationCheck.jsp");
		dispatcher.forward(request, response);
	}

}
