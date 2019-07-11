package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import beans.UserMovieListBeans;
import dao.UserMovieListDao;

public class UserMovieListModel {

	public List<UserMovieListBeans> getMovieList() throws Exception{

		List<UserMovieListBeans> list = new ArrayList<UserMovieListBeans>();
		UserMovieListDao dao = new UserMovieListDao();

		Calendar cal1 = Calendar.getInstance();
		String today = cal1.get(Calendar.YEAR)+"-"+cal1.get(Calendar.MONTH)+"-"+cal1.get(Calendar.DATE)+" 00:00:00";

		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, +1);
		Date date2 = new Date();
		date2 = cal2.getTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy'-'MM'-'dd' 'k':'mm':'ss");
        sdf2.format(date2);

/*		Calendar cal3 = Calendar.getInstance();
		cal3.add(Calendar.DATE, +2);
		Date date3 = new Date();
		date3 = cal3.getTime();
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy'-'MM'-'dd' 'k':'mm':'ss");
        sdf3.format(date3);
*/
        String aTomorrow = cal1.get(Calendar.YEAR)+"-"+cal1.get(Calendar.MONTH)+"-"+(cal1.get(Calendar.DATE)+3)+" 00:00:00";

		try{
			///////////////////////////////////
			//DBの接続
			dao.connect();

			list = dao.getMovieList(today, sdf2.format(date2), aTomorrow);

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}

		return list;
	}

}
