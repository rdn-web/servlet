package com.simple;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class DemoServlet extends HttpServlet{  
		public void doGet(HttpServletRequest req,HttpServletResponse res)  
		throws ServletException,IOException  
		{  
		res.setContentType("text/html");  
		PrintWriter pw=res.getWriter();  
		  
		res.sendRedirect("http://www.google.com");  
		  
		pw.close();  
		}
}  

