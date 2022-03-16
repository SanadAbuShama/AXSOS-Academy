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
	<div class="container">
		<div class="row mt-5 justify-content-end">
			<div class="col-2">
				<a class="btn btn-sm btn-primary" href="/languages">Dashboard</a>
			</div>

		</div>
		<div class="row my-5  text-start">
			<div class="col-6 offset-3">
				<h6 class="mb-4">
					Name:
					<c:out value="${language.name}" />
				</h6>
				<h6 class="mb-4">
					Creator:
					<c:out value="${language.creator}" />
				</h6>
				<h6 class="mb-4">
					Version:
					<c:out value="${language.version}" />
				</h6>
				<div class="row">
					<div class="col-3">
						<a class="btn btn-sm btn-primary"
							href="/languages/edit/<c:out value="${language.id}" />">Edit</a>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-3">
						<form class="col-6"
							action="/languages/<c:out value="${language.id}"/>" method="post">
							<input type="hidden" name="_method" value="delete">
							<button class="btn btn-sm btn-danger">Delete</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>