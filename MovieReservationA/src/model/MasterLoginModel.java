package model;

import beans.UserInfoBeans;
import dao.MasterLoginDao;

public class MasterLoginModel {

	public UserInfoBeans login(String name, String pass) {
		UserInfoBeans loginInfo = new UserInfoBeans();
		
		MasterLoginDao masterLoginDao = new MasterLoginDao();
		try{
			///////////////////////////////////
			//DBの接続
			masterLoginDao.connect();

			loginInfo = masterLoginDao.login(name, pass);

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}

		return loginInfo;

	}

}
