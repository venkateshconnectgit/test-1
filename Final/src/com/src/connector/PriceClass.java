package com.src.connector;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.yt.backendbeta.Entity.Price;

import com.yt.backendbeta.Utility.ConnectorClass;

/**
 * Servlet implementation class PriceClass
 */
@WebServlet("/PriceClass")
public class PriceClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag=true;
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.getTransaction().begin();
		 Query queryOne = session.createQuery("select courseOrPackage from Price");
			List<String> nameList = queryOne.list();
	        String course = request.getParameter("course");
	        float taxPercent =(float) Integer.parseInt(request.getParameter("percentTax"));
   	        float coursePrice =(float) Integer.parseInt(request.getParameter("coursePrice"));
   	        float finalTax = coursePrice*(taxPercent/100);
   	        float finalPrice = finalTax+coursePrice;
                
       for(String str:nameList) {
    	   if(str.equals(course)) {
    		   
    	    Price price = new Price();          	     	        
   	        Query queryTwo = session.createQuery("from Price  where courseOrPackage=:name");
   	        queryTwo.setParameter("name", course);
            price =(Price) queryTwo.uniqueResult();
   	        price.setPercentTax((int) taxPercent);   	       
   	        price.setPrice((int)coursePrice);
   	        price.setPercentTax((int)taxPercent);
   	        price.setTotalTax((int)finalTax);
   	        price.setFinalPrice((int) finalPrice);
   	      	price.setCourseOrPackage(course);           
   	      	session.update(price);   
   	        flag=false;
    	    break;
    	   }
    	   else {
    		   flag=true;
    	   }
       }
        
       
        if(flag) {		
        	Price priceOne = new Price();
        	priceOne.setPercentTax((int) taxPercent);   	       
   	        priceOne.setPrice((int)coursePrice);
   	        priceOne.setPercentTax((int)taxPercent);
   	        priceOne.setTotalTax((int)finalTax);
   	        priceOne.setFinalPrice((int) finalPrice);
   	      	priceOne.setCourseOrPackage(course);  
   	      	session.save(priceOne);
        }
        
      
        
        session.getTransaction().commit();
		session.close();
        RequestDispatcher rd = request.getRequestDispatcher("Price.jsp");
        rd.forward(request, response);
	}

}
