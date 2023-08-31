package payrollsystem;
import java.util.*;

public class Department {
	int id;
	String name;
	
	Scanner sc = new Scanner(System.in);
	
	Department(){
		System.out.println("Enter the Department Details to be added : ");
		System.out.println("Enter the Department ID : ");
		id = sc.nextInt();
		System.out.println("Enter the name of the department : ");
		name = sc.next();
	}
}
