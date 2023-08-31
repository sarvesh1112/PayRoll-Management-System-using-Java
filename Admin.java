package payrollsystem;
import java.util.*;

public class Admin {
	int id;
	String username;
	String password;
	
	Admin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your UserName : ");
		username = sc.next();
		System.out.println("Enter your Password : ");
		password = sc.next();
	}
	
}
