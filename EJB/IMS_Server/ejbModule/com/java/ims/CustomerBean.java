package com.java.ims;

import java.util.List; 

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless
@Remote(CustomerBeanRemote.class)
public class CustomerBean implements CustomerBeanRemote {

    /**
     * Default constructor. 
     */
    public CustomerBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "CustMgmtPU")
	private EntityManager entityManager;


	@Override
	public List<Customer_Details> showCustomer() {
		System.out.println("Entit Manager is  " + entityManager);
		Query query = entityManager.createQuery("SELECT c FROM Customer_Details c");
		return (List<Customer_Details>) query.getResultList();
	}
	
    

}
