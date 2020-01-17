<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> Bienvenida </title>
	</head>
	<body>
		Bienvenid@
		<b> <%= request.getParameter("name") %> </b>
		<b> <%= request.getParameter("codRace") %> </b>
		<br>
		<a href="index.jsp"> Index </a> <br>
		<a href="Listed.jsp"> Listado</a>
		
	</body>
</html>