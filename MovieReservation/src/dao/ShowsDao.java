package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import beans.MovieRegistBeans;
import beans.MovieTheaterRegistBeans;

public class ShowsDao extends DaoBase{
	//private final String
	public ShowsDao() {
	}
	public ShowsDao(Connection con) {
		super(con);
	}
	public void masterShowsInsert(MovieRegistBeans MRBeans,List<MovieTheaterRegistBeans> MTRBeansList,int movieCode,int dayDiff) throws SQLException {
		
		PreparedStatement stmt=null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//映画上映開始日をSQLに入るよう変換
		Calendar startCal=Calendar.getInstance();
		startCal.setTime(MRBeans.getStartDate());
		
		//映画上映終了日をSQLに入るよう変換
		Calendar REstartCal=(Calendar)startCal.clone();
		
		try {
			for(int i=0;i<MTRBeansList.size();i++) {
				
				for(int n=0;n<MTRBeansList.get(i).getTheaterStartHour().size();n++) {
					for(int x=0;x<=dayDiff;x++) {
					
						stmt=con.prepareStatement("INSERT INTO shows"  
								+"(movie_code,show_date,theater_code,seat_space) "
								+ "VALUES(?,?,?,?)");
						
						stmt.setInt(1,movieCode);
						//Beansの日付をString変換
						//String sstr=new SimpleDateFormat("yyyy-MM-dd").format(MRBeans.getStartDate());
						//String estr=new SimpleDateFormat("yyyy-MM-dd").format(MRBeans.getEndDate());
						
						dateFormat.format(startCal.getTime());
						stmt.setString(2,dateFormat.format(startCal.getTime())+" "+MTRBeansList.get(i).getTheaterStartHour().get(n)+":"+MTRBeansList.get(i).getTheaterStartMinute().get(n)+":00");
						stmt.setString(3,MTRBeansList.get(i).getTheaterNumber());
						stmt.setInt(4, MTRBeansList.get(i).getSeatSpace());
						stmt.executeUpdate();
						
						startCal.add(Calendar.DATE,1);
					}
					startCal=(Calendar)REstartCal.clone();
				}
			
			}
			
			
			
		}catch(SQLException e) {
			//エラーが発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}
		return;
	}
	public void masterShowsDelete(int MOVIE_CODE) throws SQLException {
		PreparedStatement stmt=null;
		try {
			stmt = con.prepareStatement("DELETE FROM shows WHERE movie_code=? ");
			stmt.setInt(1,MOVIE_CODE);
			stmt.executeUpdate();
		}catch(SQLException e) {
			//エラーが発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}
		return;
	}
	/*public List<MovieTheaterUpdateBeans> masterShowsUpdate(int movie_code) throws SQLException{
		List<MovieTheaterUpdateBeans> MTUBeansList=new ArrayList<MovieTheaterUpdateBeans>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			stmt = con.prepareStatement("SELECT theater_code FROM shows WHERE movie_code=? GROUP BY theater_code");
			stmt.setInt(1,movie_code);
			rs=stmt.executeQuery();
			while(rs.next()) {
				MTUBeansList.get(count).setTheaterNumber(rs.getString("theater_code"));
				count++;
			}
			count=0;
			for(int i=0;i<MTUBeansList.size();i++) {
				stmt = con.prepareStatement("SELECT movie_code,show_date,theater_code,seat_space "
						+ "FROM shows "
						+ "WHERE movie_code=? and theater_code=? ");
				stmt.setInt(1,movie_code);
				stmt.setString(2,MTUBeansList.get(i).getTheaterNumber());
				rs=stmt.executeQuery();
				while(rs.next()){
					MTUBeansList.get(i).pushShowDate(rs.getDate("show_date"));
				}
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return MTUBeansList;
	}*/
}
