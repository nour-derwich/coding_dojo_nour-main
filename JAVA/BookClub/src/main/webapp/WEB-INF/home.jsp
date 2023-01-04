<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
 <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ${userName}</h1><br />
<HR>
<p>Books from everyone's ahelves:</p>

   <a href="/create">Add a to my shelf!</a><br />
   <a href="logout">logout</a>
   <hr>
    <table class="table">
   	<thead>
   	<th>ID</th>
   	<th>Title</th>
   	<th>Author Name</th>
   	<th>Posted By</th>
   
  
   	</thead>
   	<tbody>
   <c:forEach items="${allMybooks }" var="book">
   	<tr>
   	<td>${book.id }</td>
   	<td><a href="/show/${book.id}">${book.title }</a></td>
   	<td>${book.thoughts }</td> 
 	<td>${book.user.getUserName() }</td>
  

   	</tr>
 </c:forEach>
   	</tbody>
   </table> 
   
</body>
</html>