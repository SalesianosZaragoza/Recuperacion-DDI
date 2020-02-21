<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">

<title>Race List</title>
</head>
<body>
		<table>
			<thead>
			<tr>
				<th>ID</th>
				<th>Race</th>
				<th>Delete</th>
			</tr>
			</thead>

			<c:forEach items="${listOfRaces}" var="race">
				<tr>
					<td>${race.id}</td>
					<td>${race.specie}</td>
					<td><a href="/deleteRace?id=${race.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	<br />
	<a class="btn btn-secondary" href="index">Index</a>
</body>
</html>