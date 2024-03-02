package com.simple;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;


public class dynamicServlet extends GenericServlet{
	
	public void service(ServletRequest req,ServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		java.util.Date date=new java.util.Date();
		out.println("<h2>"+"Current date is "+date.toString()+"</h2>");
		out.close();
	}
  
}
