package model;

import dao.ShowDao;

public class MovieReservationModel {
	public int createSeats(String showCode) {
		//最大座席数を格納するための変数
		int maxSeatSpace = 0;

		//Daoのインスタンスを生成する。
		ShowDao showDao = new ShowDao();

		try {
			//データベースに接続
			showDao.connect();

			//シアターコードを元に最大座席数を取得する。
			maxSeatSpace = showDao.getMaxSeatSpace(showCode);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return maxSeatSpace;
	}
}
