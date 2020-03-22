

   <!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.yt.backendbeta.Entity.Price"%>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="Conformation.css">
    <title></title>
  </head>
  <body>
    <div class="main-container">
     <div class="container-1">
       <center><h1>Confirmation</h1></center><hr/>
       <h3>Name: <text class="text-1">${name}</text></h3>
       <h3>Contact Number: <text class="text-1" col="10">${number}</text></h3>
       <h3>Gender: <text class="text-1">${gender}</text></h3>
       <h3>Age: <text class="text-1">${age}</text></h3>
       <h3>Email Id: <text class="text-1">${email}</text></h3>
       <h3>Address: <text class="text-1">${address}</text></h3>
       <h3>Qualification: <text class="text-1">${qualification}</text></h3>
       <h3>Institute: <text class="text-1">${institute}</text></h3>
       <h3>Courses opted: <text class="text-1">
       <%
          String[] list = (String[]) session.getAttribute("course");
          String[] plist = (String[]) session.getAttribute("package");
          String course="";
          if(list==null){}
          else{
             for(int i=0; i<(list.length); i++) {
            	   if(i==(list.length-1)) {
            		   course+=list[i];
            	   } else {
            	   course+=list[i]+", ";
            	   }
             } 
          }
          
          if(plist==null){course+=".";} 
          else if(list!=null){
             for(int i=0; i<(plist.length); i++){
            	 if(i==(plist.length-1)){
            		 course+=", "+plist[i]+".";
            	 } else{
            		 course+=", "+plist[i];
            	 }
             }
          }
          else if(list==null){
        	  for(int i=0; i<(plist.length); i++){
             	 if(i==(plist.length-1)){
             		 course+=plist[i]+".";
             	 } else{
             		 course+=plist[i]+", ";
             	 }
              }
          }
          
          out.println(course);    
       %>
       </text></h3>
       <h3>Registration Date: <text class="text-1">${date}</text></h3>

     </div>
     
    <% 
       List<Price> price = (List<Price>) session.getAttribute("price"); 
       int netAmount=0;
     %>
     <div class="container-2">
       <center><h1>Fee Information</h1></center><hr/>
       
       <%for(Price pr : price) {%>
       <text class="text-2">Course/Package Name: <text class="text-3"><% out.println(pr.getCourseOrPackage());%></text></text><br>
       <text class="text-2">Price: <text class="text-3"><% out.println(pr.getPrice());%></text></text><br>
       <text class="text-2">Tax percent: <text class="text-3"><% out.println(pr.getPercentTax());%></text></text><br>
       <text class="text-2">Total Tax: <text class="text-3"><% out.println(pr.getTotalTax());%></text></text><br>
       <text class="text-2">Total Amount: <text class="text-3"><% 
             int finalPrice = pr.getFinalPrice();
             out.println(finalPrice); 
             netAmount+=finalPrice;                 
          %></text></text><br><br><hr>
       <%}%>
       <text class="text-2">Net Amount: <text class="text-4"><%=netAmount%></text></text><br>
       <%session.setAttribute("amount", netAmount); %>
       <form action="ConformationClass" method="Post">
          <text style="font-size:20px; margin-bottom:10px;">Enter Amount : </text>
          <input type="number" name="paid" required class="text">
          <br>        
          <input type="submit" name="" value="Confirm" class="submit-btn">
       </form>
     </div>
    </div>
  </body>
</html>
