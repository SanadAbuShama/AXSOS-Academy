<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/eventDetails.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title><c:out value="${event.name}" /></title>
</head>
<body>
	<div class="container my-5">
		<div class="row">
			<div class="col-8 offset-2">
				<div class="row">
					<div class="col text-end">
						<a href="/events">Back to events</a>
					</div>
				</div>
				<div class="row align-items-top">
					<div class="col-5">
						<div class="row mb-3">
							<div class="col">
								<h2>
									<c:out value="${event.name}" />
								</h2>
							</div>
						</div>
						<p>
							Host:
							<c:out value="${event.creator.firstName}" />
							<c:out value="${event.creator.lastName}" />
						</p>
						<p>
							Date:
							<fmt:formatDate value="${event.date}" type="date" />
						</p>
						<p>
							Location:
							<c:out value="${event.location}" />
							,
							<c:out value="${event.state}" />
						</p>
						<p>
							People who are attending this event:
							<c:out value="${event.attendees.size()}" />
						</p>
						<div class="row">
							<div class="col">

								<table class="table table-bordered text-center">
									<thead>
										<tr>
											<th scope="col">Name</th>
											<th scope="col">Location</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="attendee" items="${event.attendees}">
											<tr>
												<td><c:out value="${attendee.firstName}" /> <c:out
														value="${attendee.lastName}" /></td>
												<td><c:out value="${attendee.location}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col-6 offset-1">
						<div class="row">
							<div class="col">
								<h3>Message Wall</h3>
								<div
									class="comments mb-3 border border-1 border-dark p-3 overflow-y-scroll">
									<c:forEach var="comment" items="${event.comments}">
										<p class="mb-3">
											<c:out value="${comment.commenter.firstName}" />
											says:
											<c:out value="${comment.comment}" />
										</p>
										<p>###########</p>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<form:form action="/events/${event.id}" method="post"
									modelAttribute="newComment">
									<div class="mb-3">
										<form:errors class="text-danger" path="comment" />
										<form:textarea class="form-control" path="comment" rows="3"
											placeholder="Add comment"></form:textarea>
									</div>
									<button class="btn btn-success float-end">Submit</button>
								</form:form>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>