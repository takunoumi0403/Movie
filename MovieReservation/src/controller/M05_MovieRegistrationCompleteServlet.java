package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MovieRegistBeans;
import beans.MovieTheaterRegistBeans;
import model.MasterMovieRegistModel;

@WebServlet("/regist_complete")
public class M05_MovieRegistrationCompleteServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		
		MovieRegistBeans MRBeans=(MovieRegistBeans)session.getAttribute("MRBeans");
		String thumbnail=MRBeans.getThumbnail();
		if(thumbnail!=null) {
			MRBeans.setThumbnail(getJudgeDirName(MRBeans));
		}else {
			MRBeans.setThumbnail(null);
		}
		List<MovieTheaterRegistBeans> MTRBeansList=(List<MovieTheaterRegistBeans>)session.getAttribute("MTRBeansList");
		//insertメソッドを呼び出す
		MasterMovieRegistModel MMRModel=new MasterMovieRegistModel();
		int errorFlag=MMRModel.regist(MRBeans,MTRBeansList);
		if(errorFlag!=1) {
			copy(M04_MovieRegistrationCheckServlet.UPLOAD+thumbnail,M04_MovieRegistrationCheckServlet.UPLOADED+MRBeans.getThumbnail());
			File file=new File(M04_MovieRegistrationCheckServlet.UPLOAD+thumbnail);
			file.delete();
			
		}
		session.setAttribute("errorFlag",errorFlag);
		((HttpServletResponse)response).sendRedirect("regist_end");
	}
	public static void copy(String srcPath,String dsPath)throws IOException{
		File f =new File(dsPath);
		f.getParentFile().mkdirs();
		Files.copy(
				new File(srcPath).toPath(),
				new File(dsPath).toPath()
				);
		
	}
	private String getJudgeDirName(MovieRegistBeans MRBeans)   {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddhhmmSSS");
		String timeStr=format.format(date);
		return timeStr+MRBeans.getThumbnail();
	}
}
