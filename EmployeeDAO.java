package payrollsystem;

import java.util.Date;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDAO {
	public void addEmployeeDetails(Employee employee) {
		try {
			String query = "insert into Employee (emp_name,gender,dept_id,DateofBirth,email_id,DateofJoining,phone,bank_account,JobRole,BaseSalary)values(?,?,?,?,?,?,?,?,?,?)";
			String queryLogin = "insert into employee_login (empPassword) values (NULL)";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			Statement st = con.createStatement();
			st.executeUpdate(queryLogin);
			pst.setString(1,employee.name);
			pst.setString(2, employee.gender);
			pst.setInt(3,employee.deptid);
			java.sql.Date sqldateofbirth = new java.sql.Date(employee.dob.getTime());
			pst.setDate(4, sqldateofbirth);
			pst.setString(5, employee.email_id);
			java.sql.Date sqldateofjoin = new java.sql.Date(employee.dateofjoin.getTime());
			pst.setDate(6, sqldateofjoin);
			pst.setString(7, employee.phone);
			pst.setString(8, employee.bankaccount);
			pst.setString(9,employee.role);
			pst.setInt(10, employee.base);

			pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
