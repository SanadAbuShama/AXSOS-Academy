<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row mt-5">
			<div class="col-4 offset-4">
				<h1>Send an Omikuji</h1>
			</div>
		</div>
		<div class="row my-5">
			<div class="col-4 offset-4 border border-2 border-dark p-3">
				<form action="/submit" method="post">
					<div class="mb-3">
						<p class="mb-0">
							<label for="number" class="form-label">Pick a number from
								5 to 25:</label>
						</p>
						<input type="number" name="number" id="number" min="5" max="25" />
					</div>
					<div class="mb-3">
						<p>
							<label for="city" class="form-label">Enter the name of
								any city:</label>
						</p>
						<input type="text" name="city" class="form-control" id="city">
					</div>
					<div class="mb-3">
						<p>
							<label for="person" class="form-label">Enter the name of
								any real person:</label>
						</p>
						<input type="text" name="person" class="form-control" id="person">
					</div>
					<div class="mb-3">
						<p>
							<label for="hobby" class="form-label">Enter professional
								endeavor or hobby:</label>
						</p>
						<input type="text" name="hobby" class="form-control" id="hobby">
					</div>
					<div class="mb-3">
						<p>
							<label for="living" class="form-label">Enter any type of
								living thing:</label>
						</p>
						<input type="text" name="living" class="form-control" id="living">
					</div>
					<div class="mb-3">
						<label for="nice" class="form-label">Say something nice to
							someone:</label>
						<textarea class="form-control" id="nice" name="nice" rows="3"></textarea>
					</div>
					<p class="mb-0">Send and show a friend:</p>
					<button class="btn btn-primary float-end">Send</button>
				</form>
			</div>
		</div>

	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>