package com.java.customer;

import java.sql.SQLException;

public interface CustomerDAO {

	String addCustomer(Customer_Info customer) throws ClassNotFoundException, SQLException;
	Customer_Info searchByUserName(String userName) throws ClassNotFoundException, SQLException;
}
