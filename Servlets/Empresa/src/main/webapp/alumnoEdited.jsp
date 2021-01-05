<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alumno editado</title>
</head>
<body>
<%
 request.getAttribute("alumno");
%>
	<form action="/updateAlumno" method="post">
		
		<span>nombre:</span> 
		<c:out value="${alumno.nombre}"/>" > <br/>
		<span>¿Asiste a la FCT?</span>
		<input type="submit" name="asisteFCT" value="SI">
		<input type="submit" name="asisteFCT" value="NO">
		
	</form>
</body>
</html>