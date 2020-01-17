<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualiza el personaje</title>
</head>
<body>
<form action="updateCharacter?id=${character.id}" method="post"> 
		<span>ID: </span> <input type="text" name="id" value="${character.id}" disabled="disabled"> <br />
		<span>Nombre: </span> <input type="text" name="name" value="${character.name}"> <br />
		<span>Portador: </span><select name="bearer">
			<option value="SI">SI</option>
			<option value="NO">NO</option>
		</select><br />
		<span>Codigo Raza: </span> <input type="text" name="race" value="${character.codRace}"> <br />
		<input type="submit">
	</form>
</body>
</html>