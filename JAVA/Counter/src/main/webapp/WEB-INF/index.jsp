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
<p>
 You have visited <a href="">http://your_server</a><c:out value="${counter.count}" />  
   <a href="/counter">Test another visit?</a>
  <a href="/incrementByTwo">Increment by 2</a> 
  <a href="/reset">Reset</a>
</body>
</html>