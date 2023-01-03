<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add ninjac</title>
</head>
<body>
<form:form action="/createninjas" method="post" modelAttribute="ninja">


<p>
<form:select path="dojo">
    <c:forEach items="${allDojs}" var="dojo">
    <form:option value="${dojo.id }">${dojo.getName()}</form:option>
    </c:forEach>
    </form:select> 
</p>
    <p>
        <form:label path="first_name">First Name</form:label>
        <form:errors path="first_name"/>
        <form:input path="first_name"/>
    </p>
    
    <p>
        <form:label path="last_name">Last Name</form:label>
        <form:errors path="last_name"/>
        <form:input path="last_name"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>     
        <form:input type="number" path="age"/>
    </p> 
   
    <input type="submit" value="Submit"/>

</form:form>
</body>
</html>