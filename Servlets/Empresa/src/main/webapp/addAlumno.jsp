
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar nuevo alumno</title>
</head>

<%
 request.getAttribute("empresa");
%>

<body>
	<form action="/addAlumno" method="post">
		<input type="text" name="id" value="<c:out value="${empresa.id}"/>" style="display:none" >
		<span>Nombre:</span><input type="text" name="name">
		<br/>
		<span>Edad :</span><input type="text" name="age">
		<br/>
		<span>¿Asiste a la FCT?</span>
		<input type="submit" name="asisteFCT" value="SI">
		<input type="submit" name="asisteFCT" value="NO">
	</form>
</body>
</html>