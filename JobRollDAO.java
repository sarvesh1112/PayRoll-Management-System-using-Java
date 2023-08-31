package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JobRollDAO {
	public void addnewJobRole(JobRole jobrole) {
		try {
			String query = "insert into Job (RoleofEmployee,BaseSalary) values (?,?)";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, jobrole.Name);
			pst.setInt(2, jobrole.basesalary);
			pst.executeUpdate();
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Input Mismatch" + e);
		}
	}
}
