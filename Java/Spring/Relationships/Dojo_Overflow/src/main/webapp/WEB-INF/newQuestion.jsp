<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Ask a question</title>
</head>
<body>
	<div class="container">

		<div class="row my-5">
			<div class="col-6 offset-3">
				<div class="row mb-5">
					<div class="col-8">
						<h3>What is your question?</h3>
					</div>
					<div class="col text-end">
						<a href="/questions" class="btn btn-outline-primary">Back</a>
					</div>
				</div>
				<div class="row">
					<div class="col text-start">

						<form:form action="/questions" method="post"
							modelAttribute="newQuestion">
							<div class="mb-3">
								<form:errors class="text-danger" path="question" />
								<form:textarea class="form-control" id="question"
									path="question" placeholder="Your Question" rows="3"></form:textarea>
							</div>
							<div class="mb-3">
								<input class="form-control" id="tags" name="questionTags"
									placeholder="Tags" />
							</div>
							<button type="submit" class="btn btn-success float-end ms-2">Submit</button>
							<a href="/questions" class="btn btn-danger float-end">Cancel</a>
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