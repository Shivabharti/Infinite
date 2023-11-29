package com.java.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccountServlet
 */
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bank bank= new Bank();
		bank.setFirstName(request.getParameter("firstName"));
		bank.setLastName(request.getParameter("lastName"));
		bank.setCity(request.getParameter("city"));
		bank.setState(request.getParameter("state"));
		bank.setAmount(Integer.parseInt(request.getParameter("amount")));
		bank.setCheqFacil(request.getParameter("cheqFacil"));
		bank.setAccountType(request.getParameter("accountType"));
		PrintWriter out = response.getWriter();
		BankDAO dao= new BankDAOImpl();
		try {
			out.println(dao.createAccountDao(bank));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}




