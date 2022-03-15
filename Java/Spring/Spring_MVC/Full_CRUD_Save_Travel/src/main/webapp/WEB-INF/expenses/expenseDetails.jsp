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

		<div class="row my-5  text-start">
			<div class="col-6 offset-3">
				<div class="row align-items-center">
					<div class="col">
						<h2 class="text-primary mb-4">Expense Details</h2>
					</div>
					<div class="col">
						<a class="float-end" href="/expenses">Go Back</a>
					</div>
				</div>
				<h6 class="mb-4">
					Expense name:
					<c:out value="${expense.getName()}" />
				</h6>
				<h6 class="mb-4">
					Expense description:
					<c:out value="${expense.getDescription()}" />
				</h6>
				<h6 class="mb-4">
					Vendor:
					<c:out value="${expense.getVendor()}" />
				</h6>
				<h6 class="mb-4">
					Amount spent: $
					<c:out value="${expense.getAmount()}" />
				</h6>
			</div>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>