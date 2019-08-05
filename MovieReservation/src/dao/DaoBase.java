package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoBase {
	protected Connection con = null;

	public DaoBase() {
	}
	public DaoBase(Connection con) {
		this.con=con;
	}
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


	/**
	 * 接続のクローズ処理
	 */
	public void close() {
		if(con!=null) {
			try {
				con.close();
				con=null;
			}catch(SQLException e) {
				//クローズの失敗は、ログを出力するだけ
				System.out.println("closeに失敗しました。");
			}
		}
	}
	public Connection getConnection() {
		return con;
	}
	public void commit() throws SQLException{
		if(con!=null) {
			try {
				con.commit();
			}finally {
				con.setAutoCommit(true);
			}
		}
	}
	public void rollback() {
		if(con!=null) {
			try {
				con.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					con.setAutoCommit(true);
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void beginTransaction() throws SQLException {
		if(con!=null) {
			con.setAutoCommit(false);
		}
	}

}
