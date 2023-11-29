package com.java.library;

import java.sql.SQLException;
import java.util.List;

public interface LibraryDAO {
	String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException;
	int authenticate(LibUsers libUsers) throws ClassNotFoundException, SQLException;
	List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException;
	String issueBook(String userName, int bookId);
}
