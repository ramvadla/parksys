package com.iiit.parksys;

import java.sql.*;


public class ConnectionUtil {
	static Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		String dbname = ConfigProperties.getValue(Constants.RMD_DATABASE_NAME);
		return getConnection(dbname);
	}

	private static Connection getConnection(String database)
			throws ClassNotFoundException, SQLException {

		String localhost = ConfigProperties.getValue(Constants.DATABASE_HOST);
		String user = ConfigProperties.getValue(Constants.DATABASE_USER);
		String password = ConfigProperties
				.getValue(Constants.DATABASE_PASSWORD);
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://" + localhost + "/"
				+ database + "?autoReconnect=true", user, password);
		return con;
	}

	public static void close() throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}
