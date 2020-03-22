<!DOCTYPE html>

<%@page import="com.yt.backendbeta.Entity.Enquiry"%>
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
    margin-left: 20%;
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
Query queryOne = sessionOne.createQuery("from Enquiry");
List<Enquiry> enquiryList =(List<Enquiry>) queryOne.list();

sessionOne.close();
%>

<div class="container">
    <table id="exampleTable" class="table table-striped table-bordered" style="width: 70%">
        <thead id="thead">
        <tr style="background-color: #1573ff">
            <th>Name</th>
            <th>Email</th>
            <th>Enquired Date(YYYY/MM/DD)</th>
            <th>Phone Number</th>
            <th>Courses enquired</th>
        </tr>
        </thead>
        <tbody>
        <%for(Enquiry enq:enquiryList) {%>
        <tr>       
            <td><%=enq.getName() %></td>
            <td><%=enq.getEmail() %></td>
            <td><%=enq.getEnquiredDate() %></td>
            <td><%=enq.getPhoneNumber() %></td> 
            <td><%=enq.getEnquiredbout()%></td>      
        </tr>
         <%}%>
        </tbody>
        <tfoot>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Enquired Date</th>
            <th>Phone Number</th>
            <th>Courses enquired</th>
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
