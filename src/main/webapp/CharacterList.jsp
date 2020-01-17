<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado del personajes</title>
</head>
<body>
<form method="post" action="/CharacterList">
    <input type="submit" value="Verlistado">
</form>

<table>
<!-- TAGLIB -->
    <thead>
       <th>Nombre</th>
       <th>Portador</th>
       <th>Portador</th>
       <th>Eliminar</th>
       <th>Actualizar</th>
    </thead>

	<c:forEach items="${listOfCharacters}" var="character">
	    
	    
	    <tr>
	    	<td>${character.id}</td>
	        <td>${character.nombre}</td>
	        <td>${character.portador}</td>
	        <td>${character.codraza}</td>
	        <td><a href="/delete?characterName=${character.nombre}&bearer=${character.portador}">Eliminar</a></td>
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