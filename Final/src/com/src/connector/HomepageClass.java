package com.src.connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yt.backendbeta.Entity.Enquiry;
import com.yt.backendbeta.Utility.ConnectorClass;

@WebServlet("/HomepageClass")
public class HomepageClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomepageClass() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.getTransaction().begin();
		
		Enquiry enquiry = new Enquiry();
		
		Query queryOne = session.createQuery("select phoneNumber from Enquiry");
		List<String> nameList = queryOne.list();
		
		if(nameList!=null) {
		for(String str : nameList) {
		  if(request.getParameter("enquiryPhoneNumber").equals(str)) {	
			  
			  PrintWriter writer = response.getWriter();
			  writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			  writer.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			  writer.println("<script>");
			  writer.println("$(document).ready(function() {");
			  writer.println("swal( 'Record already exists' , 'Phone number is registred' , 'error');");
			  writer.println("});");
			  writer.println("</script>");

			  
			  response.sendRedirect("HomepageClassjsp");
		  }		  
		}
		}
		else {
		
		
		enquiry.setName(request.getParameter("enquiryName"));
		enquiry.setPhoneNumber(request.getParameter("enquiryPhoneNumber"));
		enquiry.setEmail(request.getParameter("enquiryEmail"));
		enquiry.setSource(request.getParameter("enquirySource"));
		enquiry.setComment(request.getParameter("enquiryComment"));
		
		String enquiredAbout="";
		String[] str =request.getParameterValues("enquiryCourse");
		String[] str1 = request.getParameterValues("enquiryPackage");
		
		
		if(str==null) {} else {
		      for(int i=0; i<str.length; i++) {
			    if(i==(str.length-1)) {
			      enquiredAbout = enquiredAbout+str[i];
			    } else {
				      enquiredAbout = enquiredAbout+str[i]+", ";
			    } 
		  }
		}
		
		if(str1==null) { 
			enquiredAbout = enquiredAbout+".";
		} else {
			for(int i=0; i<str1.length; i++) {
			    if(i==(str1.length-1)) {
			      if(str1.length==1) {
			         enquiredAbout = enquiredAbout+", "+str1[i]+".";
			      } else {
			      enquiredAbout = enquiredAbout+str1[i]+".";
			      }
			    } else {
				      enquiredAbout = enquiredAbout+str1[i]+", ";
			    } 
		  }
		}

		enquiry.setEnquiredbout(enquiredAbout);
        enquiry.setEnquiredDate(Date.valueOf(LocalDate.now()));
        		
        session.save(enquiry);
		session.getTransaction().commit();

		session.close();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Homepage.jsp");
		requestDispatcher.forward(request, response);
		}
		
		
	      
	      
	      
	      
	      
	      
	}

}
