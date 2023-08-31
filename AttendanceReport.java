package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AttendanceReport {
	public void generateAttendanceReport(int empid, int month, int year) {
		try {
			String query = "SELECT COUNT(*) AS leaves_taken FROM employee_attendance WHERE employee_id = ? AND YEAR(attendance_date) = ? AND MONTH(attendance_date) = ? AND status = 'Present'";
			String queryTotaldays = "select count(*) as total_days from employee_attendance where year(attendance_date) = ? and month(attendance_date) = ?";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			PreparedStatement pstTotal = con.prepareStatement(queryTotaldays);
			pst.setInt(1, empid);
			pst.setInt(2, year);
			pst.setInt(3, month);
			pstTotal.setInt(1, year);
			pstTotal.setInt(2, month);
			ResultSet rs = pst.executeQuery();
			ResultSet rsTotal = pstTotal.executeQuery();
			rs.next();
			rsTotal.next();
			System.out.println("The Total Number of Working Days is " + rsTotal.getInt(1));
			System.out.println("The Number of Present Days is " + rs.getInt(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
