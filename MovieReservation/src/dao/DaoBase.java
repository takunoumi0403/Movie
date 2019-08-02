package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DaoBase {
	protected Connection con=null;
	/**
	 * DBの接続を行う
	 * @throw Exception 接続失敗
	 */
	public DaoBase() {
	}
	public DaoBase(Connection con) {
		this.con=con;
	}
	public void connect() throws Exception{
		if(con!=null) {
			//既に接続済みの場合は何もしない
			return;
		}
		InitialContext context=null;
		try {
			//DBの接続
			String resourceName="jdbc/MySQL";
			String jndi="java:comp/env/"+resourceName;
			context=new InitialContext();
			DataSource dataSource=(DataSource)context.lookup(jndi);
			con=dataSource.getConnection();
		}catch(NamingException e) {
			//エラーが発生した場合にコンソールにログを出力する
			e.printStackTrace();
			throw e;
		}catch(SQLException e) {
			//エラーが発生した場合にコンソールにログを出力する
			e.printStackTrace();
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


