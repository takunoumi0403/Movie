
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

	public boolean signup( UserInfoBeans beans) {
		UserDao userDao = new UserDao();

		try {
			return userDao.insertUser(beans);


		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(UserInfoBeans beans) {
		UserDao dao = new UserDao();
		boolean flg = false;
		try {
			//データベース接続
			dao.connect();
           return flg = dao.updateUser(beans);



		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}



}
