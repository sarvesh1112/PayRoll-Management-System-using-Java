package payrollsystem;
import java.util.*;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Attendance {
	
	int id;
	String status;
	LocalDate attendancedate;
	Timestamp intime;
	
	Scanner sc = new Scanner(System.in);
	Attendance(){
		
		System.out.println("Enter the Attendance Details");
		System.out.println("Enter the Employee ID : ");
		id = sc.nextInt();
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String retriveddate = today.format(formatter);
		//SimpleDateFormat attendanceoftoday = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Enter attendance status for " + " " + retriveddate + ":");
		status = sc.next();
		
		try {
			attendancedate = LocalDate.parse(retriveddate, formatter);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
