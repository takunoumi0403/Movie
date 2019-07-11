/*
 * 映画テーブルに対する操作を行うためのDao
 *
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieDao extends DaoBase {

	//SQL実行するためのインタフェースを生成
	PreparedStatement stmt = null;

	//Select分実行後のデータを取得するインタフェースを生成
	ResultSet rs = null;

}
