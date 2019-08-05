package model;

import java.util.ArrayList;

public class UserMovieListModel {

	public List<MovieListBeans> getList(DATE date) throws Exception{

		List<MovieListBeans> list = new ArrayList<MovieListBeans>();

		MovieListDao dao = new MovieListDao();

		try{
			///////////////////////////////////
			//DBの接続
			dao.connect();

			list = dao.getMovieList(date);

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}
		finally {
			dao.close();
		}

		return list;
	}

}
