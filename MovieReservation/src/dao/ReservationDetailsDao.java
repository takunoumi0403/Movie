/*
 * 予約テーブルに対する操作を行うためのDao
 *
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDetailsDao extends DaoBase {

	//SQL実行するためのインタフェースを生成
	PreparedStatement stmt = null;

	//Select分実行後のデータを取得するインタフェースを生成
	ResultSet rs = null;

	/**
	 *
	 * @param showCode
	 * @return
	 */
	public List<Integer> getReservedSeat(String showCode) {
		//リストの生成
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(showCode);

		try {
			//select文の発行
			stmt = con.prepareStatement("SELECT seat_number FROM reservation INNER JOIN reservation_details ON reservation.reservation_code = reservation_details.reservation_code WHERE show_code = ?;");

			//値をセットする
			stmt.setString(1, showCode);

			rs = stmt.executeQuery();

			while(rs.next()) {
				list.add(rs.getInt("seat_number"));
			}

		}catch(Exception e) {
		}finally {
			//データベースの接続を切る
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
