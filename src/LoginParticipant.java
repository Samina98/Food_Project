import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginParticipant")
public class LoginParticipant extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

                String email = request.getParameter("email");
				String pass = request.getParameter("password");
               //response.sendRedirect("admin-page.html");
				//String redirecPage = "login.html";
				if(Dao.login(email,pass))
				{ 	//redirecPage = "admin-page.html";
					response.sendRedirect("admin-page.html");
				}
				else
				{
					 
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Invalid username or password');");
					//out.println("location='login.html';");
					out.println("</script>");
					request
        .getRequestDispatcher("login.html").include(request, response);
				}
			
    out.close();	
		}
}