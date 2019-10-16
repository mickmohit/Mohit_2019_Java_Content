<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<html>
<head>
<title>Customer Registration Form</title>

<style>
.error{color:red}
</style>

</head>

<body>

Full out the form, * Astrick is required field

<form:form action="processForm" modelAttribute="customer">

First Name:
<form:input path="firstName"/>
<br>
Last Name(*):
<form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br>

Free Passes:
<form:input path="freePasses"/>
<form:errors path="freePasses" cssClass="error"/>

<br>

Postal Code:
<form:input path="postalCode"/>
<form:errors path="postalCode" cssClass="error"/>

<br>


Course Code:
<form:input path="mohitCourseCode"/>
<form:errors path="mohitCourseCode" cssClass="error"/>

<br>

<input type="submit" value="submit">
</form:form>

</body>

</html>