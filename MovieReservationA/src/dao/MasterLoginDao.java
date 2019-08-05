package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UserInfoBeans;

public class MasterLoginDao  extends DaoBase{

	public UserInfoBeans login(String name, String pass) {
		UserInfoBeans loginInfo = new UserInfoBeans();
		if( con == null) {
			return null;
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;
		

		try {

			stmt = con.prepareStatement("SELECT adm_id,adm_name FROM adm WHERE adm_name = ? AND adm_password = ?");

			stmt.setString(1, name);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();

			while(rs.next()) {
				loginInfo.setLoginId(rs.getInt("adm_id"));
				loginInfo.setName(rs.getString("adm_name"));
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

		return loginInfo;
	}


}
