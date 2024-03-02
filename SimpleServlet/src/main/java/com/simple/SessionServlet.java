package com.simple;
import jakarta.servlet.http.*;
import java.io.*;


public class SessionServlet extends HttpServlet {
@SuppressWarnings("removal")
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
	res.setContentType("text/html");
	HttpSession session=req.getSession();
	String heading;
	
	Integer cnt=(Integer)session.getAttribute("cnt");
	
	if(cnt==null)
	{
		cnt=new Integer(0);
		heading="Welcome to the website for the first time";
	    
	}else
	{
		heading="welcome once again";
		cnt=new Integer(cnt.intValue()+1);
		
	
     }
	
	session.setAttribute("cnt", cnt);
	PrintWriter out=res.getWriter();
	out.println("<html><head></head><body>");
	out.println("<center>");
	out.println("<h1>"+heading+"</h1>");
	out.println("<h2>"+"the number of previous access="+cnt+"<h2>");
	out.println("</center></body>");
	out.println("</html>");
	out.close();
}
}
