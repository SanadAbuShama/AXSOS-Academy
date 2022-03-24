<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title><c:out value="${question.question}" /></title>
</head>
<body>
	<div class="container my-5">
		<div class="row">
			<div class="col-8 offset-2"></div>
			<div class="row">
				<div class="col">
					<h2>
						<c:out value="${question.question}" />
					</h2>

				</div>
				<div class="col text-end">

					<a href="/questions" class="btn btn-outline-primary">Back</a>
				</div>
			</div>
			<div class="row my-3">
				<div class="col">
					Tags:
					<c:forEach var="tag" items="${question.tags}">
						<span class="btn btn-sm btn-primary"><c:out
								value="${tag.subject}" /></span>
					</c:forEach>
				</div>
			</div>
			<div class="row my-5">
				<div class="col-6">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Answers</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="answer" items="${question.answers}">
								<tr>
									<td><c:out value="${answer.answer}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-5 offset-1">
					<form:form action="/questions/${question.id}" method="post"
						modelAttribute="newAnswer">
						<div class="mb-3">
							<form:errors class="text-danger" path="answer" />
							<form:textarea class="form-control" id="answer" path="answer"
								placeholder="Add Your Answer" rows="3"></form:textarea>
						</div>
						<button type="submit" class="btn btn-success float-end ms-2">Answer!</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>