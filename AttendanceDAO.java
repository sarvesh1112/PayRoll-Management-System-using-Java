package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class AttendanceDAO {
	public void addAttendanceDetails(Attendance attendance) {
		try {
			String query = "insert into employee_attendance (employee_id,attendance_date,status) values (?,?,?)";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, attendance.id);
			//java.sql.Date sqldateofbirth = new java.sql.Date(attendance.attendancedate.getTime());
			Date sqlDateofAttendance = Date.valueOf(attendance.attendancedate);
			pst.setDate(2, sqlDateofAttendance);
			pst.setString(3, attendance.status);
			
			pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
