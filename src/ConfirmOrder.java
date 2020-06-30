import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String messageText = "Your order is Confirmed";
        
        
        // messageText = GlobalError.errStr;

        StringBuilder sb = new StringBuilder();
        for (String err : GlobalError.errorStrings) {
            sb.append(err).append("<br>");
        }

        messageText = sb.toString();
        GlobalError.errorStrings.clear();
        
        String color = "white";

        int status=Dao.confirmdelete();
		if (status > 0) {
      // successfuly inserted record
      messageText = "Order Confirmed";
      GlobalError.errorStrings.add(messageText);
     
    } else {
      // Error occured
      messageText = "Sorry ! Some Error during ordering";
      GlobalError.errorStrings.add(messageText);
      
    }
        out.print("<!DOCTYPE html><html lang='en'>");
        out.print("<head><meta charset='UTF-8'>");
        out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("<title>Registration</title>");
        out.print("<link rel='icon' href='images/materialize-logo.png'>");
		//out.print("<link href='css/materialize.min.css' type='text/css' rel='stylesheet'>");
		//out.print("<link href='css/style.min.css' type='text/css' rel='stylesheet'>");
		//out.print("<link href='css/custom/custom.min.css' type='text/css' rel='stylesheet'>");
        out.print("<link rel='stylesheet' href='css/layouts/page-center.css' type='text/css'></head>");
        out.print(
                "<body style='background-color:#b30000;'><center><img src='images/materialize-logo.png' width='75'><h1></h1><table width='50%' id='cus_table1'>");
        out.print("<tr><td align='center' style='color:" + color + "'>");
        out.print("<h2>" + messageText + "</h2> </td></tr>");
        out.print("<tr><td align='center'> <a href='admin-page.html'><button id='cus_btn'>OK</button></a> </td></tr></table></form></center></body></html>");
    }
}