<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>huj</h1>

<a href="/create">create ninja</a>
<a href="/createdojo/new">create dojo</a>
<h1>list dojo</h1>
<c:forEach items="${allDojos}" var="dojo">
<li><a href="/dojo/${dojo.id}">${dojo.name}</a></li>


</c:forEach>
</body>
</html>