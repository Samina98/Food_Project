import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveParticipant")
public class SaveParticipant extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    Participant p = new Participant();

    p.setName(name);
    p.setPhone(phone);
    p.setEmail(email);
    p.setPassword(password);
   
    // out.println(name+" "+mobile+" "+email+" "+affiliation+" "+occupation);

    int status = Dao.save(p);

    String messageText = "This is some Error Message Text";
    Integer messageType = 2;
    String redirecPage = "register.html";

    if (status > 0) {
      // successfuly inserted record
      messageText = "Record Successfully Inserted";
      GlobalError.errorStrings.add(messageText);
      messageType = 2;
      redirecPage = "register.html";
    } else {
      // Error occured
      messageText = "Sorry ! Some Error in Input";
      GlobalError.errorStrings.add(messageText);
      messageType = 1;
      redirecPage = "register.html";
    }

    request
        .getRequestDispatcher(
            "Message?messageText=" + messageText + "&messageType=" + messageType + "&redirectPage=" + redirecPage)
        .forward(request, response);

    out.close();
  }

}