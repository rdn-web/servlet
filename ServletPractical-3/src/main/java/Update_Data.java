import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;



public class Update_Data extends HttpServlet{
	
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

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(constr, uname, pwd);
				stmt = con.createStatement();
				//out.println("\n Connected to Database");
				String studroll = req.getParameter("sroll");
				if(studroll==null)
					studroll="0"; 
				int n = Integer.parseInt(studroll);
		
				String newsp=req.getParameter("newphone");


			
				stmt.executeUpdate("update student_tab set phone="+newsp+" where Roll_no='"+n+"'");
				rs=stmt.executeQuery("select * from student_tab");
				
				out.println("<html><body>");
				out.println("<form action='Update_Data' method='post'>");
				
				out.println("<strong>Enter Roll Number for Updation</strong><br>");
				out.println("<input type='text' name='sroll'>");
				out.println("<br>");
				out.println("<strong>Enter New phone</strong><br>");
				out.println("<input type='text' name='newphone'>");
				out.println("<br><br>");
				out.println("<input type='submit' value='submit'>");
				out.println("</form></body></html>");
				
				/*if(true)
				out.println("<b>You are successfully update</b>");*/
				
				         
	            
	           
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
	
	
	
	

