package com.simple;
import jakarta.servlet.http.*;
import java.io.*;



public class AddTwoServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		
		int k=i+j;
		
		//System.out.println(k);
		
		//PrintWriter out=res.getWriter();
		//out.println("Result is  "+k);
		
		HttpSession session=req.getSession();
		session.setAttribute("k", k);
		
		res.sendRedirect("SquareResult");
	}
  
	
}
