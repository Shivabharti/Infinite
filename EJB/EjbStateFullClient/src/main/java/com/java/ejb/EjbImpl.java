package com.java.ejb;

import javax.naming.NamingException;

public class EjbImpl {

	public 	String sayHelloEjb() throws NamingException {
		HelloBeanRemote remote = RemoteHelper.lookupRemoteStateFullHello();
		return remote.sayHello();

	}
	
	public 	String companyEjb() throws NamingException {
		HelloBeanRemote remote = RemoteHelper.lookupRemoteStateFullHello();
		return remote.company();

	}

}
