package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class PaySlip {
	public void generatepayslip(int empid) {
		int basesalary = 0;
		try {
			String query = "select BaseSalary from Employee where emp_id = ?";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, empid);
			ResultSet rs = pst.executeQuery();
			rs.next();
			basesalary = rs.getInt(1);
			System.out.println(basesalary);
			String queryEarnings = "select Component_Name,Percentage from employeesalary_components where TypeOfComponent = 'Earnings'";
			Statement st = con.createStatement();
			ResultSet rsEarnings = st.executeQuery(queryEarnings);
			System.out.println("Earnings : ");
			while(rsEarnings.next()) {
				String Name = rsEarnings.getString(1);
				int Percentage = rsEarnings.getInt(2);
				int val = (Percentage*basesalary)/100;
				System.out.println(Name + " "  + " " + val);
			}
			String queryDeductions = "select Component_Name,Percentage from employeesalary_components where TypeOfComponent = 'Deductions'";
			Statement st1 = con.createStatement();
			ResultSet rsDeductions = st1.executeQuery(queryDeductions);
			System.out.println("Deductions : ");
			while(rsDeductions.next()) {
				String Name = rsDeductions.getString(1);
				int Percentage = rsDeductions.getInt(2);
				int val = (Percentage*basesalary)/100;
				System.out.println(Name + " "  + " " + val);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
