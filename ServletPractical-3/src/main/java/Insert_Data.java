import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;

public class Insert_Data extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><head><title>Servlet DB Connectivity</title><head>");
		out.println("<body></body></html>");
		Connection con=null;
		Statement stmt=null;
	
		ResultSet rs=null;
		String uname="root";
		String pwd="";
		String constr="jdbc:mysql://localhost:3306/students";
		 out.println("<html><body>");
		 out.println("<form action='Insert_Data' method='post'>");
		 out.println("<strong>Roll : </strong><input name='sroll' type='text'><br><br>");
		 out.println("<strong>Name : </strong><input name='sname' type='text'><br><br>");
		 out.println("<strong>Address : </strong><input name='saddr' type='text'><br><br>");
		 out.println("<strong>Phone : </strong><input name='sphone' type='text'><br><br>");
		 out.println("<input type='submit' value='Submit'>");
		 out.println("</form>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(constr,uname,pwd);
			stmt=con.createStatement();
			out.println("\n Connected to Database");
						 
			PreparedStatement st = con.prepareStatement("insert into student_tab values(?, ?, ?,?)");
			// Same for second parameter
			st.setInt(1, Integer.valueOf(req.getParameter("sroll")));
			st.setString(2, req.getParameter("sname"));
			st.setString(3, req.getParameter("saddr"));
			st.setString(4, req.getParameter("sphone"));

			// Execute the insert command using executeUpdate()
			// to make changes in database

			st.executeUpdate();
			// Close all the connections
			st.close();
			con.close();

			// Get a writer pointer
			// to display the successful result

			out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");
			 

		     
 
		}catch(SQLException e) {
			throw new ServletException("Servlet cannot display records",e);
			
		}
		catch(ClassNotFoundException e) {
			throw new ServletException("JDBC Driver not found",e);
		}
		
		finally {
			try {
				if(rs!=null) {
					rs.close();
					rs=null;
				}
				if(stmt!=null) {
					stmt.close();
					stmt=null;
				}
				
				if(con!=null) {
					con.close();
					con=null;
				}
			}catch(SQLException e)
			{
		    }
			
		}
		
		out.close();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	      doPost(req, resp);
}
}
