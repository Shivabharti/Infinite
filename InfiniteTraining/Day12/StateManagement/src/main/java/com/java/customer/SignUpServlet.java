package com.java.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Customer_InfoInfoServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pwd, reType;

		PrintWriter out = response.getWriter();

		pwd = request.getParameter("password");
		reType = request.getParameter("retypePassword");

		if (pwd.equals(reType)) {

			String userName = request.getParameter("userName");
			CustomerDAO dao = new CustomerDAOImpl();

			try {

				Customer_Info Customer_Info = dao.searchByUserName(userName);

				if (Customer_Info == null) {

					Customer_Info customerNew = new Customer_Info();

					customerNew.setFirstName(request.getParameter("firstName"));
					customerNew.setLastName(request.getParameter("lastName"));
					customerNew.setUserName(request.getParameter("userName"));
					String encr = EncryptPassword.getCode(request.getParameter("password"));
					customerNew.setPassword(encr);
					customerNew.setEmail(request.getParameter("email"));
					customerNew.setPhoneNo(request.getParameter("phoneNo"));
					out.println(dao.addCustomer(customerNew));

				} else {

					out.println("UserName Already Exists...");

				}
			} catch (ClassNotFoundException | SQLException e) { // TODO Auto-generated catch block

				e.printStackTrace();

			}
		} else {

			out.println("Password and Retype Password Must be Same...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
