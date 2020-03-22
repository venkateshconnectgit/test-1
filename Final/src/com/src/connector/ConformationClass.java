package com.src.connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yt.backendbeta.Entity.Course;
import com.yt.backendbeta.Entity.Package;
import com.yt.backendbeta.Entity.Registration;
import com.yt.backendbeta.ServiceImpl.CourseImpl;
import com.yt.backendbeta.ServiceImpl.PackageImpl;
import com.yt.backendbeta.Utility.ConnectorClass;

@WebServlet("/ConformationClass")
public class ConformationClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ConformationClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="";
		SessionFactory connection = ConnectorClass.getConnection();
		Session sessionOne = connection.openSession();
		sessionOne.getTransaction().begin();
	    HttpSession session = request.getSession();
		
		Registration registration = new Registration();
		
		registration.setAddress((String) session.getAttribute("address"));
		registration.setAge(Integer.parseInt((String) session.getAttribute("age")));
		registration.setCourseCompletionStatus(0);
		registration.setEmail((String) session.getAttribute("email"));
		registration.setGender((String) session.getAttribute("gender"));
		registration.setInstitute((String) session.getAttribute("institute"));
		registration.setName((String) session.getAttribute("name"));
		registration.setPhone((String) session.getAttribute("number"));
		registration.setQualification((String) session.getAttribute("qualification"));
		registration.setRegisteredDate((Date) session.getAttribute("date"));

        List<Course> courseList = new ArrayList<Course>();
        List<Package> packageList = new ArrayList<Package>();
        
        PackageImpl packageImpl = new PackageImpl();   
        
        if(session.getAttribute("package")==null) {} else {
        for(String pkg : (String[]) session.getAttribute("package")) {
        	packageList. add(packageImpl.getPackageName(pkg));
          }
        }
        
        CourseImpl courseImpl = new CourseImpl();
        
        if(session.getAttribute("course")==null) {} else {
        for(String cr : (String[]) session.getAttribute("course")) {
        	courseList.add(courseImpl.getCourseObject(cr));
         }
        }
        
		registration.setCourse(courseList);

		registration.setPack(packageList);;
		
		int amount = (int) session.getAttribute("amount");
		int paid = Integer.parseInt(request.getParameter("paid"));
		registration.setTotalFee(amount);
		if(paid<0) {
			  PrintWriter writer = response.getWriter();
			  writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			  writer.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			  writer.println("<script>");
			  writer.println("$(document).ready(function() {");
			  writer.println("swal( 'Amount not valid' , 'Amount entered is less than zero' , 'error');");
			  writer.println("});");
			  writer.println("</script>");
			  
		} else {
		   registration.setFeePaid(paid);
		  registration.setFeeDue((amount-paid));
		//registration.setPassoutDate();

		
		try {
		      sessionOne.save(registration);
		      sessionOne.getTransaction().commit();
		      sessionOne.close();
		      PrintWriter writer = response.getWriter();
			  writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			  writer.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			  writer.println("<script>");
			  writer.println("$(document).ready(function() {");
			  writer.println("swal( 'Registered Successfully!' , '' , 'success');");
			  writer.println("});");
			  writer.println("</script>");	  
			  url="Homepage.jsp";
			  
		 } catch(Exception e) {
			
			 PrintWriter writer = response.getWriter();
			  writer.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			  writer.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			  writer.println("<script>");
			  writer.println("$(document).ready(function() {");
			  writer.println("swal( 'Registered Failed' , 'Please try again' , 'error');");
			  writer.println("});");
			  writer.println("</script>");	
			  url="Homepage.jsp";
		  }
		}
		request.getRequestDispatcher(url).include(request, response);;
	}

}
