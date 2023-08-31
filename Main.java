package payrollsystem;

import java.util.*;

public class Main {
	
	

	public static void main(String[] args) {
		System.out.println(        "\n-----------------------------Welcome to Employee Payroll Management System-------------------------------");
		System.out.println("\n" + "\n" );
		System.out.println("----------------------------------------Login Page--------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 If you are an admin. If you are an employee Enter 2");
		
		System.out.println("Enter your Choice : ");
		int choiceOfUser = sc.nextInt();
		
		if(choiceOfUser == 1) {
			Admin admin = new Admin();
			//System.out.println(admin.id + " " + admin.username + " " + admin.password);
			AdminDAO admindao = new AdminDAO();
			boolean validateResult = admindao.validateAdmin(admin);
			if(validateResult == true) {
				System.out.println("Authorization Successful");
				System.out.println("\n -------------------------------------------- 1. Add Department         ---------------------------------------");
				System.out.println("\n -------------------------------------------- 2. Add Employee           ---------------------------------------");
				System.out.println("\n -------------------------------------------- 3. Add Attendance Details ---------------------------------------");
				System.out.println("\n -------------------------------------------- 4. Add New Job Role       ---------------------------------------");

				int actiontobeperformed = sc.nextInt();
				if(actiontobeperformed == 1) {
					Department department = new Department();
					DepartmentDAO deptdao = new DepartmentDAO();
					deptdao.addDepartment(department);
					System.out.println("The Department Details have been added successfully");
				}
				else if(actiontobeperformed == 2) {
					Employee employee = new Employee();
					EmployeeDAO empdao = new EmployeeDAO();
					empdao.addEmployeeDetails(employee);
				}
				else if(actiontobeperformed == 3) {
					Attendance attendance = new Attendance();
					AttendanceDAO attendancedao = new AttendanceDAO();
					attendancedao.addAttendanceDetails(attendance);
				}
				else if(actiontobeperformed == 4){
					JobRole jobrole = new JobRole();
					JobRollDAO jobroledao = new JobRollDAO();
					jobroledao.addnewJobRole(jobrole);
				}
				else if(actiontobeperformed == 5) {
					SalaryCalculate Emp = new SalaryCalculate();
					System.out.println("The Base Salary of the Employee : " + Emp.calculatesalaryofemployee(Emp));
				}
			}
			else {
				System.out.println("Invalid Authorization");
			}
		}
		else {
			System.out.println("Enter your employee ID : ");
			int emp_id = sc.nextInt();
			EmployeeLogin emplogin = new EmployeeLogin();
			
			boolean setPassword = false;
			if(emplogin.validEmployee(emp_id)) {
				setPassword = true;
			}
			
			if(emplogin.validEmployee(emp_id)) {
				System.out.println("Valid Employee");
				System.out.println("Set your Password to Login");
				System.out.println("Enter your PassWord :");
				String password = sc.next();
				emplogin.setPasswordforEmployee(emp_id, password);
				System.out.println("Password Set Successfully");
			}
			System.out.println("\n-------------------------------------------------- 1. View PaySlip           ---------------------------------------");
			System.out.println("\n-------------------------------------------------- 2. View Attendance Report ---------------------------------------");
			System.out.println("Enter action to be performed : ");
			int actiontobeperformed = sc.nextInt();
			if(actiontobeperformed == 1) {
				System.out.println("Enter your Employee ID : ");
				int empid = sc.nextInt();
				PaySlip pay = new PaySlip();
				pay.generatepayslip(empid);
			}
			else if(actiontobeperformed == 2) {
				int month,year,empid;
				System.out.println("Enter the Employee ID : ");
				empid = sc.nextInt();
				System.out.println("Enter the Month : ");
				month = sc.nextInt();
				System.out.println("Enter the Year : ");
				year = sc.nextInt();
				AttendanceReport report = new AttendanceReport();
				report.generateAttendanceReport(empid, month, year);
			}
		}
	}

}
