<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de personajes</title>
</head>
<body>
	<table>
		<thead>
			<th>ID</th>
			<th>Nombre</th>
			<th>Portador</th>
			<th>Cod. Raza</th>
			<th>Eliminar</th>
			<th>Actualizar</th>
		</thead>

		<c:forEach items="${listOfCharacters}" var="character">
			<tr>
				<td>${character.id}</td>
				<td>${character.name}</td>
				<td>${character.carrier}</td>
				<td>${character.codRace}</td>

				<td><a href="/deleteCharacter?id=${character.id}">Eliminar</a></td>
				<td><a href="/updateCharacter?id=${character.id}">Actualizar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="index.jsp">Volver al inicio</a>
</body>
</html>