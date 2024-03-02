package com.simple;
import jakarta.servlet.http.*;
import java.io.*;

public class SquareResult extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		
		int k=Integer.parseInt(req.getParameter("k"));
		k=k*k;
		System.out.println("Result is "+k);
		
		/*PrintWriter out=res.getWriter();
		
		out.println("Square of result is "+k);
		System.out.println("Square servlet is called");*/
		
	}

}
