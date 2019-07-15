package model;

import java.util.ArrayList;
import java.util.List;

import dao.ReservationDetailsDao;
import dao.ShowDao;

public class MovieReservationModel {
	/**
	 *
	 * @param showCode
	 * @return
	 */
	public int getMaxSeatSpace(String showCode) {
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

	/**
	 * すでに予約済みの席を取得するメソッド
	 * @param showCode
	 * @return
	 */
	public List<Integer> getReservedSeat(String showCode) {
		//Daoのインスタンスを生成する。
		ReservationDetailsDao reservationDao = new ReservationDetailsDao();

		//戻り値のListを生成する
		List<Integer> list = new ArrayList<Integer>();

		try {
			//DB接続
			reservationDao.connect();

			//showCodeを元に予約済みの座席を取得する。
			list = reservationDao.getReservedSeat(showCode);

		}catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
