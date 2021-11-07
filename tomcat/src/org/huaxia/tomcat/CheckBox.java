package org.huaxia.tomcat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckBox extends HttpServlet {
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
	      String title = "Reading Checkbox Data";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      String maths = request.getParameter("maths");
	      if(maths==null) maths = "off";
	      String physics = request.getParameter("physics");
	      if(physics==null) physics = "off";
	      String chemistry = request.getParameter("chemistry");
	      if(chemistry==null) maths = "off";
	      
	      out.println(docType +
	         "<html>\n" +
	            "<head><title>" + title + "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<ul>\n" +
	                  "  <li><b>Maths Flag : </b>: "
	                  + maths + "\n" +
	                  "  <li><b>Physics Flag: </b>: "
	                  + physics + "\n" +
	                  "  <li><b>Chemistry Flag: </b>: "
	                  + chemistry + "\n" +
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
