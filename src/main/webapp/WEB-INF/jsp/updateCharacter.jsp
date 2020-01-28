<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<title>Actualizar personaje</title>
</head>
<body>
	<h2>
		<span class="badge badge-warning">Actualizar personaje</span>
	</h2>
	<br />
	<form:form class="col-lg-2 col-md-2 col-2" action="updateCharacter?id=${character.id}" method="post" modelAttribute="character">
		<!-- al llamarlo por post entraremos al servlet por post  -->
		<label>ID: </label> <input type="text" name="id"
			value="${character.id}" disabled="disabled"> <br /> <label>Nombre:
		</label> <input type="text" name="name" value="${character.name}"> <br />
		<label>Portador Anillo:</label><select class="custom-select" name="carrier">
			<option value="SI">SI</option>
			<option value="NO">NO</option>
		</select><br /> <label>Codigo Raza: </label> <input type="text" name="race"
			value="${character.codRace}"> <br /> <input
			class="btn btn-outline-primary" value="Actualizar" type="submit">
	</form:form>
</body>
</html>