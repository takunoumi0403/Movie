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

@WebServlet("/uauth")
public class U02_LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Sessioを生成する
		HttpSession session = request.getSession();

		//画面遷用のdispatcherを生成する
		RequestDispatcher dispatcher = null;

		//メールとパスワードを受け取る。
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		//ユーザーモデルのインスタンスを生成する
		UserModel userModel = new UserModel();

		//ユーザーモデルの中のメソッド、Login(String,String)を実行する。
		UserInfoBeans userInfoBeans = userModel.login(mail,password);
		System.out.println(userInfoBeans);

		//ログイン情報の有無で遷移先を決定する。
		if(userInfoBeans != null) {
			//ログイン情報がある時
			session.setAttribute("userInfoBeans", userInfoBeans);
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
		}else {
			//ログイン情報がない時
			response.sendRedirect("login?erro=1");
			return;
		}

		//セッションにセットする
		session.setAttribute("userInfoBeans", userInfoBeans);

		//画面遷移する
		dispatcher.forward(request, response);
	}
}
