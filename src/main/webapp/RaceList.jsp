<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado del razas</title>
</head>
<body>
<form method="post" action="/RaceList.jsp">
    <input type="submit" value="Verlistado">
</form>

<table>
<!-- TAGLIB -->
    <thead>
       <th>Especie</th>
       <th>Eliminar</th>
       <th>Actualizar</th>
    </thead>

	<c:forEach items="${listOfRaces}" var="specie">
	    
	    
	    <tr>
	    	<td>${specie.id}</td>
	        <td>${specie.especie}</td>
	        <td><a href="/delete?specie=${especie.especie}">Eliminar</a></td>
	        <td><a href="/update?id=${character.id}">Update</a></td>
	        
	    </tr>
	</c:forEach>
</table>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
</body>
</html>