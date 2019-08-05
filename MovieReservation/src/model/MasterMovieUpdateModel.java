package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.MovieRegistBeans;
import beans.MovieTheaterRegistBeans;
import beans.MovieTheaterUpdateBeans;
import dao.MovieDao;

public class MasterMovieUpdateModel {
	
	/*public List<MovieTheaterUpdateBeans> getShowsInfo(int movie_code){
		
		List<MovieTheaterUpdateBeans> MTUBeansList=new ArrayList<MovieTheaterUpdateBeans>();
		ShowsDao showsDao=new ShowsDao();
		
		try {
			showsDao.connect();
			MTUBeansList=showsDao.masterShowsUpdate(movie_code);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return MTUBeansList;
	}*/
	public MovieRegistBeans getMovieInfo(int movie_code) {
		MovieDao movieDao=new MovieDao();
		MovieRegistBeans MRBeans=new MovieRegistBeans();
		try {
			movieDao.connect();
			MRBeans=movieDao.masterMovieGetInfo(movie_code);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return MRBeans;
	}
	
	
	public List<MovieTheaterRegistBeans> changeRegist(List<MovieTheaterUpdateBeans> MTUBeansList){
		
		List<MovieTheaterRegistBeans> MTRBeansList=new ArrayList<MovieTheaterRegistBeans>();
		for(int i=0;i<MTUBeansList.size();i++) {
			MovieTheaterRegistBeans MTRBeans=new MovieTheaterRegistBeans();
			MTRBeans.setTheaterNumber(MTUBeansList.get(i).getTheaterNumber());
			for(int n=0;n<MTUBeansList.get(i).getShowDate().size();n++) {
				int Intdate[]=dateIntChange(MTUBeansList.get(i).getShowDate().get(n));
				MTRBeans.pushTheaterStartHour(Intdate[0]);
				MTRBeans.pushTheaterStartMinute(Intdate[1]);
			}
			MTRBeansList.add(MTRBeans);
		}
		return MTRBeansList;
	}
	public int[] dateIntChange(Date date) {
		
		String str=new SimpleDateFormat("hh:mm").format(date);
		String[] strs=str.split(":",0);
		int[] Intdate= {Integer.parseInt(strs[0]),Integer.parseInt(strs[1])};
		return Intdate;
	}
	public String[] dateStringChange(Date date) {
		String str=new SimpleDateFormat("yyyy-MM-dd").format(date);
		String[] strs=str.split("-",0);
		return strs;
		
	}
	public int update(MovieRegistBeans MRBeans,int MOVIE_CODE) {
		int ErrorFlag=1;
		MovieDao movieDao=new MovieDao();
		
		try {
			//DB接続
			movieDao.connect();
			
			movieDao.masterMovieUpdate(MRBeans,MOVIE_CODE);
			
			ErrorFlag=0;
		}catch(Exception e) {
			e.printStackTrace();
			movieDao.rollback();
			ErrorFlag=1;
		}finally {
			movieDao.close();
		}
		return ErrorFlag;
	}
	
}
