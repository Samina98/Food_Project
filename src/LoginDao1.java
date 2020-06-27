import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginDao1")
public class LoginDao1 extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

                 String email = request.getParameter("email");
				String pass = request.getParameter("password");
               
				
				if(Dao.LoginDao1(email,pass))
				{ 	out.println("1");
					//response.sendRedirect("admin-page.html");
				}
				else
				{
					//out.println("1"); 
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Invalid username or password');");
					//out.println("location='login.html';");
					out.println("</script>");
				}
				
		}
}