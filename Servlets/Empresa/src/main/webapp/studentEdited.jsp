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
 request.getAttribute("student");
%>
	<form action="updateStudent" method="post">		
		<input type="text" name="id" value="<c:out value="${student.id}"/>" style="display:none">
		<span>nombre:</span> 
		<c:out value="${student.name}"/> <br/>
		<span>¿Asiste a la FCT?</span>
		<input type="submit" name="asisteFCT" value="SI">
		<input type="submit" name="asisteFCT" value="NO">
		
	</form>
</body>
</html>