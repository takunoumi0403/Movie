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

import beans.UserInfoBeans;
import beans.UserReservationBeans;

public class ReservationDao extends DaoBase {

	//SQL実行するためのインタフェースを生成
	PreparedStatement stmt = null;

	//Select分実行後のデータを取得するインタフェースを生成
	ResultSet rs = null;

	/**
	 * 予約済みの座席を取得するメソッド
	 * @param showCode
	 * @return
	 */
	public List<Integer> getReservedSeat(String showCode) {
		//リストの生成
		List<Integer> list = new ArrayList<Integer>();

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

	/**
	 * 予約を挿入するメソッド
	 * @param showCode
	 * @return
	 */
	public boolean insertReservation(List<UserReservationBeans> list,UserInfoBeans userInfoBeans) {
		try {
			//select文の発行
			stmt = con.prepareStatement("INSERT INTO reservation(`user_code`,`show_code`) VALUES(?,?)");

			//値をセットする
			stmt.setString(1, userInfoBeans.getUserCode());
			stmt.setString(2, list.get(0).getShowCode());

			stmt.executeUpdate();

			stmt = con.prepareStatement("SELECT reservation_code FROM reservation WHERE user_code = ? AND show_code = ?");
			stmt.setString(1, userInfoBeans.getUserCode());
			stmt.setString(2, list.get(0).getShowCode());

			rs = stmt.executeQuery();
			String reservationCode = null;

			while(rs.next()){
				reservationCode = rs.getString("reservation_code");
			}

			int i = 0;
			for(UserReservationBeans beans : list) {
				i++;
				//select文の発行
				stmt = con.prepareStatement("INSERT INTO reservation_details(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(?,?,?,?)");

				//値をセットする
				stmt.setString(1, reservationCode);
				stmt.setInt(2, i);
				stmt.setInt(3, ((Integer.parseInt(beans.getSeatNumber()))-1));
				stmt.setString(4, "1");
				stmt.executeUpdate();
				stmt = con.prepareStatement("UPDATE shows SET seat_space = seat_space - 1 WHERE show_code = ?;");
				stmt.setString(1, beans.getShowCode());
				stmt.executeUpdate();
			}

		}catch(Exception e) {
			e.printStackTrace();
			return false;
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

		return true;
	}

	/**
	 *
	 * @param userInfoBeans
	 * @return
	 */
	public List<UserReservationBeans> getUserReservationList(UserInfoBeans userInfoBeans) {
		List<UserReservationBeans> list = new ArrayList<UserReservationBeans>();

		try {
			stmt = con.prepareStatement("select s.show_date,r.reservation_code,rd.detail_number,m.movie_name,rd.seat_number,f.fee from reservation r inner join reservation_details rd on r.reservation_code = rd.reservation_code inner join shows s on r.show_code = s.show_code inner join movie m on s.movie_code = m.movie_code inner join fee f on rd.fee_code = f.fee_code WHERE user_code = ? AND s.show_date >= current_date ");
			stmt.setString(1, userInfoBeans.getUserCode());

			rs = stmt.executeQuery();

			while(rs.next()){
				UserReservationBeans beans = new UserReservationBeans();
				beans.setShowDate(rs.getString("show_date"));
				beans.setReservationCode(rs.getString("reservation_code"));
				beans.setReservationDetailsCode(rs.getString("detail_number"));
				beans.setMovieName(rs.getString("movie_name"));
				beans.setSeatNumber(rs.getString("seat_number"));
				beans.setFee(rs.getInt("fee"));
				list.add(beans);
			}

		}catch(Exception e) {
			e.printStackTrace();
			return null;
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

	/**
	 * 予約の削除を行うメソッド
	 * @param userCode
	 * @param reservationCode
	 * @param reservationDetailsCode
	 * @throws SQLException
	 */
	public void deleteUserReservation(String reservationCode, String reservationDetailsCode) throws SQLException {
		try {
			//showコードを取得
			stmt = con.prepareStatement("SELECT * FROM reservation WHERE reservation_code = ?");
			stmt.setString(1, reservationCode);

			rs = stmt.executeQuery();
			rs.next();
			String showCode = rs.getString("show_code");

			//予約詳細を削除
			stmt = con.prepareStatement("DELETE FROM reservation_details WHERE detail_number = ? AND reservation_code = ?");
			stmt.setString(1, reservationDetailsCode);
			stmt.setString(2, reservationCode);

			stmt.executeUpdate();

			//予約削除した分の席を一つ増やす
			stmt = con.prepareStatement("UPDATE shows SET seat_space = seat_space +1 WHERE show_code = ?");
			stmt.setString(1, showCode);

			stmt.executeUpdate();

		}catch(Exception e) {
			con.close();
		}finally {
			con.close();
		}
	}
}