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
<form:form action="/createbooks" method="post" modelAttribute="book">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    
    <p>
        <form:label path="author">author</form:label>
        <form:errors path="author"/>
        <form:input path="author"/>
    </p>
    <p>
        <form:label path="pages">Pages</form:label>
        <form:errors path="pages"/>     
        <form:input type="number" path="pages"/>
    </p> 
    <form:select path="library">
    <c:forEach items="${allLibs}" var="l">
    <form:option value="${l.id }">${l.getName()}</form:option>
    </c:forEach>
    </form:select>   
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>