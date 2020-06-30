import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/AddItem")  
public class AddItem extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();		
		
        String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);
		//out.println(id);
		Item p = Dao.getItemById(id);
		//out.println(p.getId());
		
        int status = Dao.add(p);

        
		
        if (status > 0) {
          // successfuly inserted record
		  out.println("<script type=\'text/javascript\'>");
					out.println("alert('Item added');");
					//out.println("location='login.html';");
					out.println("</script>");
          //GlobalError.errorStrings.add(messageText);
          
        } else {
          // Error occured
		  out.println("<script type=\"text/javascript\">");
					out.println("alert('item already in your cart');");
					//out.println("location='login.html';");
					out.println("</script>");
         
         // GlobalError.errorStrings.add(messageText);
         
        }
        
        //response.sendRedirect("Itemlist");
		request.getRequestDispatcher("Itemlist").include(request, response);
    
    }  
}