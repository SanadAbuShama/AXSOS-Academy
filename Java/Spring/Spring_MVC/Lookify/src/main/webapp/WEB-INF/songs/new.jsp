<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Song</title>
</head>
<body>
	<div class="row my-5">
		<div class="col-10 offset-1">
			<a class="float-end btn btn-primary" href="/dashboard">Dashboard</a>
		</div>
	</div>
	<div class="row my-3">
		<div class="col-4 offset-4">
			<form:form action="/songs" method="post" modelAttribute="song">
				<div class="mb-3">
					<form:label path="title" for="title" class="form-label">Title:</form:label>
					<div>
						<form:errors class="text-danger" path="title" />
					</div>
					<form:input path="title" type="text" class="form-control"
						id="title" />
				</div>
				<div class="mb-3">
					<form:label path="artist" for="artist" class="form-label">Artist:</form:label>
					<div>
						<form:errors class="text-danger" path="artist" />
					</div>
					<form:input path="artist" type="text" class="form-control"
						id="artist" />
				</div>
				<div class="mb-3">
					<form:label path="rating" for="rating" class="form-label">Rating:</form:label>
					<div>
						<form:errors class="text-danger" path="rating" />
					</div>
					<form:input path="rating" type="number" min="1" max="10"
						class="form-control" id="rating" />
				</div>

				<button class="btn btn-primary float-end">Add Song</button>
			</form:form>

		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>