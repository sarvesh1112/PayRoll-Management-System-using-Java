package payrollsystem;
import java.sql.*;
import java.sql.SQLException;

public class AdminDAO {
	public boolean validateAdmin(Admin admin) {
		int validatecnt = 0;
		try {
			String query = "select count(admin_id) from Admin where admin_username = ? and admin_password = ?";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, admin.username);
			pst.setString(2, admin.password);
			ResultSet rs = pst.executeQuery();
			rs.next();
			validatecnt = rs.getInt(1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return validatecnt == 1;
	}
}
