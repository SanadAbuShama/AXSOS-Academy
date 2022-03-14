<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/omikujishow.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>

	<div class="container my-5">
		<div class="row">
			<div class="col-4 offset-4">
				<h1>Here's Your Omikuji</h1>

			</div>
		</div>
		<div class="row mt-5">
			<div class="col-6 offset-3" id="message">
				<p class="display-5">
					In
					<c:out value="${years}" />
					years, you will live in
					<c:out value="${city}" />
					with
					<c:out value="${person}" />
					as your roommate,
					<c:out value="${hobby}" />
					for a living. The next time you see a
					<c:out value="${living}" />
					, you will have good luck. Also,
					<c:out value="${nice}" />
				</p>

			</div>
		</div>
		<div class="row">
			<div class="col-4 offset-4 text-center">
				<a href="/omikuji">Go Back</a>
			</div>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>