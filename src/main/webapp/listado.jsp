<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Lista de alumnos</h1>
<a href="index.jsp">Volver a añadir alumno</a>
<table>
	<tr>
		<td>
			Nombre
		</td>
		<td>
			Apellido
		</td>
		<td>
			DNI
		</td>
		<td>
			Hora de entrada
		</td>
		<td>
			Hora de salida
		</td>
	</tr>
	<c:forEach items="${alumnos}" var="alumno">
		<tr>
			<td>
				${alumno[0]}
			</td>
			<td>
				${alumno[1]}
			</td>
			<td>
				${alumno[2]}
			</td>
			<td>
				${alumno[3]}
			</td>
			<td>
				${alumno[4]}
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>