package model;

import java.util.List;

import beans.MovieRegistBeans;
import beans.MovieTheaterRegistBeans;
import dao.MovieDao;
import dao.ShowsDao;

public class MasterMovieRegistModel {
	private  int ErrorFlag=1;
	public int regist(MovieRegistBeans MRBeans,List<MovieTheaterRegistBeans> MTRBeansList) {
		
		MovieDao movieDao=new MovieDao();
		
		long dayDiff=(MRBeans.getEndDate().getTime()-MRBeans.getStartDate().getTime())/(1000*60*60*24);
		try {
			//DB接続
			movieDao.connect();
			movieDao.beginTransaction();
			int movieCode=movieDao.masterMovieInsert(MRBeans,MTRBeansList);
			ShowsDao showsDao=new ShowsDao(movieDao.getConnection());
			showsDao.masterShowsInsert(MRBeans, MTRBeansList, movieCode, (int)dayDiff);
			
			movieDao.commit();
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
