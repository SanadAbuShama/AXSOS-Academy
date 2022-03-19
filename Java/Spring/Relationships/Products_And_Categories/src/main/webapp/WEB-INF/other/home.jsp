<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Welcome</title>
</head>
<body>

	<div class="container">
		<div class="row text-center my-5">
			<div class="col-3 offset-3">
				<a class="btn btn-success" href="/categories">Categories</a>
			</div>
			<div class="col-3">
				<a class="btn btn-warning" href="/products">Products</a>
			</div>
		</div>
	</div>


	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>