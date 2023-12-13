<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start</title>
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown"
				aria-controls="navbarNavDarkDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
				<ul class="navbar-nav">
					<li class="nav-item dropdown">
						<button class="btn btn-dark dropdown-toggle"
							data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown</button>
						<ul class="dropdown-menu dropdown-menu-dark">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<%
		String email = (request.getAttribute("email") + "").equals("null") ? "" : request.getAttribute("email") + "";
		String password = (request.getAttribute("password") + "").equals("null") ? "" : request.getAttribute("password") + "";
		String quantity = (request.getAttribute("quantity") + "").equals("null") ? "" : request.getAttribute("quantity") + "";
		String phone = (request.getAttribute("phone") + "").equals("null") ? "" : request.getAttribute("phone") + "";
	
		String emailErr = (request.getAttribute("emailErr") + "").equals("null") ? "" : request.getAttribute("emailErr") + "";
		String passwordErr = (request.getAttribute("passwordErr") + "").equals("null") ? "" : request.getAttribute("passwordErr") + "";
		String quantityErr = (request.getAttribute("quantityErr") + "").equals("null") ? "" : request.getAttribute("quantityErr") + "";
		String phoneErr = (request.getAttribute("phoneErr") + "").equals("null") ? "" : request.getAttribute("phoneErr") + "";
	%>
	<div class='container mt-5'>
		<form action="dang-nhap" method="post">
			<div class="row">
				<div class="mb-3 col-6">
					<label for="exampleInputEmail1" class="form-label">Email
						address</label> 
					<input class="form-control" name="email" id="exampleInputEmail1" value=<%=email%>>
					<div class="text-danger"><%= emailErr %></div>
				</div>
				<div class="mb-3 col-6">
					<label for="password" class="form-label">Password</label>
					<input id="password" type="password" class="form-control" name="password" value=<%=password%>>
					<div class="text-danger"><%= passwordErr %></div>
				</div>
				<div class="mb-3 col-6">
					<label for="quantity" class="form-label">Số lượng cần mua</label> 
					<input class="form-control" name="quantity" id="quantity" value=<%=quantity%>>
					<div class="text-danger"><%= quantityErr %></div>
				</div>
				<div class="mb-3 col-6">
					<label for="phone" class="form-label">Số điện thoại</label> 
					<input class="form-control" name="phone" id="phone" value=<%=phone%>>
					<div class="text-danger"><%= phoneErr %></div>
				</div>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<div class="mt-3">
			<a href="./error/e404.jsp">Get Link Error</a>
		</div>
	</div>
</body>
</html>