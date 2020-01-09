<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de razas</title>
</head>
<body>
<table>
    <thead>
       <th>ID</th>
       <th>Raza</th>   
       <th>Eliminar</th>
    </thead>
    
	<c:forEach items="${listOfRaces}" var="race">
	    <tr>
			<td>${race.id}</td>
	        <td>${race.specie}</td>
	        <td><a href="/deleteRace?id=${race.id}">Eliminar</a></td> 
	    </tr>
	</c:forEach>
</table>
<br/>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>