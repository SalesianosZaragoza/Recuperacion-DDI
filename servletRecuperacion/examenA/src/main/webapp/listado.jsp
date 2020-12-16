<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="edit" method="post">
	<input type="submit" value="ver listado">
</form>

<table border="1">
	<thead>
		<tr>
			<td>Empresa</td>
			<td>Nombre Alumno</td>
			<td>Edad</td>
			<td>Asiste FCT</td>
			<td>Opciones</td>
		</tr>
	</thead>
		<c:forEach var="dto" items="${listDto}">
			<tr>
				<td><c:out value="${dto.empresa}"/> </td>
				<td><c:out value="${dto.nombre}"/> </td>
				<td><c:out value="${dto.edad}"/> </td>	
				<td><c:out value="${dto.asisteFCT}"/> </td>	
				<td><a href="/edit?id=${dto.nombre}">Editar</a> </td>		
	    	</tr>
		</c:forEach>
	</tbody>
</table>



</body>
</html>