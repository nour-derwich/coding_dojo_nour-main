<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
    <!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
     <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
 <div class="container">

		<!-- REGISTER A NEW USER  -->
		<!-- bring in the newUser empty Object -->
		<div class="login-reg-main border-round give-me-space-up-down">
			<h3>Register:</h3>
			<form:form action="/register" 
			method="post" modelAttribute="newUser">
				<div class="form-group">
					<label>User Name:</label>
					<form:input path="userName" class="form-control" />
					<form:errors path="userName" class="text-danger" />
				</div>
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
				<div class="form-group">
					<label>Confirm Password:</label>
					<form:password path="confirm" class="form-control" />
					<form:errors path="confirm" class="text-danger" />
				</div>
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
		</div>

		<!-- LOGIN -->
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