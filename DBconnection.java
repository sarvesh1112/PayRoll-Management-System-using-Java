package payrollsystem;

import java.sql.*;

public class DBconnection {
	private static final String url = "jdbc:mysql://localhost:3306/projectdemo";
	private static final String userName = "root";
	private static final String passWord = "root";
	
	public static Connection getConnection() throws SQLException{
		return  DriverManager.getConnection(url,userName,passWord);
	}
}
