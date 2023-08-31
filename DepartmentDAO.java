package payrollsystem;
import java.sql.*;

public class DepartmentDAO {
	public void addDepartment(Department department) {
		try {
			String query = "insert into Department values(?,?)";
			Connection conn = DBconnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, department.id);
			pst.setString(2, department.name);
			
			pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
