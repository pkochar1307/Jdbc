package com.cg.ems.dto;

import java.sql.Date;
import java.time.LocalDate;

public class Employee implements Comparable <Employee> {

	private int empId; 
	private String empName;
	private float empSal;
	private Date empDOJ;


	public Employee(int empId, String empName, float empSal,Date empDOJ) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDOJ = empDOJ;
	}


	public Date getEmpDOJ() {
		return empDOJ;
	}


	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public float getEmpSal() {
		return empSal;
	}


	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	public Employee(int eid, String empName, float empSal) {
		super();
		this.empId = eid;
		this.empName = empName;
		this.empSal = empSal;
	}

	@Override
	public boolean equals(Object obj)
	{
		Employee emp = (Employee)obj;
		if (emp.empId==this.empId)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int hashCode()
	{
		return empId;
	}

	@Override
	public int compareTo(Employee emp)
	{
		if(emp.empId<this.empId)
		{
			return -1;
		}
		else if(emp.empId== this.empId)
		{
			return 0;
		}
		else
		{
			return +1;
		}
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSal=" + empSal + ", empDOJ=" + empDOJ + "]";
	}

	/*public static void main(String[] args) {


	}*/

}
