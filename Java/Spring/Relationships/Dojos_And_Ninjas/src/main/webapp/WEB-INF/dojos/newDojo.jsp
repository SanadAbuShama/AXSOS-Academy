<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>

	<div class="row my-5">
		<div class="col-4 offset-4">
			<div class="row my-5">
				<div class="col">
					<a class="btn btn-primary" href="/dojos">Dashboard</a>
				</div>
			</div>
			<h2 class="my-3">New Dojo</h2>
			<form:form action="/dojos" method="post" modelAttribute="dojo">
				<div class="mb-3">
					<form:label path="name" for="name" class="form-label">Name:</form:label>
					<div>
						<form:errors class="text-danger" path="name" />
					</div>
					<form:input path="name" type="text" class="form-control" id="name" />
				</div>
				<button class="btn btn-primary float-end">Create</button>
			</form:form>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>