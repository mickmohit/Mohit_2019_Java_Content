<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
   <head>
      <title>Default Landing Page</title>
      <style>
      .mohit{
      		color:Blue;
      		margin: 20px;
  			}
      </style>
      
   </head>
   <body>
      <div class="mohit"><h2>Default Landing Page</h2></div>
       <img src="${pageContext.request.contextPath}/resources/images/SITA.jpg">
      <hr>
      <p>
         Welcome to the landing page! This page is open to the public ... no login required :-)
      </p>
      <hr>
      <p>
         <a href="${pageContext.request.contextPath}/employees">Access Secure Site (requires login)</a>
      </p>
   </body>
</html>