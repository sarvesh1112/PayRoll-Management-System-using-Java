package payrollsystem;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Employee {
	int eid,deptid,base;
	String name,gender,email_id,phone,bankaccount;
	public String role;
	Date dob,dateofjoin;
	
	
	Scanner sc = new Scanner(System.in);
	Employee(){
		System.out.println("Enter the employee details : ");
		System.out.println("Enter Employee Name : ");
		name = sc.next();
		System.out.println("Enter Gender of the Employee : ");
		gender = sc.next();
		System.out.println("Enter the Department ID of the employee : ");
		deptid = sc.nextInt();
		System.out.println("Enter the Job Role of the Employee : ");
		role = sc.next();
		String str = sc.nextLine();
		System.out.println("Enter the Base Salary : ");
		base = sc.nextInt();
		System.out.println("Enter Date of Birth of the Employee : ");
		String dateofbirth = sc.next();
		SimpleDateFormat dateofbirthFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Enter employee emailID : ");
		email_id = sc.next();
		System.out.println("Enter Employee Date of Joining : ");
		String dateofjoining = sc.next();
		SimpleDateFormat dateofjoinFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Enter the Mobile Number of the Employee : ");
		phone = sc.next();
		System.out.println("Enter Bank Account Number : ");
		bankaccount = sc.next();
		
		try {
			dob = dateofbirthFormat.parse(dateofbirth);
			dateofjoin = dateofjoinFormat.parse(dateofjoining);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
