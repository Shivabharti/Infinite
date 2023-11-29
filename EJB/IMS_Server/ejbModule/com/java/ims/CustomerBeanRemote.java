package com.java.ims;

import java.util.List;

import javax.ejb.Remote;



@Remote
public interface CustomerBeanRemote {

	List<Customer_Details> showCustomer();
}
