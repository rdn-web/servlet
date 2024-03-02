package com.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/Servlet2")
/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
		
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet </title>");
		out.println("<head>");
		out.println("<body>");
		out.println("<font color=red size=5>");
		out.println("<h1> Welcome to servlet </h1>");
		out.println("</font>");
		out.println("</body>");
		out.println("<html>");
		out.close();
	}

}
