package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoBase {
	protected Connection con = null;

	public void connect() throws Exception{
		if(con != null) {
			//すでに接続済みの場合は何もしない
			return;
		}

		//コネクションプールから値を受け取るためのインスタンス
		InitialContext context = new InitialContext();;

		try {
			//データベースの種類を指定する
			String resourceName = "jdbc/MySQL";

			//jndi(Java Naming and Directory Interface)を指定
			String jndi = "java:comp/env/" + resourceName;

			//データを格納するためのインスタンスを生成する
			DataSource dataSource = (DataSource)context.lookup(jndi);

			//接続する
			con = dataSource.getConnection();
		}catch(Exception e) {
			throw e;
		}
	}

}
