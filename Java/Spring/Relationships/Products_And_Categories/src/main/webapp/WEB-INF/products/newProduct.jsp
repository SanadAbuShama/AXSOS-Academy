<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Product</title>
</head>
<body>
	<div class="row my-3">
		<div class="col-4 offset-4">
			<div class="row my-5 align-items-center">
				<div class="col">
					<h2 class="my-3">New Product</h2>
				</div>
				<div class="col">
					<a class="btn btn-secondary float-end" href="/">Home</a>
				</div>
			</div>
			<form:form action="/products" method="post" modelAttribute="product">
				<div class="mb-3">
					<form:label path="name" for="name" class="form-label">Name:</form:label>
					<div>
						<form:errors class="text-danger" path="name" />
					</div>
					<form:input path="name" type="text" class="form-control" id="name" />
				</div>
				<div class="mb-3">
					<form:label path="description" for="description" class="form-label">Description:</form:label>
					<div>
						<form:errors class="text-danger" path="description" />
					</div>
					<form:input path="description" type="text" class="form-control"
						id="description" />
				</div>
				<div class="mb-3">
					<form:label path="price" for="price" class="form-label">Price:</form:label>
					<div>
						<form:errors class="text-danger" path="price" />
					</div>
					<form:input path="price" type="number" class="form-control"
						id="price" />
				</div>
				<button class="btn btn-primary float-end">Create Product</button>
			</form:form>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>