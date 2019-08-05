package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteDao extends DaoBase{
	public void userDelete(String userCode) throws SQLException{

		PreparedStatement stmt = null;

		try{
			///////////////////////////////////
			//UPDATE文の発行(削除フラグ)
			stmt = con.prepareStatement("UPDATE user SET delete_flag = 1 WHERE user_code = ?");
			stmt.setString(1, userCode);
			stmt.executeUpdate();

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
	}

}
