<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*, models.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar alumnos</title>
</head>
<body>
	<form action="insertAlumn"  method="post">
	<%
		List<Enterprise> enterprises = (List<Enterprise>)request.getAttribute("listAllEnterprises");
 		pageContext.setAttribute("enterprises", enterprises);
	%>
		<span>Nombre: </span>
		<input type="text" name="name"> <br/>
		
		<span>Edad: </span>
		<input type="text" name="age"> <br/>
		
		<span>¿Va a FCTs? </span>
		<input type="checkbox" name="fct" value="si"> Si
		<input type="checkbox" name="fct" value="no"> No <br/>
		
		<span>Empresa: </span>
		<select>
			<c:forEach var="enterprise" items="${listAllEnterprises}">
				<option value="">${enterprise.name}
			</c:forEach>
		</select> <br>
		
		<input type="submit" value="insertar alumno">
	</form>
</body>
</html>