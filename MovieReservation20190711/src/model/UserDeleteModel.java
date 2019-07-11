package model;

import java.sql.SQLException;

import beans.UserInfoBeans;
import dao.UserDeleteDao;

public class UserDeleteModel {

	public void deleteUser() {

		UserInfoBeans beans = new UserInfoBeans();

		UserDeleteDao dao = new UserDeleteDao();
		try {
			dao.userDelete(beans.getUserCode());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
