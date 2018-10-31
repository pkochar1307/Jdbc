package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con = null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs =null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "system";
	String pwd = "corp123";
	@Override
	public int addEmployee(Employee ee) throws EmployeeException {

		try {
			con = DBUtil.getCon();
			pst = con.prepareStatement(QueryMapper.INSERTQRY3);
			pst.setInt(1, ee.getEmpId());
			pst.setString(2, ee.getEmpName());
			pst.setFloat(3,ee.getEmpSal());
			pst.setDate(4, ee.getEmpDOJ());
			int data = pst.executeUpdate();
			if(data == 1)
				return ee.getEmpId();
			else
				return 0;
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		finally{

		}
		
	}

	@Override
	public HashSet<Employee> fetchAllEmp() {
		
		HashSet <Employee> empSet = new HashSet<Employee>();
		try {
			con = DBUtil.getCon();
			st = con.createStatement();
			rs = st.executeQuery(QueryMapper.SELECTQRY1);
			while (rs.next())
			{
				int eid = rs.getInt("emp_id");
				String enm = rs.getString("emp_name");
				float sl = rs.getFloat("emp_sal");
				Date edate=rs.getDate("emp_dob");
				empSet.add(new Employee(eid, enm, sl));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empSet;

	}

	@Override
	public Employee getEmpById(int empId) {
		return null;
	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		return null;
	}


	@Override
	public int deleteEmp(int empId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,uid,pwd);
			pst = con.prepareStatement(QueryMapper.DELETEQRY1);
			pst.setInt(1, empId);
			int data = pst.executeUpdate();
			System.out.println("Data is deleted");
			} catch (Exception e) {

			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,uid,pwd);
			pst = con.prepareStatement(QueryMapper.UPDATEQRY1);
			pst.setString(1, newName);
			pst.setFloat(2, newSal);
			pst.setInt(3, empId);
			int data = pst.executeUpdate();
			System.out.println("Data is updated");
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}


}
