package com.cg.ems.ui;

import java.util.HashSet;
import java.util.TreeSet;

import com.cg.ems.dto.Employee;

public class TestHashSetDemo {

	public static void main(String[] args)
	{
		HashSet <Employee> emps = new HashSet<Employee>();

		emps.add(new Employee (123,"Chaitanya",10000.0F));
		emps.add(new Employee(234, "Amit", 1.0F));
		emps.add(new Employee(345, "Amit", 10.0F));
		emps.add(new Employee(345, "xyz", 10.0F));
		System.out.println(emps);

		System.out.println("*********************");
		TreeSet<String> cities = new TreeSet<String>();
		cities.add("Pune");
		cities.add("Noida");
		cities.add("Mumbai");
		cities.add("Sahidabad");
		cities.add("Pune");

		System.out.println(cities);
		System.out.println("************************");
		TreeSet <Employee> emps2 = new TreeSet<Employee>();

		emps2.add(new Employee (123,"Chaitanya",10000.0F));
		emps2.add(new Employee(234, "Amit", 1.0F));
		emps2.add(new Employee(345, "Amit", 10.0F));
		emps2.add(new Employee(345, "xyz", 10.0F));
		System.out.println(emps2);

	}

}
