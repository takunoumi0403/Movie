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
import model.UserModel;

@WebServlet("/userInfoChange")
public class U07_3_UserInfoChangeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//せっしょnの生成
		HttpSession session = request.getSession(true);

		//せっしょnからコードを受け取る
		UserInfoBeans beans = (UserInfoBeans)session.getAttribute("userInfoBeans");


		String address=	request.getParameter("address");
		String pass=request.getParameter("pass");
		String userName= request.getParameter("uname");
		String userPhone=request.getParameter("userphone");

		UserInfoBeans bean = new UserInfoBeans();
		bean.setUserCode(beans.getUserCode());
		bean.setAddress(address);
		bean.setPass(pass);
		bean.setUserName(userName);
		bean.setUserPhone(userPhone);

		UserModel model = new UserModel();

		boolean flg = model.update(bean);

		RequestDispatcher dispatcher;

		if(flg) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeComplete.jsp");
		}else {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeComplete.jsp");
		}

		dispatcher.forward(request, response);
	}

}
