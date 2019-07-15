package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MasterLoginModel;

@WebServlet("/auth")
public class M02_LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/////////////////////////////////////////////
		//jspからid,password取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		///////////////////////////////////////////
		//Modelを呼び出しDBの値をid、passwordを照合する
		MasterLoginModel masterLoginModel = new MasterLoginModel();
		String loginId = masterLoginModel.login(id, pass);

		////////////////////////////////////////////
		//session
		HttpSession session = request.getSession();
		if( loginId != null ){
//			///////////////////////////////////////////
//			//ログイン結果をセッションに保存する
			session.setAttribute("loginId", loginId);

		}else{
//			//ログイン結果がnullの場合はログイン画面に戻す

			response.sendRedirect("mastersLogin?errflg=1");
			return;
		}




		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/m01_loginStart.jsp");
		dispatcher.forward(request, response);
		///////////////////////////////////////////
		//画面を転送する（リダイレクト）
//		response.sendRedirect("mastersTop");
	}
}