<!DOCTYPE html>

<%@page import="com.yt.backendbeta.Entity.Course"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.yt.backendbeta.Utility.ConnectorClass"%>
<%@page import="com.yt.backendbeta.Entity.Package"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Package</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="packagestyle.css">
</head>
<%
    SessionFactory connection = ConnectorClass.getConnection();
    Session sessionOne = connection.openSession();  
    sessionOne.getTransaction().begin();
    Query queryOne = sessionOne.createQuery("from Package");
    List<Package> packageList =(List<Package>) queryOne.list();
    Query queryTwo = sessionOne.createQuery("from Course");
    List<Course> courseList = (List<Course>) queryTwo.list();   
    int i = 0;
    String str = "";
    sessionOne.close();
%>

<body>
    <div class="container fluid p-10 col-lg-12 col-md-12 col-xs-12 col-sm-12">
        <div class="row" id="header">
            <h1>Package</h1>
        </div>
    </div>
    <div class="container fluid p-10 col-lg-12 col-md-12 col-xs-12 col-sm-12">
       <div class="row">
        <div class="col-lg-7 col-md-8 col-xs-12 col-sm-12">
            <div class="jumbotron" id="course-table">
                <h1> Package Table</h1>
                <div class="table-div">
                    
                     <div class="table-body">
                        <table class="content-table">
                        <tbody>
                          <%for(Package pk:packageList) {%>
                              <tr>       
                              <td><%=pk.getId() %></td>
                              <td><%=pk.getName() %></td>  
                              <%
                                  for(Course packageCourse:pk.getCourse()){
                                	  str=str+packageCourse.getCourseName()+", ";                                			  
                                  }
                              %>                                                                                   
                              <td><%=str %></td><%str=""; %>                 
                          </tr>
                        <%}%>                      
                        </tbody>
                      </table>
                      </div>
                    </div>
            </div>
        </div>
         <div class="col-lg-5 col-md-4 col-xs-12 col-sm-12">
           <div class="jumbotron" id="course-table">
               <h1>Create a Package</h1>
                    <form action="PackageClass" method="post">
                          <div class="custom-input">
                            <input type="text" name="packageName" placeholder="" required="">
                            <label for="">Package name:</label>
                        </div>
                        <div class="custom-input">
                            <input type="text" name="packageId" placeholder="" required="">
                            <label for="">Package Id:</label>
                        </div>
                        <div class="custom-input">
                            <label for="">Select Courses:<hr/></label>
                        </div><br><br><br>

                        <div class="custom-checkbox-container">
                            
                            <% for(Course cr : courseList){%>                             
                               <div>
                                 <label>
                                  <input type="checkbox" name="course" value="<%=cr.getCourseName()%>">                                
                                  <span><%=cr.getCourseName()%></span>
                                  <%i++;%>
                                 </label>
                               </div>
                              <%}%>
                             
                       </div>
                      
                          <div style="display: inline-block">    
                               <input type="submit" name="button" value="Create"></input>                                
                              <button onclick="location.href = 'Homepage.jsp';" class="button-wrapper-1">Home</button>                           
                         </div>
                    </form>
                    
               </div>
          </div>
       </div>
    </div>
</body>
</html>
