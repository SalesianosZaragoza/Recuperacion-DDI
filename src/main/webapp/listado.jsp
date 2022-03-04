<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista</title>
</head>
<body>
<h1>Lista de alumnos</h1>
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
			<td>
                <form method="post" action="/delete">
                    <input type="hidden" name="DNI" value="${alumno[2]}">
                    <input type="submit" value="Eliminar">
                </form>
            </td>
		</tr>
	</c:forEach>
</table>
<br />
<br />
<a href="index.jsp">Añadir nuevo alumno</a>
<br />
<br />
<a href="comprobacionForm.jsp">Comprobación de entrada</a>
</body>
</html>