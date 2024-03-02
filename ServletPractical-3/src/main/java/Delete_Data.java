import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;

public class Delete_Data extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>Servlet DB Connectivity</title><head>");
		out.println("<body></body></html>");
		Connection con = null;
		Statement stmt = null;
		boolean flag=false;

		ResultSet rs = null;
		String uname = "root";
		String pwd = "";
		String constr = "jdbc:mysql://localhost:3306/students";
		out.println("<html><body>");
		out.println("<form action='Delete_Data' method='post' target='right_frame'>");
		out.println("<strong>Enter Roll for deletetion </strong><br>");
		out.println("<input name='sroll' type='text'>");
		out.println("<br><br>");
		out.println("<input type='submit' name='Submit'>");
		out.println("</form></body></html>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(constr, uname, pwd);
			stmt = con.createStatement();
			//out.println("\n Connected to Database");
			String studroll = req.getParameter("sroll");

				

			int n = Integer.parseInt(studroll);
			//stmt.executeUpdate("delete from student_tab where Roll_no=" + n);
            rs=stmt.executeQuery("select * from student_tab");
            rs=stmt.getResultSet();
            while(rs.next())

            {
                 int n1=rs.getInt(1);

                  if(n==n1)
                  {
                      flag=true;
                      stmt.executeUpdate("delete from student_tab where Roll_no='"+n+"'");
                      break;
                  }
            }
            if(flag==true)
              out.println(n+"<br> User Data deleted successfully");
            else
              out.println("Sorry "+n+" user data is Not Available");

            
            
           
		}
		

		catch (SQLException e) {
			throw new ServletException("Servlet cannot display records", e);

		} catch (ClassNotFoundException e) {
			throw new ServletException("JDBC Driver not found", e);
		}

		finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {
			}

		}

		out.close();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
