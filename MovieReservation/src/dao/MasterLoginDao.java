package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterLoginDao  extends DaoBase{

	public String login(String id, String pass) {

		if( con == null) {
			return (String) null;
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String loginId = null;

		try {

			stmt = con.prepareStatement("SELECT master_id FROM master WHERE master_id = ? AND master_pass = ?");

			stmt.setString(1, id);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();

			while(rs.next()) {
				rs.getString("master_id");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e){
				System.out.println("closeに失敗しました");
			}
		}

		return loginId;
	}


}
