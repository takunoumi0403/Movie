
/*
 * ユーザーに関する処理を行うModel
 *
 * 作成したら先頭に「●」を記入すること。
 *
 * ログイン
 * 会員登録
 * 会員情報変更
 * 会員情報削除
 *
 *
 */
package model;

import beans.UserInfoBeans;
import dao.UserDao;

public class UserModel {

	/**
	 * ログイン処理を行う
	 * 引数でもらったmailとパスワード
	 *
	 * @param id
	 * @param password
	 * @return
	 */
	public UserInfoBeans login(String mail, String password) {
		//ユーザの情報を格納するためのインスタンスを生成する
		UserInfoBeans userInfoBeans = new UserInfoBeans();

		//ユーザーテーブルに対する処理を行うためのインスタンスを生成する
		UserDao userDao = new UserDao();

		try {
			//データベース接続
			userDao.connect();

			//ログイン情報を取得する
			userInfoBeans = userDao.getBy(mail,password);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return userInfoBeans;

	}

}

