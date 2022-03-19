<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Products</title>
</head>
<body>

	<div class="row">
		<div class="col-6 offset-3">

			<div class="row my-5">
				<div class="col-6">
					<h1>All Products</h1>
				</div>
				<div class="col">
					<a class="btn btn-secondary float-end" href="/">Home</a>
				</div>
				<div class="col">
					<a class="btn btn-primary float-end" href="/products/new">New
						Product</a>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<td><a href="/products/<c:out value="${product.id}"/>"><c:out
										value="${product.name}" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>