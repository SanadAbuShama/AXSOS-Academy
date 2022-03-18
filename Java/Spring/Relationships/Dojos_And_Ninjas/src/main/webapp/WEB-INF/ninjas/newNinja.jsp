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
			<div class="row my-5">
				<div class="col">
					<a class="btn btn-primary" href="/dojos">Dashboard</a>
				</div>
			</div>
			<h2 class="my-5">New Ninja</h2>
			<form:form action="/ninjas" method="post" modelAttribute="ninja">
				<div class="mb-3">
					<form:label path="dojo" for="dojo" class="form-label">Select a dojo:</form:label>
					<form:select path="dojo">
						<c:forEach var="dojo" items="${dojos}">

							<form:option value="${dojo.id}">
								<c:out value="${dojo.name}" />
							</form:option>
						</c:forEach>

					</form:select>
				</div>


				<div class="mb-3">
					<form:label path="firstName" for="firstName" class="form-label">First Name:</form:label>
					<div>
						<form:errors class="text-danger" path="firstName" />
					</div>
					<form:input path="firstName" type="text" class="form-control"
						id="firstName" />
				</div>
				<div class="mb-3">
					<form:label path="lastName" for="lastName" class="form-label">Last Name:</form:label>
					<div>
						<form:errors class="text-danger" path="lastName" />
					</div>
					<form:input path="lastName" type="text" class="form-control"
						id="lastName" />
				</div>
				<div class="mb-3">
					<form:label path="age" for="age" class="form-label">Age:</form:label>
					<div>
						<form:errors class="text-danger" path="age" />
					</div>
					<form:input path="age" type="number" class="form-control" id="age" />
				</div>
				<button class="btn btn-primary float-end">Create</button>
			</form:form>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>