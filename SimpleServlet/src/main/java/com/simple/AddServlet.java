package com.simple;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;

//@WebServlet("/add")
public class AddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException {
		int i =Integer.parseInt(req.getParameter("num1"));
		int j =Integer.parseInt(req.getParameter("num2"));
		
		int k=i+j;
		
		System.out.println("Addition is "+k);
		
		PrintWriter out=res.getWriter();
		out.println("Addition is "+k);
		

	}
	

}
