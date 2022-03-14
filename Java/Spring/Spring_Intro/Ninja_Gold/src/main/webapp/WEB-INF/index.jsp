<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Ninja Gold</title>
</head>
<body>
	<div class="container">
		<div class="row my-5">
			<div class="col-4">
				Your Gold: <input type="text" value='<c:out value="${gold}"/>' />
			</div>
		</div>
		<div class="row my-5">
			<div class="col mx-2 text-center border border-2 border-dark p-3">
				<div class="row">
					<h2>Farm</h2>
				</div>
				<div class="row my-4">
					<p>(earn 10-20 gold)</p>
				</div>
				<div class="row">
					<div class="col-8 offset-2">
						<form action="/get_gold" method="post">
							<input type="hidden" name="place" value="farm" />
							<button class="bg-light">Find Gold!</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col mx-2 text-center border border-2 border-dark p-3">
				<div class="row">
					<h2>Cave</h2>
				</div>
				<div class="row my-4">
					<p>(earn 5-10 gold)</p>
				</div>
				<div class="col-8 offset-2">
					<form action="/get_gold" method="post">
						<input type="hidden" name="place" value="cave" />
						<button class="bg-light">Find Gold!</button>
					</form>
				</div>
			</div>
			<div class="col mx-2 text-center border border-2 border-dark p-3">
				<div class="row">
					<h2>House</h2>
				</div>
				<div class="row my-4">
					<p>(earn 2-5 gold)</p>
				</div>
				<div class="col-8 offset-2">
					<form action="/get_gold" method="post">
						<input type="hidden" name="place" value="house" />
						<button class="bg-light">Find Gold!</button>
					</form>
				</div>
			</div>
			<div class="col mx-2 text-center border border-2 border-dark p-3">
				<div class="row">
					<h2>Quest</h2>
				</div>
				<div class="row my-4">
					<p>(earns/takes 0-50 gold)</p>
				</div>
				<div class="col-8 offset-2">
					<form action="/get_gold" method="post">
						<input type="hidden" name="place" value="quest" />
						<button class="bg-light">Find Gold!</button>
					</form>
				</div>
			</div>
			<div class="col mx-2 text-center border border-2 border-dark p-3">
				<div class="row">
					<h2>Spa</h2>
				</div>
				<div class="row my-4">
					<p>(loses 5-20 gold)</p>
				</div>
				<div class="col-8 offset-2">
					<form action="/get_gold" method="post">
						<input type="hidden" name="place" value="spa" />
						<button class="bg-light">Go to Spa!</button>
					</form>
				</div>
			</div>
		</div>
		<a href="/destroy" class="btn btn-primary my-2">Reset</a>
		<p>Activities:</p>
		<div class="row">
			<div class="messages border border-1 border-dark">${messages}</div>
		</div>
	</div>


	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>