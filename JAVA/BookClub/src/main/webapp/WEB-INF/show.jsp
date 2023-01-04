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
<h1>${book.title}</h1>
<hr>
 <input type="hidden" name="_method" value="user_id">
<a href="/home">back to the shelves</a>
<br><c:if test="${user_id eq book.user.getId()}">
<p> You <b  class="text-danger">${book.user.getUserName() }</b> read ${book.title} by ${book.author} </p></c:if>
<c:if test="${user_id ne  book.user.getId()}"><p>${book.user.getUserName() } read ${book.title} by ${book.author} </p>
</c:if> <br>
<p>Here are ${book.user.getUserName() }'s thoughts:</p>
<hr>
<p>${book.thoughts}</p>
<hr>
<c:if test="${user_id eq book.user.getId()}">
   	
   	<a href="/edit/${book.id}" class ="btn btn-secondary">Edit</a>
   	<form action="/books/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete" class="btn btn-danger">
    </form>
   	</c:if>
</body>
</html>