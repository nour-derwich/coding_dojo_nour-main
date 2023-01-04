<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
</head>
<body>
<div class="container">
<h1>Edit Book 📝</h1>
<hr />
   <form:form action="/books/${book.id}" method="post" modelAttribute="book">
     <input type="hidden" name="_method" value="put">
   <div>
         <form:errors path="*" class="text-danger"/>     
   </div>
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="author">Author</form:label>
        <form:input path="author"/>
    </p>

    <p>
        <form:label path="thoughts">thoughts</form:label>
        <form:input  path="thoughts"/>
    </p>    
    <input type="submit" value="Edit" class="btn btn-success"/>
</form:form>  
</div>
</body>
</html>