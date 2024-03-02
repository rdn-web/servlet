import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;


public class Display_Data extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>Servlet DB Connectivity</title><head>");
		out.println("<body>");
		Connection con = null;
		Statement stmt = null;
		boolean flag=false;

		ResultSet rs = null;
		String uname = "root";
		String pwd = "";
		String constr = "jdbc:mysql://localhost:3306/students";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(constr, uname, pwd);
			stmt = con.createStatement();
			out.println("\n Connected to Database");
			out.println("\n\n");
			rs=stmt.executeQuery("select * from student_tab");
			
			//displaying records
			out.println("<center>");
			out.println("<h2>Students Database</h2>");
			out.println("<table border='3'>");
			out.println("<th>Roll Number</th>");
			out.println("<th>Name</th>");
			out.println("<th>Address</th>");
			out.println("<th>Phone</th>");
			
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.print(rs.getObject(1).toString());
				out.println("</td>");
				out.println("<td>");
				out.print(rs.getObject(2).toString());
				out.println("</td>");
				out.println("<td>");
				out.print(rs.getObject(3).toString());
				out.println("</td>");
				out.println("<td>");
				out.print(rs.getObject(4).toString());
				out.println("</td>");
				out.println("</tr>");
				
			}
			  
			 out.print("</table>"); 
			 out.print("</center>");

			 out.print("</body></html>");
			
			
			
			
			
		}			catch (SQLException e) {
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

