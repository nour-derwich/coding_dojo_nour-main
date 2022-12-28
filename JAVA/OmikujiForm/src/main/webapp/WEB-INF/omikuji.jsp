<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<form method="post" action="/omikuji/process">
 <div class="mb-3">
<label for="number">Pick any number from 5 to 25</label>
 <input type="number"  class="form-control"  name="number"></div>
  <div class="mb-3">
 <label for="city">Enter the name of any city:</label>
  <input type="text"  class="form-control"  name="city"></div>
   <div class="mb-3">
  <label for="name">Enter the name of any real person:</label>
  <input type="text"  class="form-control"  name="name"></div>
   <div class="mb-3">
  <label for="hobby">Enter professional endeavor or hobby:</label>
  <input type="text"  class="form-control"   name="hobby"></div>
   <div class="mb-3">
  <label for="type">Enter any type of living thing:</label><br>
  <input type="text"  class="form-control"  name="type"></div>
   <div class="mb-3">
  <label for="something">Say something nice to someone</label>
  <textarea rows="5"  class="form-control"  cols="" name="something "></textarea></div>
  <p class="form-text">Send and show a friend</p>
  <input type="submit" value="Submit">
</form> </div>
</body>
</html>