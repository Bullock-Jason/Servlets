/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author BULLOJP
 */
 
public class SendEmail extends HttpServlet{
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Recipient's email ID needs to be mentioned.
      String to = "bul12006@byui.edu";
 
      // Sender's email ID needs to be mentioned
      String from = "jason.bullock@d11.org";
 
      // Assuming you are sending email from localhost
      String host = "owa1.cssd11.k12.co.us";
 
      // Get system properties
      Properties properties = System.getProperties();
 
      // Setup mail server
      properties.setProperty("192.168.1.99", host);
 
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);
      
	  // Set response content type
      response.setContentType("text/html");
      
      PrintWriter out = response.getWriter();
     
      try{
        
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         // Set Subject: header field
         message.setSubject("SENT FROM JASON'S SERVLET!");

         // Send the actual HTML message, as big as you like
         message.setContent("<h1>This was sent using servlet"
                 + " automation. BOOM. </h1>",
                            "text/html" );
         // Send message
         Transport.send(message);
         String title = "Send Email";
         String res = "Sent message successfully....";
         String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n" +
         "<p align=\"center\">" + res + "</p>\n" +
         "</body></html>");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}     

