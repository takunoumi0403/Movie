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
	public List<ReservationListBeans> getList(){
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
					"SELECT reservation.reservation_code, user.user_name, movie.movie_name, show.theater_code, show.show_date, fee.fee_type"
					+ "FROM user INNER JOIN reservation ON user.user_code=reservation.user_code INNER JOIN show ON reservation.show_code=show.show_code INNER JOIN movie ON show.movie_code=movie.movie_code INNER JOIN "
					+ "reservation_details ON movie.reservation_code=reservation_details.reservation_code INNER JOIN fee ON reservation_details.fee_code=fee.fee_code"
					+ "WHERE ");

			rs = stmt.executeQuery();

			while(rs.next()){
				ReservationListBeans beans = new ReservationListBeans();

				beans.setReservation_code(rs.getString("reservation_code"));
				beans.setName(rs.getString("name"));
				beans.setMovieName(rs.getString("movieName"));
				beans.setTheater(rs.getString("theater"));
				beans.setShowDate(rs.getString("showDate"));
				beans.setFeeType(rs.getString("feeType"));

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
