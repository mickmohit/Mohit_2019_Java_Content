<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
<title> Welcome to the Home Page
</title>
</head>

<body>

Good Job man!


<!-- Access Roles -->
<security:authorize access="isAuthenticated()">
User: <security:authentication property="principal.username"/>
<br></br>
Role: <security:authentication property="principal.authorities"/>
</security:authorize>

<p>
<security:authorize access="hasRole('MANAGER')">
<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
</security:authorize>
</p>
<p>
<security:authorize access="hasRole('ADMIN')">
<a href="${pageContext.request.contextPath}/admin">Admin Meeting</a>
</security:authorize>
</p>


<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout"/>
</form:form>
</body>
</html>