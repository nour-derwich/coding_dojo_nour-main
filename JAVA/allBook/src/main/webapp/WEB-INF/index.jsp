<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hi</h1>
<hr>
<a href="/create">create a book</a>
<c:out value="${allmylove}"/>
<table class="table">
<thead>
<th>ID</th>
<th>Title</th>
<th>Author</th>
<th>Pages</th>
<th>library</th>
<th>Action</th>
</thead>
<tbody>
<c:forEach items="${allmylove}" var="book">
<td>${book.id }</td>
<td>${book.title}</td>
<td>${book.author}</td>
<td>${book.pages}</td>
<td> <a href="/library/${book.library.id }">${book.library.name}</a> </td>
<td>
<a href="/edit/${book.id}" class="btn btn-secondary">edit</a>
<form action="/books/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</td>
</c:forEach>

</tbody>
</table>


</body>
</html>