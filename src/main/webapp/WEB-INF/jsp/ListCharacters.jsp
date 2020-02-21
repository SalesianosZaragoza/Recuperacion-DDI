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

<title>Character List</title>
</head>
<body>
		<table>
			<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<th>Ring Bearer</th>
				<th>Race code</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
			</thead>

			<c:forEach items="${listOfCharacters}" var="character">
				<tr>
					<td>${character.id}</td>
					<td>${character.name}</td>
					<td>${character.ringBearer}</td>
					<td>${character.codRace}</td>

					<td><a href="/deleteCharacter?id=${character.id}">Delete</a></td>
					<td><a href="/updateCharacter?id=${character.id}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
	<br />
	<a href="index">Index</a>
</body>
</html>