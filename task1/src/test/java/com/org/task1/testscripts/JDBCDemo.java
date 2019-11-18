package com.org.task1.testscripts;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void dataBaseReader() throws SQLException, ClassNotFoundException {
		java.sql.Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// This will load the MySQL driver, each DB has its own driver
		// Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Setup the connection with the DB
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ASSESSMENT2?user=root&password=sakthi17@AKS");
		// Statements allow to issue SQL queries to the database
		statement = connect.createStatement();
		// Result set get the result of the SQL query
		resultSet = statement.executeQuery("select * from HEATCLINIC");
		while (resultSet.next()) {
			String menuName = resultSet.getString("NAME");
			
			System.out.println(menuName);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		dataBaseReader();
	}

}
