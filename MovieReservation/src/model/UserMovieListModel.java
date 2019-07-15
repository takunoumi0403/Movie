package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import beans.UserMovieListBeans;
import dao.UserMovieListDao;

public class UserMovieListModel {

	public List<UserMovieListBeans> getMovieList() throws Exception{

		List<UserMovieListBeans> list = new ArrayList<UserMovieListBeans>();
		UserMovieListDao dao = new UserMovieListDao();

		Calendar cal1 = Calendar.getInstance();
		String today = cal1.get(Calendar.YEAR)+"-"+(cal1.get(Calendar.MONTH)+1)+"-"+cal1.get(Calendar.DATE)+" 00:00:00";

        String aTomorrow = cal1.get(Calendar.YEAR)+"-"+(cal1.get(Calendar.MONTH)+1)+"-"+(cal1.get(Calendar.DATE)+3)+" 00:00:00";

		try{
			///////////////////////////////////
			//DBの接続
			dao.connect();

			list = dao.getMovieList(today, aTomorrow);

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}

		return list;
	}

}
