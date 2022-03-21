<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Login/Register</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-8 offset-2">
				<h1 class="text-primary">
					Welcome,
					<c:out value="${loggedUser.userName}" />
					!
				</h1>
				<h6>This is the dashboard. It is still empty!</h6>
				<a href="/logout">Logout</a>
			</div>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>