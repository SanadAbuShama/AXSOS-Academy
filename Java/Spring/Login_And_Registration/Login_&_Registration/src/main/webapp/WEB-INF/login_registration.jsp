<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Login/Register</title>
</head>
<body>
	<div class="container">

		<div class="row my-5">
			<div class="col-8 offset-2">
				<div class="row mb-5">
					<div class="col">
						<h1 class="text-primary">Welcome!</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-5 text-start">
						<h2 class="mb-3">Register</h2>
						<form:form action="/register" method="post"
							modelAttribute="newUser">
							<div class="mb-3">
								<form:errors class="text-danger" path="userName" />
								<form:input type="text" class="form-control" id="userName"
									path="userName" placeholder="Username" />
							</div>

							<div class="mb-3">
								<form:errors class="text-danger" path="email" />
								<form:input type="email" class="form-control" id="email"
									path="email" placeholder="Email" />
							</div>
							<div class="mb-3">
								<form:errors class="text-danger" path="password" />
								<form:input type="password" class="form-control" id="password"
									path="password" placeholder="Password" />
							</div>
							<div class="mb-3">

								<form:errors class="text-danger" path="confirm" />
								<form:input type="password" class="form-control" id="confirm"
									path="confirm" placeholder="Confirm Password" />
							</div>

							<button type="submit" class="btn btn-success float-end">Register</button>
						</form:form>
					</div>
					<div class="col-5 offset-1 text-start">
						<h2 class="mb-3">Login</h2>

						<form:form action="/login" method="post" modelAttribute="newLogin">
							<div class="mb-3">
							<form:errors class="text-danger" path="email" />
								<form:input type="email" class="form-control" id="email_login"
									path="email" placeholder="Email" />
							</div>
							<div class="mb-3">
							<form:errors class="text-danger" path="password" />
								<form:input type="password" class="form-control" id="password"
									path="password" placeholder="Password" />
							</div>
							<button type="submit" class="btn btn-success float-end">Login</button>
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