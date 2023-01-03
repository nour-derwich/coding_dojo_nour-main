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
<h1>create Library</h1>
<hr>
<form:form action="/createLibrary" method="post" modelAttribute="library">
<form:label path="name">name</form:label>
<form:input path="name"/>
<form:errors path="name"/>

<br>
<form:label path="location">location</form:label>
<form:input path="location"/>
<form:errors path="location"/>

  <input type="submit" value="Create library"/>


</form:form>
</body>
</html>