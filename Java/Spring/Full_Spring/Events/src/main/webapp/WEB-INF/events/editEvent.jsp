
<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Edit Project</title>
</head>
<body>
	<div class="container">
		<div class="row my-5">
			<div class="col-6 offset-3">
				<div class="row mb-5">
					<div class="col">
						<h3>
							<c:out value="${event.name}" />
						</h3>
					</div>
					<div class="col text-end">
						<a href="/events">Back to events</a>
					</div>
				</div>
				<div class="row">
					<div class="col-6 text-start">
						<h6 class="mb-3">Edit Event</h6>
						<form:form action="/events/${event.id}" method="post"
							modelAttribute="event">
							<input type="hidden" name="_method" value="put">
							<div class="mb-3">
								<form:errors class="text-danger" path="name" />
								<form:input type="text" class="form-control" id="name"
									path="name" placeholder="Name" />
							</div>
							<div class="mb-3">
								<form:errors class="text-danger" path="date" />
								<form:input class="form-control" type="date" id="date"
									path="date" rows="3" />
							</div>
							<div class="row">
								<form:errors class="text-danger" path="location" />
								<div class="col">
									<div class="mb-3">
										<form:input class="form-control" id="location" path="location"
											placeholder="Location" rows="3" />
									</div>
								</div>
								<div class="col">
									<div class="mb-3">
										<form:errors class="text-danger" path="state" />
										<form:select class="form-select"
											aria-label="Default select example" path="state">
											<option value="CA">CA</option>
											<option value="TX">TX</option>
											<option value="PA">PA</option>
											<option value="IL">IL</option>
											<option value="OH">OH</option>
										</form:select>
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-success float-end ms-2">Edit</button>
						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>