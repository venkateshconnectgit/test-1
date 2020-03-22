package com.src.connector;

import java.io.IOException;
import java.util.List;

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

import com.yt.backendbeta.Entity.Course;
import com.yt.backendbeta.ServiceImpl.CourseImpl;
import com.yt.backendbeta.Utility.ConnectorClass;

/**
 * Servlet implementation class Course
 */

@WebServlet("/Course")
public class CourseClass extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseClass() {
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
		
		boolean flag=false;
		
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.getTransaction().begin();
		
		
		CourseImpl courseImpl = new CourseImpl();
		String courseCheck = request.getParameter("courseName");
		
		Query query = session.createQuery("from Course where courseName=:name");
		query.setParameter("name", courseCheck);
		List<Course> courseList = query.list();
		for(Course st : courseList) {
			if(st.getCourseName().equalsIgnoreCase(courseCheck)) {
				flag = true;
			} else {
				flag=false;
			}
		}
		
		if(flag) {
			Course course = new Course();
            Query queryTwo = session.createQuery("from Course where courseName=:name"); 
            queryTwo.setParameter("name", courseCheck);			
			course =(Course) queryTwo.uniqueResult();
			String parameter = request.getParameter("courseSyllabus");
			course.setCourseSyllabus((String) parameter);
			course.setCourseName((String) courseCheck);
			session.update(course);
			session.getTransaction().commit();			
            }
		
	   else {
		   Course course = new Course();
	       course.setCourseName(request.getParameter("courseName"));
           course.setCourseSyllabus(request.getParameter("courseSyllabus"));
           session.save(course);
           session.getTransaction().commit();
	   	  
		}
		 
		 session.close();
		 RequestDispatcher rd = request.getRequestDispatcher("Course.jsp"); 
         rd.forward(request, response);
		
	}

}
