

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet33")
/**
 * Servlet implementation class Servlet3
 */
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet3() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Servlet</title></head>");
		out.println("<font color=red size=5>");
		String nm=request.getParameter("n");
		out.println("hello "+nm+"Welcome");
		out.println("</font></body></html>");
		out.close();
		
		
	}

}
