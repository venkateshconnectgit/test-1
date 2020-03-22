<!DOCTYPE html>
<%@page import="com.yt.backendbeta.Utility.ConnectorClass"%>
<%@page import="com.yt.backendbeta.Entity.Course"%>
<%@page import="com.yt.backendbeta.Entity.Package"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage</title>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="Homepage.css">

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
%>
<body>
 <div class="container-fluid p-10">   
    <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top" id="navigation">         
        <button class="navbar-toggler" data-toggle="collapse" data-target="#collapse_target">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse " id="collapse_target">
         <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="RegistrationTable.jsp">Registration</a></li>
            <li class="nav-item"><a class="nav-link" href="EnquiryTable.jsp">Enquiry</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Student</a></li>
            <li class="nav-item"><a class="nav-link" href="Course.jsp">Course</a></li>
            <li class="nav-item"><a class="nav-link" href="Package.jsp">Package</a></li>
            <li class="nav-item"><a class="nav-link" href="Price.jsp">Pricing</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Follow up</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Faculty</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Test</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Feedback</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
         </ul>

        </div>
    </nav>

    <div class="row" id="enquiry">
        <div class="col-lg-8 col-md-6 col-xs-12 col-s-12" >
            <div class="jumbotron">
              <h1>Availability</h1>
            </div>
        </div>
        <div class="col-lg-4 col-md-6 col-xs-12 col-s-12" id="enquiry-container">
            <div class="jumbotron">
                <text style="font-size: 40px;">Enquiry</text><hr>
                <form action="HomepageClass" method="post">
                    <div class="custom-input">
                        <input type="text" name="enquiryName" placeholder="" required="">
                        <label for="">Name:</label>
                    </div>
                    <div class="custom-input">
                        <input type="text" name="enquiryPhoneNumber" placeholder="" required="">
                        <label for="">Contact Number:</label>
                    </div>
                    <div class="custom-input">
                        <input type="text" name="enquiryEmail" placeholder="" required="">
                        <label for="">Email:</label>
                    </div>
                    <div class="custom-input">
                        <label for="">Course(s) Enquired:<hr style="background: black;"></label><br><br><br><br>
                    </div>
                    <div class="custom-checkbox-container">
                      <%for(Course cr:courseList) {%>
                        <div>
                            <label>
                                <input type="checkbox" name="enquiryCourse" value="<%=cr.getCourseName()%>">
                                <span><%=cr.getCourseName()%></span>
                            </label>
                        </div>
                       <%}%>
                       <%for(Package pkg:packageList) {%>
                        <div>
                            <label>
                                <input type="checkbox" name="enquiryPackage" value="<%=pkg.getName()%>">
                                <span><%=pkg.getName() %></span>
                            </label>
                        </div>
                       <%}%>
                    </div>
                    <div class="custom-input">
                        <input type="text" name="enquirySource" placeholder="" required="">
                        <label for="">Source:</label>
                    </div>
                    <div class="custom-input">
                        <input type="text" name="enquiryComment" placeholder="" required="">
                        <label for="">Comment:</label>
                    </div>
                    <div class="button-wrapper" id="submit-button">
                       <input type="submit" name="button" value="Submit"></input>
                    </div>
                </form>
            </div>
         </div>
    </div>
    <div class="row" id="registration">
        <div class="col-lg-12 col-md-12 col-xs-12 col-s-12" id="registration-container">
            <div class="jumbotron">
              <h1>Registration</h1><hr>
            </div>
        </div>
        <div class="col-lg-6 col-md-12 col-xs-12 col-s-12" id="registration-container1">
            <div class="jumbotron">
              
                <form action="RegistrationClass" method="Post" id="registration-form">
                    <div class="custom-input">
                        <input type="text" name="registrationName" >
                        <label for="">Name:</label>
                    </div>
                    <div class="custom-input">
                        <input type="text" name="registrationContactNumber" >
                        <label for="">Contact Number:</label>
                    </div>
                    <div class="custom-input">
                        <input type="text" name="registrationEmail" >
                        <label for="">Email:</label>
                    </div>
                    <div class="custom-input">
                        <input type="text" name="registrationAge" >
                        <label for="">Age:</label>
                    </div>
                    <div class="custom-input" >
                        <textarea name="registrationAddress" for="registration-form" required cols="5" wrap="hard"></textarea>
                        <label for="">Address:</label> 
                     </div>
                     <div class="custom-input" id="radio-id">
                        <label for="" >Select Gender: </label>
                     </div>
                     <div class="radio-container" >                       
                        <input type="radio" class="form_radio" name="gender" value="Male" id="radioId1" required>
                        <label for="radioId1" class="radio_label">Male</label>
                        <input type="radio" class="form_radio" name="gender" value="Female" id="radioId2" required>
                        <label for="radioId2" class="radio_label">Female</label>
                        <input type="radio" class="form_radio" name="gender" value="Other" id="radioId3" required>
                        <label for="radioId3" class="radio_label">Other</label>
                      </div>
                     
            </div>
        </div>
        <div class="col-lg-6 col-md-12 col-xs-12 col-s-12" id="registration-container2">
            <div class="jumbotron">
                <div class="custom-input">
                    <input type="text" name="registrationStatus">
                    <label for="">Status:</label>
                </div>
                <div class="custom-input">
                    <input type="text" name="registrationInstituteName" >
                    <label for="">Institute Name:</label>
                </div>
                <div class="custom-input">
                    <input type="text" name="registrationQualification">
                    <label for="">Qualification:</label>
                </div>
                <div class="custom-input">
                    <input type="text" name="registrationDiscountId">
                    <label for="">Discount Id(if applicable):</label>
                </div>               
              <h2>Select course(s)</h2><hr>
              <div class="custom-checkbox-container" id="ccc">
                      <%for(Course cr:courseList) {%>
                        <div>
                            <label>
                                <input type="checkbox" name="registrationCourse" value="<%=cr.getCourseName()%>">
                                <span><%=cr.getCourseName()%></span>
                            </label>
                        </div>
                       <%}%>
                       <%for(Package pkg:packageList) {%>
                        <div>
                            <label>
                                <input type="checkbox" name="registrationPackage" value="<%=pkg.getName()%>">
                                <span><%=pkg.getName() %></span>
                            </label>
                        </div>
                       <%}%>
                    </div>
                <div class="button-wrapper" id="submit-button">
                  <input type="submit" name="button" value="Proceed"></input>
               </div>
            </div>
        </div>
    </div>
 </div>


</body>
</html>
