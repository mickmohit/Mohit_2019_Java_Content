<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html> 
<body>
<head><title>Student Registration Form</title></head>
<form:form action="processForm" modelAttribute="student">

First Name <form:input path="firstName"/>
<br>
Last Name <form:input path="lastName"/>
<br>
Country:
<form:select path="country">
	<form:option value="IR" label="Ireland"/>
		<form:option value="FR" label="France"/>
			
			<!-- by using below student model reference you will load data from java class -->
			<%-- <form:options  items="${student.countryOptions}"/> --%>
			
			<form:options  items="${countryOptions}"/> 
			
</form:select>
<br>

Favorite Language
Java<form:radiobutton path="favoriteLanguage" value="Java"/>
C#<form:radiobutton path="favoriteLanguage" value="C#"/>
Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
Python<form:radiobutton path="favoriteLanguage" value="Python"/>

<br>

Operating Systems
Linux<form:checkbox path="operatingSystem" value="Linux"/>
Microsoft<form:checkbox path="operatingSystem" value="Microsoft"/>
Mac <form:checkbox path="operatingSystem" value="Mac"/>
<br>
<input type="submit" value="submit"/>
</form:form>

</body>

</html>