<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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
					<input class="btn btn-outline-danger btn-sm" type="submit" value="Eliminar">
                </form>
            </td>
		</tr>
	</c:forEach>
</table>
<br />
<br />
<a type="button" class="btn btn-outline-info" href="index.jsp">Nuevo alumno</a>
<a type="button" class="btn btn-outline-success" href="comprobacionForm.jsp">Comprobar entrada</a>
</body>
</html>