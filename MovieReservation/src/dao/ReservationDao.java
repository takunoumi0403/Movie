/*
 * 予約テーブルに対する操作を行うためのDao
 *
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UserInfoBeans;

public class ReservationDao extends DaoBase {

	//SQL実行するためのインタフェースを生成
	PreparedStatement stmt = null;

	//Select分実行後のデータを取得するインタフェースを生成
	ResultSet rs = null;

	/**
	 *
	 * ログイン処理を行うためのメソッド
	 * @return
	 */
	public UserInfoBeans login(String studentNumber,String password) {

		//ログイン情報を格納するためのインスタンスを生成する
		UserInfoBeans loginInfo = null;

		//接続されているかどうか判定する
		if(con == null) {
			//接続がない場合
			return null;
		}

		try {
			//select文の発行
			stmt = con.prepareStatement(
					"select student.student_id , class.class_code , course_name , class_name , grade , student_name "
					+ "from student inner join class on student.class_code = class.class_code "
					+ "inner join course on course.course_code = class.course_code "
					+ "where student_id = ? and student_password = ?"
					);

			//値をセットする
			stmt.setString(1, studentNumber);
			stmt.setString(2, password);

			rs = stmt.executeQuery();

			while(rs.next()) {
				//ログイン情報を格納する
				loginInfo = new UserInfoBeans();
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

		return loginInfo;
	}
}
