package payrollsystem;

import java.util.*;

public class JobRole {
	String Name;
	int basesalary;
	
	Scanner sc = new Scanner(System.in);
	JobRole(){
		System.out.println("Enter the Name of the Job Role you want to create : ");
		Name = sc.next();
		System.out.println("Enter the Base Salary you want to have for this particular Role : ");
		basesalary = sc.nextInt();
	}
}
