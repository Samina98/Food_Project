import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowItem")
public class ShowItem extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	
		List<Item> list = Dao.getAllItem();
        int i=1;
       // String message="<table border='1' width='80%' id='cus_table2'>";
		//request.getRequestDispatcher(message).forward(request, response);
		out.println("<html lang='en'><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>  <meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no'>  <meta http-equiv='X-UA-Compatible' content='IE=edge'>  <meta name='msapplication-tap-highlight' content='no'>  <title>Food Menu</title>");
		out.println("<link rel='icon' href='images/favicon/favicon-32x32.png' sizes='32x32'>");
		out.println("<link rel='apple-touch-icon-precomposed' href='images/favicon/apple-touch-icon-152x152.png'>");
		
		
		out.print("<link href='css/materialize.min.css' type='text/css' rel='stylesheet' media='screen,projection'>");
		out.print("<link href='css/style.min.css' type='text/css' rel='stylesheet' media='screen,projection'>");
		out.print("<link href='css/custom/custom.min.css' type='text/css' rel='stylesheet' media='screen,projection'>");
		
		out.println("<link href='js/plugins/perfect-scrollbar/perfect-scrollbar.css' type='text/css' rel='stylesheet' media='screen,projection'><link href='js/plugins/data-tables/css/jquery.dataTables.min.css' type='text/css' rel='stylesheet' media='screen,projection'>");
		out.println("</head><body>");
		out.println("<div id='loader-wrapper'><div id='loader'></div><div class='loader-section section-left'></div><div class='loader-section section-righ'></div>  </div>");
		out.println("<header id='header' class='page-topbar'>");
		out.println("<div class='navbar-fixed'>");
		out.println("<nav class='navbar-color'><div class='nav-wrapper'><ul class='left'>");
		out.println("<li><h1 class='logo-wrapper'><a href='index.html' class='brand-logo darken-1'></a> <span class='logo-text'>Logo</span></h1></li>");
		out.println("</ul></div></nav></div></header>");
		out.println("<div id='main'><div class='wrapper'><aside id='left-sidebar-nav'><ul id='slide-out' class='side-nav fixed leftside-navigation'><li class='user-details cyan darken-2'><div class='row'><div class='col col s4 m4 l4'>");
		out.println("<img src='images/avatar.jpg' alt='' class='circle responsive-img valign profile-image'></div></div></li>");
		out.println("<li class='bold active'><a><form action='Itemlist' class='waves-effect waves-cyan' method='get'><i class='mdi-editor-border-color'></i><input type='submit' value='Food Menu'></form></a></li>");
		
		out.println("<li class='bold'><a><form action='Orderlist' class='waves-effect waves-cyan' method='get'><i class='mdi-editor-insert-invitation'></i><input type='submit' value='Cart'></form></a></li>");
		out.println("<li class='bold'><a href='login.html'><i class='mdi-hardware-keyboard-tab'></i> Logout</form></a></li>");
		out.println("</ul><a href='#' data-activates='slide-out' class='sidebar-collapse btn-floating btn-medium waves-effect waves-light hide-on-large-only cyan'><i class='mdi-navigation-menu'></i></a></aside>");
		
		out.println("<section id='content'>");
		
		out.print("<div class='container'>");
		out.println("<div class='divider'></div><div class='row'><div class='col s12 m4 l3'><h4 class='header'>Order Food</h4></div>");
		out.print("<table border='1' width='50%' id='cus_table2'>");
        
        out.print("<tr><th>SL</th><th>Name</th><th>Price</th><th>Add</th></tr>");
       for (Item p : list) {
            out.print("<tr><td>" + i + "</td><td>" + p.getName() + "</td><td>" + p.getPrice() + 
                     "</td><td><a href='Add?id="+ p.getId()+"'>Add</a>"+"</td></tr>");
                    i++;
        }
        out.println("<div class='divider'></div>");
        out.print("</table></div></section></div>");   
		out.println("<footer class='page-footer'><div class='footer-copyright'><div class='container'><span>Copyright © 2020 <a class='grey-text text-lighten-4' href='#' target='_blank'></a> All rights reserved.</span><span class='right'> Design and Developed by <a class='grey-text text-lighten-4' href='#'>Samina Haque</a></span></div></div></footer>");	
		out.println("<script type='text/javascript' src='js/plugins/jquery-1.11.2.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/materialize.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/plugins/angular.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/plugins/perfect-scrollbar/perfect-scrollbar.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/plugins/data-tables/js/jquery.dataTables.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/plugins/data-tables/data-tables-script.js'></script>");	
		out.println("<script type='text/javascript' src='js/plugins/jquery-validation/jquery.validate.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/plugins/jquery-validation/additional-methods.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/plugins.min.js'></script>");	
		out.println("<script type='text/javascript' src='js/custom-script.js'></script>");	
			
		out.println("</body></html>");	
		
		request.getRequestDispatcher("admin_page.html").include(request, response);
        out.close();
    }
}