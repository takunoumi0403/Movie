package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import beans.UserMovieListBeans;
import dao.UserMovieListDao;

public class UserMovieListModel {

	public List<List<UserMovieListBeans>> getMovieList() throws Exception{

		List<UserMovieListBeans> list = new ArrayList<UserMovieListBeans>();
		UserMovieListDao dao = new UserMovieListDao();

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_MONTH, 3);

		String today = cal1.get(Calendar.YEAR)+"-"+(cal1.get(Calendar.MONTH)+1)+"-"+cal1.get(Calendar.DATE)+" 00:00:00";
        String aTomorrow = cal2.get(Calendar.YEAR)+"-"+(cal2.get(Calendar.MONTH)+1)+"-"+(cal2.get(Calendar.DATE))+" 00:00:00";



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

		//////////////////////////////////////////
		//日付ごとのリストを作成
		List<UserMovieListBeans> iList = new ArrayList<UserMovieListBeans>();
		List<List<UserMovieListBeans>> oList = new ArrayList<List<UserMovieListBeans>>();
		UserMovieListBeans listBeans = list.get(0);
		String date = listBeans.getShowDate();
		int index = 0;

		for(UserMovieListBeans beans : list) {

			//日付判定
			if( !((beans.getShowDate()).equals(date)) ) {
				oList.add(iList);
				iList = new ArrayList<UserMovieListBeans>();
			}
			iList.add(beans);
			date = beans.getShowDate();

			//ループの最後
			if((list.size()-1) == index) {
				oList.add(iList);
			}
			index++;
		}

		return oList;
	}

	public String[] getWeek() {

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_MONTH, 1);
		Calendar cal3 = Calendar.getInstance();
		cal3.add(Calendar.DAY_OF_MONTH, 2);

		String[] week = new String[7];
        week[0] = "日";
        week[1] = "月";
        week[2] = "火";
        week[3] = "水";
        week[4] = "木";
        week[5] = "金";
        week[6] = "土";

        String date1 = (cal1.get(Calendar.MONTH)+1) + "/" + cal1.get(Calendar.DATE) + "（" + week[cal1.get(Calendar.DAY_OF_WEEK)-1] + "）";
        String date2 = (cal2.get(Calendar.MONTH)+1) + "/" + cal2.get(Calendar.DATE) + "（" + week[cal2.get(Calendar.DAY_OF_WEEK)-1] + "）";
        String date3 = (cal3.get(Calendar.MONTH)+1) + "/" + cal3.get(Calendar.DATE) + "（" + week[cal3.get(Calendar.DAY_OF_WEEK)-1] + "）";

        String[] dList = {date1, date2, date3};

        return dList;
	}

}
