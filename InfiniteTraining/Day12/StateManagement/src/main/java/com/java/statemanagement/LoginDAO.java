package com.java.statemanagement;

import java.sql.SQLException;

public interface LoginDAO {

	String createUser(Login login) throws ClassNotFoundException, SQLException;
}
