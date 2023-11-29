package com.java.hibnew;

public class ValidateMain {
	public static void main(String[] args) {
		Login log= new Login();
		log.setUserName("Ankit");
		log.setPassCode("12345");
		long count= new LoginDAOImpl().loginValidate(log);
		if(count==1) {
			System.out.println("Correct");
		}else {
			System.out.println("Incorrect");
		}
//		Login login= new LoginDAOImpl().authenticate(log);
//		if(login!=null) {
//			System.out.println("Correct");
//		}else {
//			System.out.println("invalid");
//		}
	}
	
}
