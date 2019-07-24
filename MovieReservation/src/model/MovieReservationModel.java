package model;

import java.util.ArrayList;
import java.util.List;

import beans.UserInfoBeans;
import beans.UserReservationBeans;
import dao.ReservationDao;
import dao.ShowDao;

public class MovieReservationModel {
	/**
	 * 最大座席数を取得する
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
		ReservationDao reservationDao = new ReservationDao();

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

	/**
	 * 選択された席と、上映コードを元に 映画予約を行う。
	 * @param selectSeats
	 * @param showCode
	 * @return
	 */
	public boolean insertReservation(List<UserReservationBeans> list,UserInfoBeans userInfoBeans) {
		//予約インスタンスの生成
		ReservationDao reservationDao = new ReservationDao();
		try {
			reservationDao.connect();

			//挿入処理を行う
			boolean flg = reservationDao.insertReservation(list,userInfoBeans);

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 予約する映画の情報をリスト型で返すメソッド
	 * @param selectSeats
	 * @param showCode
	 * @param userInfoBeans
	 * @return
	 */
	public List<UserReservationBeans> getReservationInfo(String[] selectSeats, String showCode) {
		//DAOのインスタンスの生成
		ShowDao showDao = new ShowDao();

		//Listの生成
		List<UserReservationBeans> list = null;

		try {
			//データベースに接続
			showDao.connect();

			//showCodeを元に、映画名などを取得する。
			list = showDao.getReservationInfo(selectSeats,showCode);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * ユーザーが予約した映画情報のListを取得して返すメソッド
	 * @param userInfoBeans
	 * @return
	 */
	public List<UserReservationBeans> getUserReservationList(UserInfoBeans userInfoBeans) {
		//listの生成
		List<UserReservationBeans> list = null;

		//Daoの生成
		ReservationDao reservationDao = new ReservationDao();
		try {
			reservationDao.connect();

			list = reservationDao.getUserReservationList(userInfoBeans);


		}catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 会員の予約を削除するメソッド
	 * @param reservationCode
	 * @param reservationDetailsCode
	 * @param reservationDetailsCode2
	 */
	public void deleteUserReservation(String userCode,String reservationCode, String reservationDetailsCode) throws Exception{
		//Daoの生成
		ReservationDao reservationDao = new ReservationDao();

		//データベースに接続
		reservationDao.connect();

		//予約を削除する
		reservationDao.deleteUserReservation(userCode,reservationCode,reservationDetailsCode);
	}
}
