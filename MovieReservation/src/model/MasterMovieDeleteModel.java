package model;

import dao.MovieDao;
import dao.ShowsDao;

public class MasterMovieDeleteModel {
	
	public String delete(int MOVIE_CODE) {
		String Filename="";
		ShowsDao showsDao=new ShowsDao();
		try {
			showsDao.connect();
			showsDao.beginTransaction();
			showsDao.masterShowsDelete(MOVIE_CODE);
			MovieDao movieDao=new MovieDao(showsDao.getConnection());
			Filename=movieDao.masterMovieDelete(MOVIE_CODE);
			showsDao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			showsDao.rollback();
			
		}
		
		return Filename;
	}
}
