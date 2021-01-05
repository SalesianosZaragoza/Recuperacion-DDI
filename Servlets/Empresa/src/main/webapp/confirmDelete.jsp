<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corfirmar el borrado</title>
</head>

<body>

	<form action="deleteEmpresa" method="get">
		<div>¿Quiere borrar tambien los alumnos?</div>
		<input type="submit" name="answer" value="SI" />
		<input type="submit" name="answer" value="NO" />
		<!-- 
		<a href="listado.jsp">NO</a>
		 -->
		<input type="hidden" name="id" value="${id}" />

	</form>

</body>
</html>