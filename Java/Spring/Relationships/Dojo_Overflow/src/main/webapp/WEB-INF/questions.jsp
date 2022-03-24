<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>All Questions</title>
</head>
<body>
	<div class="container my-5">
		<div class="row">
			<div class="col-8 offset-2">
				<div class="row my-5 align-items-center">
					<div class="col-8">
						<h1>Questions Dashboard</h1>
					</div>

					<div class="col text-end">
						<a href="/questions/new" class="btn btn-outline-primary">New
							Question</a>
					</div>

				</div>
				<table class="table text-center">
					<thead>
						<tr>
							<th scope="col">Question</th>
							<th scope="col">Tags</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="question" items="${questions}">
							<tr>
								<td><a href="/questions/${question.id}"><c:out
											value="${question.question}" /></a></td>
								<td><c:choose>

										<c:when test="${question.tags.size() == 1}">
											<c:out value="${question.tags[0].subject}" />

										</c:when>
										<c:when test="${question.tags.size() == 2}">
											<c:out value="${question.tags[0].subject}" />,
											<c:out value="${question.tags[1].subject}" />

										</c:when>
										<c:when test="${question.tags.size() == 3}">
											<c:out value="${question.tags[0].subject}" />,
											<c:out value="${question.tags[1].subject}" />,
											<c:out value="${question.tags[2].subject}" />

										</c:when>


									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>