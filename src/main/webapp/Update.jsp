<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> Actualizar Personaje </title>
	</head>
	<body>
		<form action="/update?id=${character.id}" method="post">
	        <span> ID: </span> <input type="text" value="${character.id}" name="id"> <br />
	        <span> Nombre: </span> <input type="text" value="${character.name}" name="name"> <br />
	        <span> Raza: </span> <input type="text" value="${character.codRace}" name="codRace"> <br />
	        <span> Portador: </span> <input type="text" value="${character.bearer}" name="bearer"> <br />
	        <input type="submit">
	    </form>
	</body>
</html>