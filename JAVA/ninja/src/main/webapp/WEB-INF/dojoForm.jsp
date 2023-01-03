<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dojo</title>
</head>
<body>
<form:form action="/createDojo" method="post" modelAttribute="dojo">
    <p>
        <form:label path="name"> Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    
   
   
   
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>