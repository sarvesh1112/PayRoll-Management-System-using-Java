package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeLogin {
	public boolean validEmployee(int empid) {
		boolean flag = false;
		try {
			String query = "select count(*) as ID from Employee where emp_id = ? ";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, empid);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if(rs.getInt(1) == 1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public void passwordSetCheck(int empid) {
		try {
			String querysetPassword = "select count(*) from employee_login where empid = ? and empPassword = 'NULL'";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(querysetPassword);
			pst.setInt(1, empid);
			ResultSet rs = pst.executeQuery();
			rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setPasswordforEmployee(int empid, String password) {
		try {
			String querysetPassword = "update employee_login set empPassword = ? where empid = ?";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(querysetPassword);
			pst.setString(1, password);
			pst.setInt(2, empid);
			int rows = pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean loginEmployee(int empid, String password) {
		boolean flag = false;
		try {
			String queryLogin = "select count(*) from employee_login where empid = ? and empPassword = ?";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(queryLogin);
			pst.setInt(1, empid);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if(rs.getInt(1) == 1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
