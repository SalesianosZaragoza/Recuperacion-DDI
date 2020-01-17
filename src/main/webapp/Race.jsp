<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> la raza </title>
	</head>
	<body>
		<form action="/race" method="post"> <!-- ACTION= /RAZA -->
			<span> Especie: </span> <input type="text" name="race"> <br />
			<input type="submit">
		</form>
		<a href="Listed.jsp"> Listado </a> <br />
		<a href="index.jsp"> Crear Personaje </a>
	</body>
</html>