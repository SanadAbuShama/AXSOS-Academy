<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Events</title>
</head>
<body>
	<div class="container my-5">
		<div class="row">
			<div class="col-8 offset-2">
				<div class="row align-items-center">
					<div class="col">
						<h4>
							Welcome,
							<c:out value="${loggedUser.firstName}" />
							<c:out value="${loggedUser.lastName}" />
							!
						</h4>
						<p>Events in your state:</p>
					</div>
					<div class="col text-end">
						<div class="row">
							<div class="col">
								<a href="/logout">Logout</a>
							</div>
						</div>
					</div>
				</div>
				<table class="table table-bordered text-center">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Date</th>
							<th scope="col">Location</th>
							<th scope="col">Host</th>
							<th scope="col" class="col-3">Actions/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="event" items="${eventsInState}">
							<tr>
								<td><a href="/events/${event.id}"><c:out
											value="${event.name}" /></a></td>
								<td><fmt:formatDate value="${event.date}" type="date" /></td>
								<td><c:out value="${event.location}" /></td>
								<td><c:out value="${event.creator.firstName}" /></td>
								<td><c:choose>
										<c:when test="${event.creator.id == loggedUser.id}">
											<div class="row">
												<div class="col text-end">
													<a href="/events/${event.id}/edit"
														class="btn btn-sm btn-primary">Edit</a>
												</div>
												<div class="col text-start">
													<form:form action="/events/${event.id}" method="post">
														<input type="hidden" name="_method" value="delete">
														<button type="submit" class="btn btn-sm btn-danger">Delete</button>
													</form:form>
												</div>
											</div>
										</c:when>
										<c:when test="${event.attendees.contains(loggedUser)}">
											<div class="row align-items-center">
												<div class="col text-end">
													<span>Joining!</span>
												</div>
												<div class="col text-start">
													<form:form action="/events/${event.id}/cancel"
														method="post">
														<input type="hidden" name="_method" value="put">
														<button type="submit" class="btn btn-sm btn-warning">Cancel!</button>
													</form:form>
												</div>
											</div>
										</c:when>
										<c:when test="${!event.attendees.contains(loggedUser)}">
											<form:form action="/events/${event.id}/join" method="post">
												<input type="hidden" name="_method" value="put">
												<button type="submit" class="btn btn-sm btn-warning">Join!</button>
											</form:form>

										</c:when>

									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p class="mt-5">Events in other states:</p>
				<table class="table table-bordered text-center">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Date</th>
							<th scope="col">Location</th>
							<th scope="col">State</th>
							<th scope="col">Host</th>
							<th scope="col" class="col-3">Actions/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="event" items="${eventsNotInState}">
							<tr>
								<td><a href="/events/${event.id}"><c:out
											value="${event.name}" /></a></td>
								<td><fmt:formatDate value="${event.date}" type="date" /></td>
								<td><c:out value="${event.location}" /></td>
								<td><c:out value="${event.state}" /></td>
								<td><c:out value="${event.creator.firstName}" /></td>
								<td><c:choose>
										<c:when test="${event.creator.id == loggedUser.id}">
											<div class="row">
												<div class="col text-end">
													<a href="/events/${event.id}/edit"
														class="btn btn-sm btn-primary">Edit</a>
												</div>
												<div class="col text-start">
													<form:form action="/events/${event.id}" method="post">
														<input type="hidden" name="_method" value="delete">
														<button type="submit" class="btn btn-sm btn-danger">Delete</button>
													</form:form>
												</div>
											</div>
										</c:when>
										<c:when test="${event.attendees.contains(loggedUser)}">
											<div class="row align-items-center">
												<div class="col text-end">
													<span>Joining!</span>
												</div>
												<div class="col text-start">
													<form:form action="/events/${event.id}/cancel"
														method="post">
														<input type="hidden" name="_method" value="put">
														<button type="submit" class="btn btn-sm btn-warning">Cancel!</button>
													</form:form>
												</div>
											</div>
										</c:when>
										<c:when test="${!event.attendees.contains(loggedUser)}">
											<form:form action="/events/${event.id}/join" method="post">
												<input type="hidden" name="_method" value="put">
												<button type="submit" class="btn btn-sm btn-warning">Join!</button>
											</form:form>
										</c:when>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row mt-5">
					<div class="col-6">
						<p>Create an event:</p>
						<form:form action="/events" method="post"
							modelAttribute="newEvent">
							<div class="mb-3">
								<form:errors class="text-danger" path="name" />
								<form:input type="text" class="form-control" id="name"
									path="name" placeholder="Name" />
							</div>
							<div class="mb-3">
								<form:errors class="text-danger" path="date" />
								<form:input class="form-control" type="date" id="date"
									path="date" rows="3"></form:input>
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
							<button type="submit" class="btn btn-success float-end ms-2">Submit</button>
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