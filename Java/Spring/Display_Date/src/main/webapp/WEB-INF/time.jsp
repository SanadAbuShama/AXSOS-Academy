<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/timeStyle.css">
<title>Insert title here</title>
</head>
<body>
	<div class="row mt-5">
		<div class="col-6 offset-3 text-center">
			<h1>
				<c:out value="${time}"></c:out>
			</h1>
		</div>
	</div>
	<script type="text/javascript" src="js/time.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>