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
<title>Insert title here</title>
</head>
<body>

	<div class="row my-3">
		<div class="col-4 offset-4">
			<div class="row align-items-center">
				<div class="col">
					<h2 class="text-success">Edit Expense:</h2>
				</div>
				<div class="col">
					<a href="/expenses" class="float-end">Go Back</a>
				</div>
			</div>
			<form:form action="/expenses/edit/${expense.getId()}" method="put"
				modelAttribute="expense">
				<input type="hidden" name="_method" value="put">
				<div class="mb-3">
					<form:label path="name" for="name" class="form-label">Expense name:</form:label>
					<div>
						<form:errors class="text-danger" path="name" />
					</div>
					<form:input path="name" type="text" class="form-control" id="name" />
				</div>
				<div class="mb-3">
					<form:label path="vendor" for="vendor" class="form-label">Vendor:</form:label>
					<div>
						<form:errors class="text-danger" path="vendor" />
					</div>
					<form:input path="vendor" type="text" class="form-control"
						id="vendor" />
				</div>
				<div class="mb-3">
					<form:label path="amount" for="amount" class="form-label">Amount</form:label>
					<div>
						<form:errors class="text-danger" path="amount" />
					</div>
					<form:input path="amount" type="number" min="0"
						class="form-control" id="name" />
				</div>
				<div class="mb-3">
					<form:label for="description" path="description" class="form-label">Description:
					</form:label>
					<div>
						<form:errors class="text-danger" path="description" />
					</div>
					<form:textarea path="description" class="form-control"
						id="exampleFormControlTextarea1" rows="3"></form:textarea>
				</div>
				<button class="btn btn-primary float-end">Submit</button>
			</form:form>

		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>