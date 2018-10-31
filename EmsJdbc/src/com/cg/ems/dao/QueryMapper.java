package com.cg.ems.dao;

public interface QueryMapper {
	
	public static final String SELECTQRY1 = "SELECT * FROM emp_160860";
	public static final String SELECTQRY2 = "SELECT * FROM emp_160860 WHERE emp_id = ?";
	public static final String INSERTQRY = "INSERT INTO emp_160860 VALUES (222, 'SUNIL', 34000, '12-JAN-1996')";
	public static final String INSERTQRY2 = "INSERT INTO emp_160860 (emp_id,emp_name,emp_sal)" + "VALUES(444,'AMIT',60000)";
	public static final String INSERTQRY3 = "INSERT INTO emp_160860(emp_id,emp_name,emp_sal,emp_dob)" + "VALUES(?,?,?,?)";
	public static final String DELETEQRY1 = "DELETE FROM emp_160860 WHERE emp_id = ?";
	public static final String UPDATEQRY1 = "UPDATE emp_160860 SET emp_name = ?,emp_sal = ? WHERE emp_id = ?";
}
