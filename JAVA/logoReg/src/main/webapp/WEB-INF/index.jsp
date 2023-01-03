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
<div class="contatainer">
<h3>Register:</h3>
<form:form action="/register" method="post" modelAttribute="newUser">
<div class="mb-3">
   <form:label path="userName">UserName</form:label>
   <form:errors  path="userName" />
   <form:input path="userName"/>
  </div>
  <div class="mb-3">
   <form:label path="email">Email</form:label>
   <form:errors  path="email" />
   <form:input path="email" type="email"/>
  </div>
<div class="mb-3">
   <form:label path="password">password</form:label>
   <form:errors  path="password" />
   <form:input path="password" type="password"/>
  </div>
  <div class="mb-3">
   <form:label path="confirm">confirm Password</form:label>
   <form:errors  path="confirm" />
   <form:input path="confirm" type="password"/>
  </div>
  <input type="submit" />
</form:form>
</div>
<br>
<div>
<!-- newLogin object will touch the model to validate only -->
		<div class="login-reg-main border-round">
			<h3>Login:</h3>
			<form:form action="/login" method="post" 
			modelAttribute="newLogin">
				<div class="form-group">
					<label>Email:</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Password:</label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<input type="submit" value="Login" class="btn btn-success" />
			</form:form>
		</div>

</div>
</body>
</html>