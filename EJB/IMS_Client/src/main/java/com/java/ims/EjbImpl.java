package com.java.ims;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class EjbImpl {

	SessionFactory sf;
	Session session;

	public List<Customer_Details> showCustomer() throws NamingException {
		CustomerBeanRemote remote = RemoteHelper.lookupRemoteStatelessCustomer();
		return remote.showCustomer();
	}

	public List<Insurance_Details> showInsurance() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Insurance_Details.class);
		List<Insurance_Details> insList = cr.list();
		return insList;
	}

	public Insurance_Details getInsurance(String insuranceId) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Insurance_Details.class);
		cr.add(Restrictions.eq("insurance_id", insuranceId));
		Insurance_Details inssu = (Insurance_Details) cr.uniqueResult();
		return inssu;
	}
	
	public String getInsurancePlans(String insuranceId) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		Criteria cr = session.createCriteria(Ins_Plans.class);
		cr.add(Restrictions.eq("insurance_id", insuranceId));
		List<Ins_Plans>insList=cr.list();
		sessionMap.put("insList", insList);
 
		return"ShowInsPlans.jsp?faces-redirect=true";		
	}
	
	public List<Ins_Plans>showInsPlans(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Ins_Plans.class);
		List<Ins_Plans> planiList=cr.list();
		return planiList;
	}

	public String addCustomer(Customer_Details cust) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		String encr = EncryptPassword.getCode(cust.getPassCode());
		cust.setPassCode(encr);
		session.save(cust);
		session.getTransaction().commit();

		int otp = GenerarteOtp.generateOtp();

		String subject = "Welcome to life Insurance";
		String messageText = "Hello,\n\nThank you for signing up in our LicApp. Your otp is "+otp+" It is "
				+ "valid for 10 minuetes only dont share your  otp with others";
		MailSend.mailSend(cust.getEmail(), subject, messageText);

		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans1 = session.beginTransaction();
		Customer_Authorization custAuth = new Customer_Authorization();
		custAuth.setCust_ID(cust.getCust_ID());
		custAuth.setOtp(otp);
		session.save(custAuth);
		session.getTransaction().commit();
		return "CustomerAuth.jsp?faces-redirect=true";
	}
	
	public String addAuthorization(Customer_Authorization custA) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Customer_Authorization customer_Auth=getOtp(custA.getCust_ID());
		Customer_Details customera=getMailId(custA.getCust_ID());
		
		int otpTable=customer_Auth.getOtp();
		int otp=custA.getOtp();
		System.out.println("outside if");
		
		if(otpTable == otp) {
			System.out.println("inside if");
 
			String email=customera.getEmail();
			String subject = "Welcome to Life Insurance ";
			String messageText = "Hello,\n\n Your account has been successfully created.Congragulation you are now goldmember";
					
			MailSend.mailSend(email, subject, messageText);
			
			return"ResetPassWord.jsp?faces-redirect=true";
		}else {
			return"CustomerAuth.jsp?faces-redirect=true";
		}
	}

	public Customer_Details getMailId(String custId) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Customer_Details.class);
		cr.add(Restrictions.eq("cust_ID", custId));
		Customer_Details cust = (Customer_Details) cr.uniqueResult();

		return cust;
	}

	public Customer_Authorization getOtp(String custId) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Customer_Authorization.class);
		cr.add(Restrictions.eq("cust_ID", custId));
		Customer_Authorization custA = (Customer_Authorization) cr.uniqueResult();

		return custA;
	}


	public String resetPassWord(Customer_Details cust) {

		Customer_Details custp = getMailId(cust.getCust_ID());
		String pass1 = cust.getPassCode();
		String pass2 = cust.getReTypePassCode();
		if (pass1.equals(pass2)) {
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction trans = session.beginTransaction();
			String encr = EncryptPassword.getCode(cust.getPassCode());
			custp.setPassCode(encr);
			custp.setReTypePassCode(encr);
			custp.setStatus("Active");
			session.update(custp);
			session.getTransaction().commit();
			return "LoginCustomer.jsp?faces-redirect=true";
		} else {
			return "ResetPassWord.jsp?faces-redirect=true";

		}
	}

	public String LoginCustomer(Customer_Details customer) {
	//	String encr = EncryptPassword.getCode(customer.getPassCode());
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		Criteria cr = session.createCriteria(Customer_Details.class);
		cr.add(Restrictions.eq("userName", customer.getUserName()));
		cr.add(Restrictions.eq("passCode", EncryptPassword.getCode(customer.getPassCode())));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		if (count == 1) {
			sessionMap.put("userName", customer.getUserName());
			return "Dashboard.jsp?faces-redirect=true";
		} else {
			return "LoginCustomer.jsp?faces-redirect=true";
		}

	}

	public String addCustomerPolicy(CustomerPolicy policy) {
//		Insurance insFound=getInsurance(policy.getInsuranceId());
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		if (policy.getPayMode().equals("MONTHLY")) {
			double amount = policy.getInsuranceAmount();
			double price = (amount / 12);
			policy.setInitialAmount(price);
			session.save(policy);
			session.getTransaction().commit();
		} else if (policy.getPayMode().equals("QUARTERLY")) {
			double amount = policy.getInsuranceAmount();
			double price = (amount / 4);
			policy.setInitialAmount(price);
			session.save(policy);
			session.getTransaction().commit();

		} else if (policy.getPayMode().equals("HALFYEARLY")) {
			double amount = policy.getInsuranceAmount();
			double price = (amount / 2);
			policy.setInitialAmount(price);
			session.save(policy);
			session.getTransaction().commit();
		} else if (policy.getPayMode().equals("YEARLY")) {

			policy.setInitialAmount(policy.getInsuranceAmount());
			session.save(policy);
			session.getTransaction().commit();
		}
		return "ShowCustomerPolicy.jsp?faces-redirect=true";
	}

	public List<Insurance_Details> getListOfInsurance(int firstRow, int rowCount) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<Insurance_Details> cdList = null;
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Insurance_Details.class);
		criteria.setFirstResult(firstRow);
		criteria.setMaxResults(rowCount);
		return criteria.list();
	}

	public int countRows() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Insurance_Details.class);
			if (criteria != null) {
				return criteria.list().size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String getCustomerPlans(int planId) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		Criteria cr = session.createCriteria(Ins_Plans.class);
		cr.add(Restrictions.eq("planId", planId));	
		Ins_Plans inssu=(Ins_Plans) cr.uniqueResult();
		sessionMap.put("inssu", inssu);
		return"Booking.jsp?faces-redirect=true";
	}
	
	public  String SendMail(String custId,Date date,String policymode) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Customer_Details.class);
		cr.add(Restrictions.eq("custId", custId));
		Customer_Details cust=(Customer_Details) cr.uniqueResult();
		Date currentDate=date;
		Calendar calender=Calendar.getInstance();
		calender.setTime(currentDate);
		if(policymode.equals("MONTHLY")) {
			calender.add(Calendar.MONTH,1);
		}else if(policymode.equals("QUARTERLY")) {
			calender.add(Calendar.MONTH,4);
		}else if(policymode.equals("HALFYEARLY")) {
			calender.add(Calendar.MONTH,4);
		}else if(policymode.equals("YEARLY")) {
			calender.add(Calendar.YEAR,1);
		}
		Date newDate=calender.getTime();
		String email=cust.getEmail();
		String subject = "Welcome to Life Insurance ";
		String messageText = "Hello,\n\n Your Policy has been successfully Taken.Your next payment given date is"+newDate;
				
		MailSend.mailSend(email, subject, messageText);
		return"ShowCustomerPolicy.jsp?faces-redirect=true";
 
	}
	
	public String addCustomerPlans(CustomerPolicy policy,Ins_Plans ins) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		CustomerPolicy policyy = new CustomerPolicy();
		double premium=ins.getPremiumAmount();
		int planId=ins.getPlan_ID();
		String insId=ins.getInsurance_id();
		String policymode=policy.getPayMode();
		double installAmount=0;
		if(policymode.equals("MONTHLY")) {
			 installAmount=(premium/12);
		}else if(policymode.equals("QUARTERLY")) {
			 installAmount=(premium/4);
		}else if(policymode.equals("HALFYEARLY")) {
			 installAmount=(premium/2);
		}else if(policymode.equals("YEARLY")) {
			 installAmount=premium;
		}
		policyy.setCust_ID(policy.getCust_ID());
		policyy.setInsuranceId(insId);
		policyy.setInsuranceAmount(premium);
		policyy.setPayMode(policymode);
		policyy.setRegisterDate(policy.getRegisterDate());
		policyy.setInitialAmount(installAmount);
		policyy.setPlanId(planId);
		session.save(policyy);
		session.getTransaction().commit();
		SendMail(policy.getCust_ID(),policyy.getRegisterDate(),policyy.getPayMode());
		return"ShowCustomerPolicy.jsp?faces-redirect=true";
	}
}
