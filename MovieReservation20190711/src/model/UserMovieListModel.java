package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.UserMovieListBeans;
import dao.UserMovieListDao;

public class UserMovieListModel {

	public List<UserMovieListBeans> getMovieList() throws Exception{

		List<UserMovieListBeans> list = new ArrayList<UserMovieListBeans>();
		UserMovieListDao dao = new UserMovieListDao();

		Date date = new Date();

		try{
			///////////////////////////////////
			//DBの接続
			dao.connect();

			list = dao.getMovieList(date.toString());

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}

		return list;
	}

}
