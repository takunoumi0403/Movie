package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserInfoBeans;


@WebFilter("/*")
public class LoginCheckFilter implements Filter {


	@Override
	public void destroy() {
		//無処理
		;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		///////////////////////////////////////
		//リクエストのサーブレットパスを取得
		String servletPath = ((HttpServletRequest)request).getServletPath();

		System.out.println("servletPath:" + servletPath);
		//////////////////////////////////////
		//loginページ以外の場合は、ログインチェックを行う
		if("/login".equals(servletPath) != true &&
				"/uauth".equals(servletPath) != true &&
				"/signUp".equals(servletPath) != true &&
				"/top".equals(servletPath) != true &&
				"/movieList".equals(servletPath) != true){
			///////////////////////////////
			//ログインチェックを行う（セッションからログイン情報を取得してnullでなければOK)
			HttpSession session = ((HttpServletRequest) request).getSession();
			UserInfoBeans userInfoBeans = (UserInfoBeans) session.getAttribute("userInfoBeans");
			System.out.println(userInfoBeans);

			//ログイン情報がnullなら未ログイン
			if(userInfoBeans == null) {
				((HttpServletResponse) response).sendRedirect("login");
				return;
			}

		}

		//処理を続行する
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//無処理
		;
	}

}