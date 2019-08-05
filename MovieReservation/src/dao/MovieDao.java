package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.MovieRegistBeans;
import beans.MovieTheaterRegistBeans;

public class MovieDao extends DaoBase{
	public MovieDao() {
	}
	public MovieDao(Connection con) {
		super(con);
	}
	public int masterMovieInsert(MovieRegistBeans MRBeans,List<MovieTheaterRegistBeans> MTRBeansList) throws SQLException {
		int movieCode=-1;
		int count=0;
		
		
		if(con==null) {
			//接続していない場合は何もしない
			return -1;
		}
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			///SELECT文の発行
			stmt = con.prepareStatement("INSERT INTO movie"  
					+"(movie_name,movie_time,movie_start,movie_finish,movie_adress,movie_thumbnail,movie_description)"  
					+"VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1,MRBeans.getMovieName());
			stmt.setInt(2,MRBeans.getMovieTime());
			stmt.setDate(3,new java.sql.Date( MRBeans.getStartDate().getTime()));
			stmt.setDate(4,new java.sql.Date(MRBeans.getEndDate().getTime()));
			stmt.setString(5,MRBeans.getMovieAddress());
			stmt.setString(6,MRBeans.getThumbnail());
			stmt.setString(7,MRBeans.getMovieDescription());
			stmt.executeUpdate();
			stmt=con.prepareStatement("SELECT last_insert_id() as last");
			rs=stmt.executeQuery();
			if(rs.next()) {
				movieCode=rs.getInt("last");
			}
			List<String> tcode=new ArrayList<String>();
			for(int i=0;i<MTRBeansList.size();i++) {
				tcode.add(MTRBeansList.get(i).getTheaterNumber());
			}
			String where ="";
			for(int i=0;i<tcode.size();i++) {
				where+="?";
				if(i+1!=tcode.size()) {
					where+=",";
				}
			}
			//String tc=tcode.stream().collect(Collectors.joining(","));
			stmt=con.prepareStatement("SELECT theater_code,max_seat_space FROM theater WHERE theater_code IN("+where+")");
			for(int i=1;i<=tcode.size();i++) {
				stmt.setString(i,tcode.get(i-1));
			}
			rs=stmt.executeQuery();
			while(rs.next()) {
				MTRBeansList.get(count).setSeatSpace(rs.getInt("max_seat_space"));
				count++;
			}
		}catch(SQLException e) {
			//エラーが発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}
		return movieCode;
	}
	public MovieRegistBeans masterMovieGetInfo(int movie_code) throws SQLException {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		MovieRegistBeans MRBeans=new MovieRegistBeans();
		try {
			stmt = con.prepareStatement("SELECT movie_name,movie_time,movie_start,movie_finish,movie_adress,movie_thumbnail,movie_description FROM movie WHERE movie_code=?");
			stmt.setInt(1,movie_code);
			rs=stmt.executeQuery();
			if (rs.next()) {
				MRBeans.setMovieName(rs.getString("movie_name"));
				MRBeans.setMovieDescription(rs.getString("movie_description"));
				MRBeans.setMovieTime(rs.getInt("movie_time"));
				MRBeans.setStartDate(rs.getDate("movie_start"));
				MRBeans.setEndDate(rs.getDate("movie_finish"));
				MRBeans.setMovieAddress(rs.getString("movie_adress"));
				MRBeans.setThumbnail(rs.getString("movie_thumbnail"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return MRBeans;
	}
	public void masterMovieUpdate(MovieRegistBeans MRBeans,int MOVIE_CODE) throws SQLException {
		
		if(con==null) {
			//接続していない場合は何もしない
			return ;
		}
		PreparedStatement stmt=null;
		
		try {
			///SELECT文の発行
			
			stmt = con.prepareStatement("UPDATE movie SET movie_name=?,movie_adress=?,movie_description=? WHERE movie_code=?");
			stmt.setString(1,MRBeans.getMovieName());
			stmt.setString(2,MRBeans.getMovieAddress());
			stmt.setString(3,MRBeans.getMovieDescription());
			stmt.setInt(4,MOVIE_CODE);
			stmt.executeUpdate();
		}catch(SQLException e) {
			//エラーが発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}
		return;
	}
	public String masterMovieDelete(int MOVIE_CODE) throws SQLException {
		if(con==null) {
			//接続していな場合は何もしない
		}
		String Filename="";
		PreparedStatement stmt=null;
		ResultSet rs=null; 
		try {
			stmt= con.prepareStatement("SELECT movie_thumbnail FROM movie WHERE movie_code=?");
			stmt.setInt(1,MOVIE_CODE);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Filename=rs.getString("movie_thumbnail");
			}
			stmt = con.prepareStatement("DELETE FROM movie WHERE movie_code=? ");
			stmt.setInt(1,MOVIE_CODE);
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return Filename;
	}
	
}