<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insertar empresa</title>
</head>
<body>
<h3>Inserta una empresa</h3>
	<form action="/alumno" method="post">
		<span>Nombre:</span> <input type="text" name="nombre"> <br />
		<span>Edad:</span> <input type="text" name="edad"> <br />
		<span>asiste FCT:</span> <input type="checkbox" name="asiste"> <br />
		<span>Empresa:</span> <input type="text" name="empresa"> <br />
		<input type="submit" value="insertar">
	</form>
	<a href="">Listado</a>
</body>
</html>