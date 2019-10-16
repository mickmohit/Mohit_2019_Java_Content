<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Customer Confimration Page</title>
</head>


<body>
Customer is confirmed : 
${customer.firstName} ${customer.lastName} <br>
Free Passes: ${customer.freePasses}  <br>
Postal Code: ${customer.postalCode}  <br>
Course Code: ${customer.mohitCourseCode}
</body>

</html>