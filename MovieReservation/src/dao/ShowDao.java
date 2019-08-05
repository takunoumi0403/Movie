/*
 * 映画テーブルに対する操作を行うためのDao
 *
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserReservationBeans;

public class ShowDao extends DaoBase {

	//SQL実行するためのインタフェースを生成
	PreparedStatement stmt = null;

	//Select分実行後のデータを取得するインタフェースを生成
	ResultSet rs = null;


	/**
	 * シアターごとの最大座席数を取得する。
	 * @param theaterCode
	 * @return
	 */
	public int getMaxSeatSpace(String showCode) {
		int maxSeatSpace = 0;

		//接続されているかどうか判定する
		if(con == null) {
			//接続がない場合
			return 0;
		}

		try {
			//select文の発行
			stmt = con.prepareStatement(
					"SELECT DISTINCT theater.max_seat_space FROM shows INNER JOIN theater ON shows.theater_code = theater.theater_code WHERE shows.show_code = ?;"
					);

			//値をセットする
			stmt.setString(1, showCode);

			rs = stmt.executeQuery();

			while(rs.next()) {
				maxSeatSpace = rs.getInt("max_seat_space");
			}

		}catch(Exception e) {
		}finally {
			//データベースの接続を切る
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
				}
			}
		}

		return maxSeatSpace;
	}


	/**
	 * 予約する情報を取得する
	 * @param selectSeats
	 * @param showCode
	 * @return
	 */
	public List<UserReservationBeans> getReservationInfo(String[] selectSeats, String showCode) {

		List<UserReservationBeans> list = new ArrayList<UserReservationBeans>();

		//接続されているかどうか判定する
		if(con == null) {
			//接続がない場合
			return null;
		}
		try {
			//select文の発行
			stmt = con.prepareStatement("SELECT show_code,movie_name,show_date,theater_code FROM shows INNER JOIN movie ON shows.movie_code = movie.movie_code WHERE shows.show_code = ?");

			//値をセットする
			stmt.setString(1, showCode);

			rs = stmt.executeQuery();

			rs.next();

			for(int i = 0; i < selectSeats.length; i++){
				UserReservationBeans beans = new UserReservationBeans();
				beans.setMovieName(rs.getString("movie_name"));
				beans.setShowDate(rs.getString("show_date"));
				beans.setTheaterCode(rs.getString("theater_code"));
				beans.setShowCode(rs.getString("show_code"));
				beans.setSeatNumber(selectSeats[i]);
				list.add(beans);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//データベースの接続を切る
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
				}
			}
		}
		return list;
	}
}
