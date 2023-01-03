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
<h1> ${dojo.name } Ninjas</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${dojo.ninjas}" var="ninja">
    <tr>
      <th scope="row">${ninja.id}</th>
      <td>${ninja.first_name}</td>
      <td>${ninja.last_name}</td>
      <td>${ninja.age}</td>
    </tr>
    </c:forEach>
   
  </tbody>
</table>
</body>
</html>