import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteItem")  
public class DeleteItem extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException { 

				response.setContentType("text/html");
			PrintWriter out = response.getWriter();		
		
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        int status = Dao.delete(id);

        String messageText = "This is some Error Message Text";
        Integer messageType = 2;
        String redirecPage = "View";
    
        if (status > 0) {
          // successfuly inserted record
         out.println("<script type=\'text/javascript\'>");
					out.println("alert('Item deleted');");
					//out.println("location='login.html';");
					out.println("</script>");
        } else {
          // Error occured
         out.println("<script type=\"text/javascript\">");
					out.println("alert('Error found during deleting');");
					//out.println("location='login.html';");
					out.println("</script>");
         
        }
        
       request.getRequestDispatcher("Orderlist").include(request, response);

    }  
}