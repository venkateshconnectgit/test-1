<!DOCTYPE html>
<%@page import="com.yt.backendbeta.Entity.Price"%>
<%@page import="com.yt.backendbeta.Entity.Course"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.yt.backendbeta.Utility.ConnectorClass"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.yt.backendbeta.Entity.Package"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Price</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="pricestyle.css">
</head>
<%
    
    SessionFactory connection = ConnectorClass.getConnection();
    Session sessionOne = connection.openSession();
    Query queryOne = sessionOne.createQuery("from Price"); 
    Query queryTwo = sessionOne.createQuery("from Course"); 
    Query queryThree = sessionOne.createQuery("from Package"); 
    List<Price> priceList=(List<Price>) queryOne.list();
    List<Course> courseList=(List<Course>) queryTwo.list();
    List<Package> packageList=(List<Package>) queryThree.list();
    String str="";
    int i=0;
%>
<body>
    <div class="container fluid p-10 col-lg-12 col-md-12 col-xs-12 col-sm-12">
        <div class="row" id="header">
            <h1>Price</h1>
        </div>
    </div>
    <div class="container fluid p-10 col-lg-12 col-md-12 col-xs-12 col-sm-12">
       <div class="row">
        <div class="col-lg-7 col-md-8 col-xs-12 col-sm-12">
            <div class="jumbotron" id="course-table">
                <h1>Price Table</h1><hr>
                <div class="table-div"> 
                   <div class="table-body">
                      <table class="content-table">
                      <tbody>
                        <tr>
                        <%for(Price price:priceList) {%>
                          <td><%=price.getId() %></td>
                          <td><%=price.getCourseOrPackage() %></td>
                          <td><%=price.getPrice() %></td>
                          <td><%=price.getPercentTax()+"%" %></td>
                          <td><%=price.getTotalTax() %></td>
                          <td><%=price.getFinalPrice() %></td>
               
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
               <h1>Update Course Price</h1><hr>          
                    <form class="" method="post" action="PriceClass">
                        <div class="selectbox">
                            <select class="slt-1" name="course" id="slt-1">
                               <option value="" hidden>Select a Course/Package</option>
                               <%for(Course courseName:courseList) {%>
                                <option value="<%=courseName.getCourseName()%>"><%=courseName.getCourseName()%></option>
                               <%}%>
                               <%for(Package pkg:packageList) {%>
                                <option value="<%=pkg.getName()%>"><%=pkg.getName()%></option>
                               <%}%>
                            </select>
                          </div>
                          <div class="custom-input">
                            <input type="text" name="coursePrice" placeholder="" required="">
                            <label for="">Course Price:</label>
                        </div>
                        <div class="custom-input">
                            <input type="text" name="percentTax" placeholder="" required="">
                            <label for="">Percentage Tax:</label>
                        </div>
                         <div class="button-container">
                            <input type="submit" name="button" value="Add"></input>
                           <button onclick="location.href = 'Index.html';" class="button-wrapper">Hello</button>                    
                        </div>
                    </form>
               </div>
          </div>        
       </div>
    </div>

</body>
</html>