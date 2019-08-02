package model;

import dao.MasterLoginDao;

public class MasterLoginModel {

	public String login(String id, String pass) {

		String loginId = null;

		MasterLoginDao masterLoginDao = new MasterLoginDao();
		try{
			///////////////////////////////////
			//DBの接続
			masterLoginDao.connect();

			loginId = masterLoginDao.login(id, pass);

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}

		return loginId;

	}

}
