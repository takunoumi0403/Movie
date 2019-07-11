/*
 * ユーザーテーブルに対する処理を行うDao
 *
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import beans.UserInfoBeans;

public class UserDao extends DaoBase {

	//SQL実行するためのインタフェースを生成
	PreparedStatement stmt = null;

	//Select分実行後のデータを取得するインタフェースを生成
	ResultSet rs = null;

	//データ型<->文字列を行うための準備
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

	/**
	 *
	 * ログイン処理を行うためのメソッド
	 * @return
	 */
	public UserInfoBeans getBy(String mail,String password) {

		//ログイン情報を格納するためのインスタンスを生成する
		UserInfoBeans userInfoBeans = null;

		//接続されているかどうか判定する
		if(con == null) {
			//接続がない場合
			return null;
		}

		try {
			//select文の発行
			stmt = con.prepareStatement("select * from user where user_mail = ? and user_pass = ?");

			//値をセットする
			stmt.setString(1, mail);
			stmt.setString(2, password);

			rs = stmt.executeQuery();

			while(rs.next()) {
				//ログイン情報を格納する
				userInfoBeans = new UserInfoBeans();
				userInfoBeans.setUserCode(rs.getString("user_code"));
				userInfoBeans.setUserMail(rs.getString("user_mail"));
				userInfoBeans.setUserName(rs.getString("user_name"));
				userInfoBeans.setUserPhone(rs.getString("user_phone"));
				userInfoBeans.setGenderCode(rs.getString("gender_code"));
				userInfoBeans.setUserBirth(sdf.parse(rs.getString("gender_code")));
			}

		}catch(Exception e) {

		}finally {
			//データベースの接続を切る
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
				}
			}
		}

		return userInfoBeans;
	}
}
