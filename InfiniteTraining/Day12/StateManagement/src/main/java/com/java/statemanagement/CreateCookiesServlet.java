package com.java.statemanagement;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCookies
 */
public class CreateCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ckJitendra= new Cookie("Jitendra","87");
		ckJitendra.setMaxAge(1000*60*60*24);
		response.addCookie(ckJitendra);
		
		Cookie ckRahul= new Cookie("Rahul","91");
		ckRahul.setMaxAge(1000*60*60*24);
		response.addCookie(ckRahul);
		
		Cookie ckSourav= new Cookie("Sourav","87");
		ckSourav.setMaxAge(1000*60*60*24);
		response.addCookie(ckSourav);
		
		PrintWriter out= response.getWriter();
		out.println("Cookies are created");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
