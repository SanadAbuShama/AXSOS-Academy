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
	<div class="row mt-5">
		<div class="col-6 offset-3">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Creator</th>
						<th scope="col">Version</th>
						<th scope="col" class="text-center">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="language" items="${languages}">
						<tr>

							<td><a href="/languages/<c:out value="${language.id}"/>"><c:out
										value="${language.name}" /></a></td>
							<td><c:out value="${language.creator}" /></td>
							<td><c:out value="${language.version}" /></td>
							<td>
								<div class="row">
									<a class="btn btn-sm btn-primary col-3 offset-2"
										href="/languages/edit/<c:out value="${language.id}" />">Edit</a>

									<form class="col-6"
										action="/languages/<c:out value="${language.id}"/>"
										method="post">
										<input type="hidden" name="_method" value="delete">
										<button class="btn btn-sm btn-danger">Delete</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row my-3">
		<div class="col-4 offset-4">

			<form:form action="/languages" method="post"
				modelAttribute="language">
				<div class="mb-3">
					<form:label path="name" for="name" class="form-label">Name:</form:label>
					<div>
						<form:errors class="text-danger" path="name" />
					</div>
					<form:input path="name" type="text" class="form-control" id="name" />
				</div>
				<div class="mb-3">
					<form:label path="creator" for="creator" class="form-label">Creator:</form:label>
					<div>
						<form:errors class="text-danger" path="creator" />
					</div>
					<form:input path="creator" type="text" class="form-control"
						id="creator" />
				</div>
				<div class="mb-3">
					<form:label path="version" for="version" class="form-label">Version:</form:label>
					<div>
						<form:errors class="text-danger" path="version" />
					</div>
					<form:input path="version" type="text" min="0" class="form-control"
						id="version" />
				</div>

				<button class="btn btn-primary float-end">Submit</button>
			</form:form>

		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>