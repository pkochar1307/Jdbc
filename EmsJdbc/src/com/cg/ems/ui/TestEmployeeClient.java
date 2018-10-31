package com.cg.ems.ui;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;


public class TestEmployeeClient {

	static Scanner sc = null;
	static EmployeeService empSer = null;
	public static void main(String[] args) {
		sc=new Scanner (System.in);
		empSer= new EmployeeServiceImpl();
		int choice= 0;
		while (true)
		{
			System.out.println("What do you want to do?");
			System.out.println("1: Add Employee \n 2: Fetch All Emp \n3: Delete emp\n 4: Search emp by id \n 5: Search emp by name ");
			System.out.println("6: Update\n 7: EXIT \n Enter Your Choice ");
			choice =sc.nextInt();
			switch(choice)
			{
			case 1: addEmp(); break;
			case 2: showEmpInfo(); break;
			case 3: deleteEmp();break;
			case 4: searchEmpByID();break;
			case 5: searchEmpByName();break;
			case 6: updateEmp();break;
			case 7: exit();break;
			default:System.exit(0);
			}

		}

	}
	private static void updateEmp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter empid:");
		int eid = sc.nextInt();
		System.out.println("Enter Enp name:");
		String ename = sc.next();
		System.out.println("Enter Emp Salary:");
		Float esal = sc.nextFloat();
		try {
			if(empSer.validateDigit(eid) && empSer.validateName(ename))
				empSer.updateEmp(eid, ename, esal);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}

	}
	private static void deleteEmp() {
		System.out.println("Enter emp Id");
		int eid= sc.nextInt();
		EmployeeServiceImpl empser = new EmployeeServiceImpl();
		empSer.deleteEmp(eid);
		}

	private static void exit() {
		System.exit(0);
	}

	private static void searchEmpByName() {
		System.out.println("Enter emp Name");
		String ename = sc.next();
		EmployeeServiceImpl ee= new EmployeeServiceImpl();
		ee.searchEmpByName(ename);
	}

	private static void searchEmpByID() {
		System.out.println("Enter emp ID");
		int eid = sc.nextInt();
		EmployeeServiceImpl ee= new EmployeeServiceImpl();
		ee.getEmpById(eid);
	}

	private static void showEmpInfo() {

		HashSet <Employee> empSet = empSer.fetchAllEmp();
		Iterator <Employee> it = empSet.iterator();
		System.out.println("----------------------------------");
		System.out.println("EMPID\t\tEMPNAME\t\tEmpSalary\t\tEmpDOJ");
		
		while (it.hasNext())
		{
			Employee ee= it.next();
			System.out.println(ee.getEmpId()+"\t\t"+ee.getEmpName()+"\t\t"+ee.getEmpSal() + "\t\t" + ee.getEmpDOJ());
		}
		System.out.println("----------------------------------");


	}

	private static void addEmp() {
		System.out.println("Enter emp Id");
		int eid= sc.nextInt();
		try{
			if (empSer.validateDigit(eid))
			{
				System.out.println("Enter emp name:");
				String nm=sc.next();
				if(empSer.validateName(nm))
				{
					System.out.println("Enter salary:");
					float sal =sc.nextFloat();
					System.out.println("Enter DOJ (dd-MMM-yyy)");
					String empDOJstr = sc.next();
					LocalDate date = empSer.convertFromStrToLocalDate(empDOJstr);
					java.sql.Date mySqlDate =empSer.convertFromLocalDateToSqlDate(date);
					Employee ee= new Employee(eid,nm,sal,mySqlDate);
					int empId=empSer.addEmployee(ee);
					System.out.println(empId +" Added Successfully");
				}
			}
		}
		catch(EmployeeException e)
		{
			e.printStackTrace();
		}
	}
}
