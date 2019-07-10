package model;

import beans.UserMovieListBeans;
import dao.ReservationDao;

public class MovieReservationModel {
	public int createSeats(UserMovieListBeans userMovieListBeans) {
		//最大座席数を格納するための変数
		int maxSeatSpace = 0;

		//ビーンズからシアターコードを取得する。
		String theaterCode = userMovieListBeans.getTheaterCode();

		//Daoのインスタンスを生成する。
		ReservationDao reservationDao = new ReservationDao();

		try {
			//データベースに接続
			reservationDao.connect();

			//シアターコードを元に最大座席数を取得する。
			maxSeatSpace = reservationDao.getMaxSeatSpace(theaterCode);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return maxSeatSpace;
	}
}
