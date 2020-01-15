<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personaje insertado</title>
</head>
<body>
	<h2>Personaje insertado</h2>
	<span>Nombre:</span>
	<b><%=request.getParameter("name")%></b>
	<span>Portador:</span>
	<b><%=request.getParameter("holder")%></b>
	<span>Cod.Raza:</span>
	<b><%=request.getParameter("race")%></b>
	<a href="listCharacters">Ver listado de personajes</a>
</body>
</html>