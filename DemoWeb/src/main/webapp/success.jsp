<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>Successful!</h1>
	<%
		String email = (request.getAttribute("email") + "").equals("null") ? "" : request.getAttribute("email") + "";
		String password = (request.getAttribute("password") + "").equals("null") ? "" : request.getAttribute("password") + "";
		String quantity = (request.getAttribute("quantity") + "").equals("null") ? "" : request.getAttribute("quantity") + "";
		String phone = (request.getAttribute("phone") + "").equals("null") ? "" : request.getAttribute("phone") + "";
	%>
	<h3>Your email is: <%= email %></h3>
	<p>Your quantity is: <%= quantity %></p>
	<p>We will call your number within 1 day: <%= phone %></p>
	<img alt="success" src="./img/one-piece.jpg" class="w-100"/>
</body>
</html>