package com.teljdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: 数据库连接
 * @author chaoling
 * @date 2018年7月30日上午9:44:55
 */
public class JdbcUtil {

	/**
	 * @Description: 创建数据库连接
	 * @return Connection
	 * @throws ClassNotFoundException
	 *             SQLException
	 */
	public static Connection getConnection() {

		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "mysql";
		String url = "jdbc:mysql://localhost:3306/telephone?useUnicode=true&characterEncoding=utf-8";

		Connection connection = null;

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * @Description: 关闭连接 关闭Connection
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(Connection connection) {

		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @Description: 关闭连接 关闭Statement
	 * @param stmt
	 * @throws SQLException
	 */
	public static void close(Statement stmt) {

		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @Description: 关闭结果集
	 * @param resultSet
	 * @throws SQLException
	 */
	public static void close(ResultSet resultSet) {

		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @Description: 关闭连接，关闭Connection和Statement
	 * @param connection
	 * @param statement
	 * @throws SQLException
	 */
	public static void close(Connection connection, Statement statement) {

		/*
		 * try { if(statement != null) statement.close(); if(connection != null)
		 * connection.close(); } catch (SQLException e) { e.printStackTrace(); }
		 */
		close(statement);
		close(connection);
	}

	/**
	 * @Description: 关闭连接，关闭结果集
	 * @param connection
	 * @param statement
	 * @param resultSet     
	 * @throws
	 */
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {

		close(resultSet);
		close(statement);
		close(connection);
	}

}
