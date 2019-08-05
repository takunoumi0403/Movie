package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.MovieListBeans;
import beans.ReservationListBeans;

public class MasterReservationDao extends DaoBase {
	/**
	 * 映画一覧
	 * @return
	 * @throws SQLException
	 */
	public List<MovieListBeans> getMovieList() throws SQLException {
		List<MovieListBeans> movieList = new ArrayList<MovieListBeans>();

		if(con == null) {
			//接続していない場合は何もしない
			return movieList;
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			///////////////////////////////////
			//SELECT文の発行
			stmt = con.prepareStatement("SELECT movie_code, movie_name, movie_start, movie_finish FROM movie");

			rs = stmt.executeQuery();

			while(rs.next()){
				MovieListBeans beans = new MovieListBeans();

				beans.setMovieCode(rs.getInt("movie_code"));
				beans.setMovieName(rs.getString("movie_name"));
				beans.setMovieStart(rs.getDate("movie_start"));
				beans.setMovieFinish(rs.getDate("movie_finish"));
				beans.setShowFlag(true);
				movieList.add(beans);
			}

		}catch(SQLException e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}
		finally {
			//接続（コネクション）を閉じる
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					throw e;
				}
			}
		}
		return movieList;
	}



	/**
	 * 予約のリストを取得する
	 */
	public List<ReservationListBeans> getList(int number, String name){
		List<ReservationListBeans> list = new ArrayList<ReservationListBeans>();

		if(con == null) {
			//接続していない場合は何もしない
			return list;
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			///////////////////////////////////
			//SELECT文の発行
			stmt = con.prepareStatement(
					"SELECT reservation.reservation_code, reservation_details.detail_number, user.user_name, movie.movie_name, shows.theater_code, shows.show_date, fee.fee_type "
					+ "FROM user INNER JOIN reservation ON user.user_code=reservation.user_code "
					+ "INNER JOIN shows ON reservation.show_code=shows.show_code "
					+ "INNER JOIN movie ON shows.movie_code=movie.movie_code "
					+ "INNER JOIN reservation_details ON reservation.reservation_code=reservation_details.reservation_code "
					+ "INNER JOIN fee ON reservation_details.fee_code=fee.fee_code "
					+ "WHERE reservation.reservation_code=? AND user.user_name=?");
			stmt.setInt(1, number);
			stmt.setString(2, name);
			rs = stmt.executeQuery();

			//DBから値を取得
			while(rs.next()){
				ReservationListBeans beans = new ReservationListBeans();

				beans.setReservation_code(rs.getInt("reservation_code"));
				beans.setDetail_number(rs.getInt("detail_number"));
				beans.setName(rs.getString("user_name"));
				beans.setMovieName(rs.getString("movie_name"));
				beans.setTheater(rs.getString("theater_code"));
				beans.setShowDate(rs.getDate("show_date"));
				beans.setFeeType(rs.getString("fee_type"));

				list.add(beans);
			}

		}catch(SQLException e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
}
