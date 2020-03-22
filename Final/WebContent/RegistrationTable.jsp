<!DOCTYPE html>

<%@page import="com.yt.backendbeta.Entity.Course"%>
<%@page import="com.yt.backendbeta.Entity.Package"%>
<%@page import="com.yt.backendbeta.Entity.Registration"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.yt.backendbeta.Utility.ConnectorClass"%>
<%@page import="org.hibernate.SessionFactory"%>
<html lang="en">
<head>
    <title>Integrate datatable - Coding Birds Online</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"></script>
   
    <style> #thead>tr>th{ color: white; } </style>
</head>
<style media="screen">
  
  body{

    background: lightsteelblue;
    margin-left: ;
  }
#exampleTable{

    background-color: aliceblue;
  }
</style>
<body>
<%
SessionFactory connection = ConnectorClass.getConnection();
Session sessionOne = connection.openSession();  
sessionOne.getTransaction().begin();
Query queryOne = sessionOne.createQuery("from Registration");
List<Registration> registrationList =queryOne.list();
sessionOne.close();
%>

<div class="container">
    <table id="exampleTable" class="table table-striped table-bordered" style="width: 70%">
        <thead id="thead">
        <tr style="background-color: #1573ff">
            <th>Id</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Email</th>
            <th>Qualification</th>
            <th>Institution</th>
            <th>Registered Date(YYYY/MM/DD)</th>
            <th>Course Opted</th>
            <th>Package Opted</th>
            <th>Total Fee</th>
            <th>Fee Paid</th>
            <th>Fee Due</th>
            <th>Passout Date</th>
            <th>Course Completion Status</th>
        </tr>
        </thead>
        <tbody>
        <%for(Registration regd:registrationList) {%>
        <tr>       
            <td><%=regd.getId() %></td>
            <td><%=regd.getName() %></td>
            <td><%=regd.getGender() %></td>
            <td><%=regd.getPhone() %></td>
            <td><%=regd.getAddress() %></td>
            <td><%=regd.getEmail() %></td>
            <td><%=regd.getQualification() %></td>
            <td><%=regd.getInstitute() %></td>
            <td><%=regd.getRegisteredDate() %></td>
             
            <td><%
              String course="";
              List<Course> list = (List<Course>)regd.getCourse();
              if(list!=null){
                for(int i=0; i<list.size(); i++) {
            	  if(i==(list.size()-1)){
            		  course+=list.get(i).getCourseName()+".";
            	  } else {
            		  course+=list.get(i).getCourseName()+", ";
            	  }          	  
                } out.println(course);
              }
              else{
            	  out.println("None");
              }
              %>
            </td>      
            
            <td><%
              String pkg="";
              List<Package> plist = (List<Package>)regd.getPack();
              if(list!=null){
                for(int i=0; i<plist.size(); i++) {
            	  if(i==(plist.size()-1)){
            		  pkg+=plist.get(i).getName()+".";
            	  } else {
            		  pkg+=plist.get(i).getName()+", ";
            	  }          	  
                } out.println(pkg);
              }
              else{
            	  out.println("None");
              }
              %>
            </td>
            
            <td><%=regd.getTotalFee() %></td>
            <td><%=regd.getFeePaid() %></td>
            <td><%=regd.getFeeDue() %></td>
            <td><%=regd.getPassoutDate() %></td>
            <td><%=regd.getCourseCompletionStatus() %></td>

            
        </tr>
         <%}%>
        </tbody>
        <tfoot>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Email</th>
            <th>Qualification</th>
            <th>Institution</th>
            <th>Registered Date(YYYY/MM/DD)</th>
            <th>Course Opted</th>
            <th>Package Opted</th>
            <th>Total Fee</th>
            <th>Fee Paid</th>
            <th>Fee Due</th>
            <th>Passout Date</th>
            <th>Course Completion Status</th>
        </tr>
        </tfoot>
    </table>
    
</div>
<script>
    $(document).ready(function() {
        $('#exampleTable').DataTable();
    } );
</script>
</body>
</html>
