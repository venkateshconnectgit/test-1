package com.src.connector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.yt.backendbeta.Entity.Course;
import com.yt.backendbeta.ServiceImpl.CourseImpl;

import com.yt.backendbeta.Utility.ConnectorClass;

/**
 * Servlet implementation class PackageClass
 */
@WebServlet("/PackageClass")
public class PackageClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackageClass() {
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
		SessionFactory connection = ConnectorClass.getConnection();
		Session session = connection.openSession();
		session.getTransaction().begin();
		
		com.yt.backendbeta.Entity.Package pack = new com.yt.backendbeta.Entity.Package();
		pack.setName(request.getParameter("packageName"));
        pack.setPackageId(request.getParameter("packageId"));
        String[] str = request.getParameterValues("course");
        CourseImpl course = new CourseImpl();
        List<Course> list  =  new ArrayList<Course>();
        for(String s : str) {
        	list.add(course.getCourseObject(s));
        }
        for(Course cr:list) {
          pack.getCourse().add(cr);
        }
        session.save(pack);
        session.getTransaction().commit();
		session.close();
		RequestDispatcher rd = request.getRequestDispatcher("Package.jsp");
        rd.forward(request, response);
	}

}
