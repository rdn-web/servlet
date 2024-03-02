package com.simple;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;



public class Servlet1 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws IOException {
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
