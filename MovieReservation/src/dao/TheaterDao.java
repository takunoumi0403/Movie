/*
 * 予約テーブルに対する操作を行うためのDao
 *
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TheaterDao extends DaoBase {

	//SQL実行するためのインタフェースを生成
	PreparedStatement stmt = null;

	//Select分実行後のデータを取得するインタフェースを生成
	ResultSet rs = null;

	/**
	 * シアターごとの最大座席数を取得する。
	 * @param theaterCode
	 * @return
	 */
	public int getMaxSeatSpace(String theaterCode) {
		int maxSeatSpace = 0;

		//接続されているかどうか判定する
		if(con == null) {
			//接続がない場合
			return 0;
		}

		try {
			//select文の発行
			stmt = con.prepareStatement(
					"SELECT DISTINCT max_seat_space  " +
					"FROM shows INNER JOIN theater " +
					"ON shows.theater_code = theater.theater_code " +
					"WHERE shows.theater_code = ?;" +
					""
					);

			//値をセットする
			stmt.setString(1, theaterCode);

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
}
