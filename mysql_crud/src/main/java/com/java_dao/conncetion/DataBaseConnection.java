package com.java_dao.conncetion;

import java.sql.*;

public class DataBaseConnection {
	
	static final String DRIVER="com.mysql.cj.jdbc.Driver";
	static final String URL="jdbc:mysql://localhost:7800/javacrud";
	static final String USER="root";
	static final String PASSWORD="";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(ClassNotFoundException | SQLException exception) {
			throw new RuntimeException("Driver class not found or counldn't connect to database "+exception);
		}
	}

	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error closing connection "+e);
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println("Error closing connection "+e);
			}
		}
		closeConnection(con);
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error closing connection "+e);
			}
		}
		closeConnection(con, ps);
	}

}
