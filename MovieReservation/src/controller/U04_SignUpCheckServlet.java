package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserInfoBeans;



@WebServlet("/signUpCheck")
public class U04_SignUpCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		String message = new String();



		HttpSession session=request.getSession();
		String address =request.getParameter("address");
		String pass=request.getParameter("pass");
		String rpass=request.getParameter("rpass");
		String sei=request.getParameter("sei");
		String mei=request.getParameter("mei");
		String sex =request.getParameter("sex");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String userphone=request.getParameter("userphone");
		String resultsex=null;
		if(address.equals("")) {
			message="メールアドレスを入力してください";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);
		}

		if (pass.equals("")) {
			message = "パスワードを入力してください";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);

		}
		if (! pass.equals(rpass)) {
			message = "パスワードが一致しません";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);
		}
		if(sei.equals("")) {
			message="名字を入力してください";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);
		}
		if(mei.equals("")) {
			message="名前を入力してください";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);
		}
		if(userphone.equals("")) {
			message="電話番号を入力してください";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);
		}
		if(sex.equals("")) {
			message="性別を入力してください";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);
		}
		if(year.equals("")||month.equals("")||day.equals("")) {
			message="生年月日を入力してください";
			request.setAttribute("mess", message);
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/signup.jsp");
			dispatch.forward(request, response);
		}







		if(sex.equals("0")) {
			//男
			resultsex="男";
		}else if(sex.equals("1")) {
			//女
			resultsex="女";

		}else {
			//その他
			resultsex="その他";
		}

		UserInfoBeans userbeans =new UserInfoBeans();
		System.out.print(address);
		System.out.print(pass);
		System.out.print(sei);


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

		request.setAttribute("UserInfoBeans", userbeans);

		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/jsp/Signkakunin.jsp");
		dispatch.forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		doPost(req,resp);
	}






}









