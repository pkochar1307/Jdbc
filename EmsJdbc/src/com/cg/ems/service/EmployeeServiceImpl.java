package com.cg.ems.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao empDao=null; 
	public EmployeeServiceImpl(){
		empDao= new EmployeeDaoImpl();
	}
	@Override
	public int addEmployee(Employee ee) throws EmployeeException {

		return empDao.addEmployee(ee);
	}

	@Override
	public HashSet<Employee> fetchAllEmp() {

		return empDao.fetchAllEmp();
	}

	@Override
	public Employee getEmpById(int empId) {
		try {
			if(validateDigit(empId))
				return empDao.getEmpById(empId);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		try {
			if(validateName(name))
				return empDao.searchEmpByName(name);
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee deleteEmp(int empId) {
		Employee e=getEmpById(empId);
		empDao.deleteEmp(empId);
		return e;
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {

		return empDao.updateEmp(empId, newName, newSal);
	}

	@Override
	public boolean validateDigit(int num) throws EmployeeException {
		Integer input = new Integer(num);
		String inputStr= input.toString();
		String digitPatter="[0-9]+";
		if(Pattern.matches(digitPatter, inputStr))
		{
			return true;
		}
		else {
			throw new EmployeeException("Invalid Input Only digits are allowed");
		}

	}

	@Override
	public boolean validateName(String name) throws EmployeeException {
		String namePatter="[A-Z][a-z]+";
		if(Pattern.matches(namePatter, name))
		{
			return true;
		}
		else {
			throw new EmployeeException("Invalid Input Only char are allowed and should star with capital letters ");
		}

	}
	@Override
	public LocalDate convertFromStrToLocalDate(String dtstr) {
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dtstr, myFormat);
		return date;
	}
	@Override
	public Date convertFromLocalDateToSqlDate(LocalDate date) {
		java.sql.Date sqlDate = java.sql.Date.valueOf(date);
		
		return sqlDate ;
	}

	

}
