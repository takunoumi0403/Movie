package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserMovieListBeans;

public class UserMovieListDao extends DaoBase{

	public List<UserMovieListBeans> getMovieList(String date) throws SQLException{
		List<UserMovieListBeans> list = new ArrayList<UserMovieListBeans>();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{

			///////////////////////////////////
			//SELECT文の発行
			stmt = con.prepareStatement("SELECT movie_code, movie_name, movie_time, movie_address,"
					+ "movie_thumbnail, movie_description, show_code,theater_code, seat_space"
					+ "FROM show"
					+ "INNER JOIN movie ON show.movie_code = movie.movie_code"
					+ "INNER JOIN theater ON show.theater_code = theater.theater_code"
					+ "WHERE show.show_date = ?;");

			stmt.setString(1, date);
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
				userMovieListBeans.setMovieAddress(rs.getString("movie_address"));
				userMovieListBeans.setMovieThumbnail(rs.getString("movie_thumbnail"));
				userMovieListBeans.setMovieDescription(rs.getString("movie_description"));
				userMovieListBeans.setShowCode(rs.getString("show_code"));
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
