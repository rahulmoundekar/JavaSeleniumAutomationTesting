package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestNGDataBase {
	static Connection con = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testng", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Login> loginCredentials() {
		List<Login> logins = new ArrayList<Login>();
		try {
			ResultSet rs = con.prepareStatement("select * from login").executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setId(rs.getInt(1));
				login.setUsername(rs.getString(2));
				login.setPassword(rs.getString(3));
				logins.add(login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logins;
	}

	public static int getRowsCount() {
		int rowsCount = 0;
		try {
			ResultSet rs = con.prepareStatement("select count(*) from login").executeQuery();
			if (rs.next())
				rowsCount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsCount;
	}

	public static int getColumnsCount() {
		int columnCount = 0;
		try {
			ResultSet rs = con.prepareStatement("select * from login").executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnCount;
	}

	public static void main(String[] args) {
		
		Object[][] loginCredentials = null;
		
		int rows = TestNGDataBase.getRowsCount();
		int columns = TestNGDataBase.getColumnsCount() - 1;
		List<Login> logins = TestNGDataBase.loginCredentials();
		loginCredentials = new Object[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				loginCredentials[i][j++] = logins.get(i).getUsername();
				loginCredentials[i][j] = logins.get(i).getPassword();
			}
		}

		for (Object login[] : loginCredentials) {
			for (Object log : login) {
				System.out.print(log);
			}
			System.out.println("");
		}

	}

}
