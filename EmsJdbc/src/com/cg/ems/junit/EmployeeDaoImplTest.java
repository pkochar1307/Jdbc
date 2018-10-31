package com.cg.ems.junit;

import java.time.LocalDate;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeDaoImplTest {
	
	static EmployeeDao empDao = null;
	@BeforeClass
	public static void setUp(){
		
		empDao = new EmployeeDaoImpl();
		
	}
	
	@Test
	public void addEmpTest() throws EmployeeException 
	{
		Assert.assertEquals(111, empDao.addEmployee(new Employee(111,"aaa", 1111.0F, LocalDate.now())));
	}
	
}
