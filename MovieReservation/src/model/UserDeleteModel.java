package model;

import java.sql.SQLException;

import dao.UserDeleteDao;

public class UserDeleteModel {

	public void deleteUser(String userCode) throws Exception {

		UserDeleteDao dao = new UserDeleteDao();
		try {
			dao.connect();
			dao.userDelete(userCode);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
