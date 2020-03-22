package com.src.connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yt.backendbeta.Entity.Price;
import com.yt.backendbeta.Entity.Package;
import com.yt.backendbeta.Entity.Registration;
import com.yt.backendbeta.ServiceImpl.PackageImpl;
import com.yt.backendbeta.ServiceImpl.PriceImpl;
import com.yt.backendbeta.Utility.ConnectorClass;

/**
 * Servlet implementation class RegistrationClass
 */
@WebServlet("/RegistrationClass")
public class RegistrationClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag=false;
		String url="";
		HttpSession session = request.getSession();
		
		SessionFactory connection = ConnectorClass.getConnection();
		Session openSession = connection.openSession();
		openSession.getTransaction().begin();
		
		Registration registration = new Registration();
		Query query = openSession.createQuery("select phone from Registration");
		List<String> phoneNumber = query.list();
		
		for(String ph:phoneNumber) {
			if(ph.equals(request.getParameter("registrationContactNumber"))) {
				PrintWriter writer = response.getWriter();
	 			  writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
	 			  writer.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
	 			  writer.println("<script>");
	 			  writer.println("$(document).ready(function() {");
	 			  writer.println("swal( 'Number already registered' , 'Please check the registration data to verify the details' , 'error');");
	 			  writer.println("});");
	 			  writer.println("</script>");
	 			   flag = false; 			   
	 			   url="Homepage.jsp";	
	 			   break;
			    } 
			   else {
			       flag=true;
			        }			
		     }
		
		openSession.getTransaction().commit();
		openSession.close();
		
		if(flag) {
		
		
		String[] course = request.getParameterValues("registrationCourse");
	    String[] pkg = request.getParameterValues("registrationPackage");
	    

	    PriceImpl priceImpl = new PriceImpl();
	    List<Price> priceList = new ArrayList<Price>();
	    
	       if(course==null) {} else {
	       for(String cr : course) {
	    	
	         	if(priceImpl.getPrice(cr)==null) {
	        	   
	        	  PrintWriter writer = response.getWriter();
	 			  writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
	 			  writer.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
	 			  writer.println("<script>");
	 			  writer.println("$(document).ready(function() {");
	 			  writer.println("swal( 'Price Not Available for the course selected!' , 'Add price for course or Select different course' , 'error');");
	 			  writer.println("});");
	 			  writer.println("</script>");
	 			  
	 			  url="Homepage.jsp";
	 			  
	               } else {
	    	          priceList.add(priceImpl.getPrice(cr));
	              }                              
	          } 
	       }
         
	    if(pkg==null) {} 
	    
	    else {
	      for(String pk : pkg) {	    
	           if(priceImpl.getPrice(pk)==null) {
	        	   
	        	  PrintWriter writer = response.getWriter();
	 			  writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
	 			  writer.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
	 			  writer.println("<script>");
	 			  writer.println("$(document).ready(function() {");
	 			  writer.println("swal({title:'Price Not Available!' ,text: 'Add price for this package or Select different package' ,type: 'error'");

	 			  writer.println("}).then(function() {");
	 			  writer.println("window.location.href='/Homepage.jsp';");
	 			  writer.println("console.log('ok was clicked');");
	 			  writer.println("});");
	 			  writer.println("});");
	 			  writer.println("</script>");
	 			  
                   url="Homepage.jsp";
	 			  
	            } 
	           else {
	    	          priceList.add(priceImpl.getPrice(pk));
	              }
	        }
	      }
	       session.setAttribute("name", request.getParameter("registrationName"));
	       session.setAttribute("number", request.getParameter("registrationContactNumber"));
	       session.setAttribute("email", request.getParameter("registrationEmail"));
	       session.setAttribute("age", request.getParameter("registrationAge"));
	       session.setAttribute("address", request.getParameter("registrationAddress"));
	       session.setAttribute("gender", request.getParameter("gender"));
	       session.setAttribute("status", request.getParameter("registrationStatus"));
	       session.setAttribute("qualification", request.getParameter("registrationQualification"));
	       session.setAttribute("institute", request.getParameter("registrationInstituteName"));
	       session.setAttribute("discountId", request.getParameter("registrationDiscountId"));
	       session.setAttribute("date", Date.valueOf(LocalDate.now()));
	       session.setAttribute("price", priceList);
		   session.setAttribute("course", course);
		   session.setAttribute("package", pkg);
		
		   url="Conformation.jsp";
		    
		
		}//if end
		
		request.getRequestDispatcher(url).include(request, response);

		
	}

}
