// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ServletTest extends HttpServlet {
public String fn = "Jason";
public String ln = "Bullock";
 
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
     
      // Set response content type
      response.setContentType("text/html");
      
      PrintWriter out = response.getWriter();
	  String title = "This is Jason's Servlet";
      String docType =
      "<!doctype html public \"-//w3c//dtd html 4.0 " +
      "transitional//en\">\n";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + fn + "\n" +
                "  <li><b>Last Name</b>: "
                + ln + "\n" +
                "</ul>\n" +
                "</body></html>");
  }
}