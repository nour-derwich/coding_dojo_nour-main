<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    <!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Create 📖</h1>
<hr />
<p>User ID = ${user_id }</p>
   <form:form action="/createBook" method="post" modelAttribute="book">
   <div>
         <form:errors path="*" style="color:red"/>     
   </div>
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
    </p>
  <p>
  <form:label path="title">Author</form:label>
  <form:input  path="author" />
  </p> 

    <p>
        <form:label path="thoughts">My thoughts</form:label>
        <form:input  path="thoughts"/>
    </p>    
    
  
    <input type="submit" value="Create" class="btn btn-success"/>
</form:form>    
</div>
</body>
</html>