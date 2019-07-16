package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserMovieListBeans;

public class UserMovieListDao extends DaoBase{

	public List<UserMovieListBeans> getMovieList(String today, String aTommorow) throws SQLException{
		List<UserMovieListBeans> list = new ArrayList<UserMovieListBeans>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{

			///////////////////////////////////
			//SELECT文の発行
			stmt = con.prepareStatement("SELECT m.movie_code, movie_name, movie_time, movie_adress, "
					+ "movie_thumbnail, movie_description, s.show_code, show_date, t.theater_code, seat_space "
					+ "FROM shows s "
					+ "INNER JOIN movie m ON s.movie_code=m.movie_code "
					+ "INNER JOIN theater t ON s.theater_code=t.theater_code "
					+ "WHERE s.show_date BETWEEN ? AND ? "
					+ "ORDER BY m.movie_time, m.movie_code, t.theater_code");

			stmt.setString(1, today);
			stmt.setString(2, aTommorow);
			rs = stmt.executeQuery();

			/////////////////////////////////////
			//値の取得
			while(rs.next()){
				//////////////////////////////////
				//ビーンズのリストに格納する
				UserMovieListBeans userMovieListBeans = new UserMovieListBeans();

				userMovieListBeans.setMovieCode(rs.getString("movie_code"));
				userMovieListBeans.setMovieName(rs.getString("movie_name"));
				userMovieListBeans.setMovieTime(rs.getString("movie_time"));
				userMovieListBeans.setMovieAddress(rs.getString("movie_adress"));
				userMovieListBeans.setMovieThumbnail(rs.getString("movie_thumbnail"));
				userMovieListBeans.setMovieDescription(rs.getString("movie_description"));
				userMovieListBeans.setShowCode(rs.getString("show_code"));
				userMovieListBeans.setShowDate(rs.getString("show_date"));
				userMovieListBeans.setTheaterCode(rs.getString("theater_code"));

				list.add(userMovieListBeans);
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
				}
			}
		}

		return list;
	}
}
