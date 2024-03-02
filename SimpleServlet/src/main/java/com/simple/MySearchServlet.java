package com.simple;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class MySearchServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        String name=request.getParameter("name");  
        response.sendRedirect("https://www.google.co.in/#q="+name);  
    }  
}
