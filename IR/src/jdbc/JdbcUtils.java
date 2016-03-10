package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

public class JdbcUtils {
//	private static String url ="mongodb://mia:123@ds053305.mlab.com:53305/miadb";

	private static String url = "jdbc:mysql://localhost:27017/jdbc";
	private static String user = "mia";
	private static String password = "123";

	private JdbcUtils() {
	}
	static {
		try {
			Class.forName("mongodb.jdbc.MongoDriver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(url, user, password);
		return (Connection) DriverManager.getConnection(url);
	}
	

	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						((ResultSet) conn).close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
}
