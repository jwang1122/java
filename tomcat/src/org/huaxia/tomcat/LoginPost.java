package org.huaxia.tomcat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPost extends HttpServlet {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Method to handle GET method request.
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      // Set response content type
	      response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Using POST Method to Read Form Data";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         
	      out.println(docType +
	         "<html>\n" +
	            "<head><title>" + title + "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<ul>\n" +
	                  "  <li><b>user_name</b>: "
	                  + request.getParameter("user_name") + "\n" +
	                  "  <li><b>Password</b>: "
	                  + request.getParameter("password") + "\n" +
	               "</ul>\n" +
	            "</body>" +
	         "</html>"
	      );
	   }

	   // Method to handle POST method request.
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	      doGet(request, response);
	   }
}