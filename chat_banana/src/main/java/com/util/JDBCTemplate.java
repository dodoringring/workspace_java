package com.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
	public JDBCTemplate() {
	}

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(" oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection( "jdbc:oracle:thin:@128.168.25.30:1521:XE", "student",
					"student");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
	 try {
	 if (con != null && !con.isClosed()) { con.commit(); }
	} catch (SQLException e) { e.printStackTrace(); }
	 }

	public static void rollback(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	Connection con = getConnection();
	System.out.println(con);
}
}
