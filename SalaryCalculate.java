package payrollsystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SalaryCalculate {
	int empid;
	Scanner sc = new Scanner(System.in);
	
	SalaryCalculate(){
		System.out.println("Enter the ID of the employee for whom salary needs to be calculated : ");
		empid = sc.nextInt();
	}
	public int calculatesalaryofemployee(SalaryCalculate Emp) {
		LocalDate salary_date = null;
		int basesalary = 0;
		int hra,pf,transport,bonus,medical,earnings = 0,deductions = 0;
		try {
			String query = "select BaseSalary from Employee where emp_id = ?";
			Connection con = DBconnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, Emp.empid);
			ResultSet rs = pst.executeQuery();
			rs.next();
			basesalary = rs.getInt(1);
			String querySalaryComponents = "select * from employeesalary_components";
			PreparedStatement pstcomp = con.prepareStatement(querySalaryComponents);
			ResultSet rscomp = pstcomp.executeQuery();
			while(rscomp.next()) {
				int currComponent = 0;
				String name = rscomp.getString(2);
				String typeofcomponent = rscomp.getString(3);
				int percentage = rscomp.getInt(4);
				currComponent = (percentage * basesalary)/100;
				System.out.println(name + ":" + currComponent);
				if(typeofcomponent.equals("Earnings")) {
					earnings+=currComponent;
				}
				else {
					deductions+=currComponent;
				}
			}
			//System.out.println("Total Earnings   : " + earnings);
			//System.out.println("Total Deductions : " + deductions);
			LocalDate today = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String retriveddate = today.format(formatter);
			System.out.println(retriveddate);
			try {
				salary_date = LocalDate.parse(retriveddate, formatter);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			Date sqlDateofSalary = Date.valueOf(salary_date);
			String queryInsertsalary = "insert into employee_salary(empid,basesalary,salarydate,deductions,earnings,grosssalary,netsalary) values (?,?,?,?,?,?,?)";
			PreparedStatement pstsalary = con.prepareStatement(queryInsertsalary);
			pstsalary.setInt(1, Emp.empid);
			pstsalary.setInt(2, basesalary);
			pstsalary.setDate(3, sqlDateofSalary);
			pstsalary.setInt(4, deductions);
			pstsalary.setInt(5, earnings);
			int gross = basesalary + earnings;
			pstsalary.setInt(6, gross);
			pstsalary.setInt(7, gross-deductions);
			
			pstsalary.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return basesalary;
	}
}
