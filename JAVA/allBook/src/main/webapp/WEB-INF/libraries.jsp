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
<h1>Inside ${library.name }</h1>

<c:forEach items="${library.books}" var="book">
<ul>
<li>
<b>${book.title}</b>by${book.author}
</li>
<li>
${lib.name}
</li></ul></c:forEach>
</body>
</html>