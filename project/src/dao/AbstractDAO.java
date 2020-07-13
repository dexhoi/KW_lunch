package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AbstractDAO {

	private static Context context = null;

	static{
		try {
			context = new InitialContext();
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * context.xmlからDataSourceを生成します
	 * @return Connection PoolなConnection
	 * @throws SQLException
	 */
	protected static Connection getConnection() throws SQLException{
		try {
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/source");
			return ds.getConnection();
		}catch(NamingException e) {
			throw new SQLException(e);
		}
	}

}
