package com.java.employ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployDAOImpl implements EmployDAO{
	
	Connection connection;
	PreparedStatement pst;
	

	@Override
	public List<Employ> showEmployDao() throws ClassNotFoundException, SQLException {
		
		connection=ConnectionHelper.getConnection();
		String cmd= "select * from Employ";
		pst= connection.prepareStatement(cmd);
		ResultSet rs= pst.executeQuery();
		List<Employ> employList= new ArrayList<Employ>();
		Employ employ=null;
		while(rs.next()) {
			employ= new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setGender(Gender.valueOf(rs.getString("gender")));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getDouble("basic"));
			employList.add(employ);
			
		}
		return employList;
	}


	@Override
	public Employ searchEmployDao(int empno) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd= "select * from Employ where empno=?";
		pst= connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs= pst.executeQuery();
		Employ employ= null;
		if(rs.next()) {
			employ= new Employ();
			employ.setEmpno(rs.getInt("empno"));
			employ.setName(rs.getString("name"));
			employ.setGender(Gender.valueOf(rs.getString("gender")));
			employ.setDept(rs.getString("dept"));
			employ.setDesig(rs.getString("desig"));
			employ.setBasic(rs.getDouble("basic"));
		}return employ;
	}


	@Override
	public String addEmployDAO(Employ employ) throws ClassNotFoundException, SQLException {
		connection=ConnectionHelper.getConnection();
		String cmd= "Insert into Employ(Empno, Name, Gender,Dept, Desig, Basic)" +" values(?,?,?,?,?,?)";
		pst= connection.prepareStatement(cmd);
		pst.setInt(1,employ.getEmpno());
		pst.setString(2,employ.getName());
		pst.setString(3,employ.getGender().toString());
		pst.setString(4,employ.getDept());
		pst.setString(5,employ.getDesig());
		pst.setDouble(6,employ.getBasic());
		pst.executeUpdate();
		return "EMploy Record Inserted";
	}


	@Override
	public String deleteEmployDAO(int empno) throws ClassNotFoundException, SQLException {
		Employ employ= searchEmployDao(empno);
		if(employ!=null) {
			connection=ConnectionHelper.getConnection();
			String cmd="Delete from EMploy where empno=?";
			pst= connection.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.executeUpdate();
			return "Employ record deleted";
		}return "EMploy number not found";
		
		
	}


	@Override
	public String updateEmployDao(Employ employNew) throws ClassNotFoundException, SQLException {
		Employ employFound= searchEmployDao(employNew.getEmpno());
		if(employFound!=null) {
		connection=ConnectionHelper.getConnection();
		String cmd="Update Employ Set Name=?, Gender=?, Dept=?, Desig=?, Basic=? where Empno=?";
		pst= connection.prepareStatement(cmd);
		pst.setString(1,employNew.getName());
		pst.setString(2,employNew.getGender().toString());
		pst.setString(3,employNew.getDept());
		pst.setString(4,employNew.getDesig());
		pst.setDouble(5,employNew.getBasic());
		pst.setInt(6,employNew.getEmpno());
		pst.executeUpdate();
		return "Employ record updated";
		
	} return "Employ record not found";

	}
}
