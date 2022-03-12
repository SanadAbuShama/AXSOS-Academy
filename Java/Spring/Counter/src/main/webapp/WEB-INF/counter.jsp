<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>
		You have visited <a target="_blank" href="/">http://localhost:8080/</a>
		<c:out value="${count}" />
		times <a target="_blank" href="/">Take another visit?</a>
	<p>
		<a href="/counter_by_2" target="_blank">Increment by 2</a>
	</p>

	<p>
		<a href="/reset" target="_blank">Reset</a>
	</p>



</body>
</html>