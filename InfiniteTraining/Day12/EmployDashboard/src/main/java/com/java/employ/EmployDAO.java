package com.java.employ;

import java.sql.SQLException;
import java.util.List;

public interface EmployDAO {

	List<Employ> showEmployDao() throws ClassNotFoundException, SQLException;
	Employ searchEmployDao(int empno) throws ClassNotFoundException, SQLException;
	String addEmployDAO(Employ employ) throws ClassNotFoundException, SQLException;
	String deleteEmployDAO(int empno) throws ClassNotFoundException, SQLException;
	String updateEmployDao(Employ employNew) throws ClassNotFoundException, SQLException;
}
