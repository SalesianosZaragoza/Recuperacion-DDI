<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<title>Lista de personajes</title>
</head>
<body>
	<c:if test="${empty listOfCharacters}">
		<strong>La tabla de personajes esta vacia</strong>
		<br />
	</c:if>
	<c:if test="${not empty listOfCharacters}">
		<table class="table table-striped col-lg-6">
			<thead class="thead-dark">
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

					<td><a class="btn btn-outline-danger"
						href="/deleteCharacter?id=${character.id}">Eliminar</a></td>
					<td><a class="btn btn-outline-warning"
						href="/updateCharacter?id=${character.id}">Actualizar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<a class="btn btn-secondary" href="index">Volver al inicio</a>
</body>
</html>