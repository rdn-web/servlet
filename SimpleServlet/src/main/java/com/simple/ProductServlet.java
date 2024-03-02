package com.simple;
import jakarta.servlet.http.*;
import java.io.*;

public class ProductServlet extends HttpServlet{
  protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
	  res.setContentType("text/html");
	  PrintWriter out =res.getWriter();
	  out.println("<html><head><title>Servlet</title></head>");
	  out.println("<body>");
	  double bill=0;
	  String[] amount=req.getParameterValues("product");
	  if (amount!=null)
	  {
		  for(int i=0;i<amount.length;i++) {
			  bill=bill+Double.parseDouble(amount[i]);
			  
		  }
	  }
	  
	  out.println("<font size=5>");
	  out.println("The final bill "+bill);
	  out.println("</font></body></html>");
	  out.close();
	  
  }
}
