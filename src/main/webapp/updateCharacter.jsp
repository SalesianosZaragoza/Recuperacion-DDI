<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar personaje</title>
</head>
<body>
<form action="updateCharacter?id=${character.id}" method="post"> <!-- al llamarlo por post entraremos al servlet por post  -->
		<span>ID: </span> <input type="text" name="id" value="${character.id}" disabled="disabled"> <br />
		<span>Nombre: </span> <input type="text" name="name" value="${character.name}"> <br />
		<span>Portador Anillo: </span><select name="carrier">
			<option value="SI">SI</option>
			<option value="NO">NO</option>
		</select><br />
		<span>Codigo Raza: </span> <input type="text" name="race" value="${character.codRace}"> <br />
		<input type="submit">
	</form>
</body>
</html>