/*
 * ユーザーテーブルに対する処理を行うDao
 *
 */

package dao;

import java.sql.Date;
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
			stmt = con.prepareStatement("SELECT * , DATE_FORMAT(user_birth,'%Y') as Y , DATE_FORMAT(user_birth,'%m') as M , DATE_FORMAT(user_birth,'%d') as D FROM user WHERE user_mail = ? AND user_pass = ? AND delete_flag = 0");

			//値をセットする
			stmt.setString(1, mail);
			stmt.setString(2, password);

			rs = stmt.executeQuery();

			while(rs.next()) {
				//ログイン情報を格納する
				userInfoBeans = new UserInfoBeans();
				userInfoBeans.setPass(rs.getString("user_pass"));
				userInfoBeans.setUserCode(rs.getString("user_code"));
				userInfoBeans.setUserMail(rs.getString("user_mail"));
				userInfoBeans.setUserName(rs.getString("user_name"));
				userInfoBeans.setUserPhone(rs.getString("user_phone"));
				userInfoBeans.setGenderCode(rs.getString("gender_code"));
				userInfoBeans.setYear(rs.getString("Y"));
				userInfoBeans.setMonth(rs.getString("M"));
				userInfoBeans.setDay(rs.getString("D"));
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


	public boolean insertUser(UserInfoBeans beans) {

		try {

			//接続されているかどうか判定する
			if(con == null) {
				//接続がない場合
				System.out.println("DB Conect Error");
				return false;
			}

			//select文の発行
			stmt = con.prepareStatement("INSERT INTO user(user_mail,user_name,user_phone,gender_code,user_birth,user_pass) VALUES(?,?,?,?,?,?)");

			//値をセットする
			stmt.setString(1, beans.getAddress());
			stmt.setString(2, beans.getSei() + beans.getMei());
			stmt.setString(3, beans.getUserPhone());
			stmt.setString(4, beans.getSex());
			stmt.setDate(5,Date.valueOf(beans.getYear() +"-"+ beans.getMonth() + "-"+ beans.getDay())) ;
			stmt.setString(6, beans.getPass());

			System.out.println("⭐︎" + beans.getAddress());
			System.out.println("⭐︎" + beans.getSei()+ beans.getMei());
			System.out.println("⭐︎" + beans.getUserPhone());
			System.out.println("⭐︎" + beans.getSex());
			System.out.println("⭐︎" + beans.getYear());


			//SQLを確定する
			int result = stmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public UserInfoBeans getBy(String user_code) {
		//ログイン情報を格納するためのインスタンスを生成する
				UserInfoBeans userInfoBeans = null;

				//接続されているかどうか判定する
				if(con == null) {
					//接続がない場合
					return null;
				}
				try {
					//select文の発行
					stmt = con.prepareStatement("select * from user where user_code = ?");

					//値をセットする
					stmt.setString(1, user_code);


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
	public boolean updateUser(UserInfoBeans beans) {

		try {

			//接続されているかどうか判定する
			if(con == null) {
				//接続がない場合
				System.out.println("DB Conect Error");
				return false;
			}

			//select文の発行


			//値をセットする
			stmt = con.prepareStatement("UPDATE user SET user_mail=?,user_pass=?,user_phone=?,user_name=? WHERE user_code = ?");
			stmt.setString(1, beans.getAddress());
			stmt.setString(2, beans.getPass());
			stmt.setString(3, beans.getUserPhone());
			stmt.setString(4, beans.getUserName());
			stmt.setString(5, beans.getUserCode());
			stmt.executeUpdate();

			System.out.println("⭐︎" + beans.getAddress());
			System.out.println("⭐︎" + beans.getUserPhone());
			System.out.println("⭐︎" + beans.getUserPass());
			System.out.println("⭐︎" + beans.getUserPhone());



			//SQLを確定する
			int result = stmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
