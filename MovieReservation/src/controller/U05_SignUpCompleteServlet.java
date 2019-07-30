package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserInfoBeans;
import dao.UserDao;

@WebServlet("/signUpComplete")
public class U05_SignUpCompleteServlet extends HttpServlet {

	@Override


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		UserInfoBeans userbeans =new UserInfoBeans();
		String address =request.getParameter("address");
		String pass=request.getParameter("pass");
		String rpass=request.getParameter("rpass");
		String sei=request.getParameter("sei");
		String mei=request.getParameter("mei");
		String sex =request.getParameter("sex");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String userphone= request.getParameter("userphone");
		String resultsex=null;
		userbeans.setAddress(address);
		userbeans.setPass(pass);
		userbeans.setRpass(rpass);
		userbeans.setSei(sei);
		userbeans.setMei(mei);
		userbeans.setSex(sex);
		userbeans.setYear(year);
		userbeans.setMonth(month);
		userbeans.setDay(day);
		userbeans.setUserPhone(userphone);
             UserDao dao = new UserDao();

             try {
            	//データベース接続
                 dao.connect();
                 dao.insertUser(userbeans);
             } catch (Exception e) {

             }
             request.setAttribute("UserInfoBeans", userbeans);


		dispatcher.forward(request, response);

	}

}
