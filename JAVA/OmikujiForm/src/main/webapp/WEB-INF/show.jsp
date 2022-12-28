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
<div style="background-color: blue; width:400px;height:400px ; color:Cornsilk">
 In <c:out value="${number}" />years, you will live in <c:out value="${city}" /> 
 with <c:out value="${name}" />as your roommate,<c:out value="${hobby}" /> 
 for a living.The next time you see a <c:out value="${type}" />
 ,you will have good luck Also,<c:out value="${something}" />
</div>

<a href="/omikuji">Go back</a>
</body>
</html>