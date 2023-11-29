package com.java.ejb;

import javax.naming.NamingException;

public class Dummy {

	public static void main(String[] args) {
		try {
			System.out.println(RemoteHelper.lookupRemoteStateFullHello());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.println("Hello");
	}
}
