<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> Listado General </title>
	</head>
	<body>
		<form method="post" action="/listed">
		    <input type="submit" value="Verlistado"> <!-- VERLISTADO -->
			<table>
			    <!--<thead>
			       <th> Nombre </th>
			       <th> IdRaza </th>
			       <th> Especie </th>
			       <th> Portador </th>
			       <th> Eliminar </th>
			       <th> Actualizar </th>
			    </thead>
  -->
				<c:forEach items="${listOfUsers}" var="user">
				    <tr>
				        <td> ${user.name} </td>
				        <td> ${user.codRace} </td>
				        <td> ${user.species} </td>
				        <td> ${user.bearer} </td>
				        <td> <a href="/delete?consulta1=${user.id}"> Eliminar </a> </td> <!-- deletec consulta 1 -->
				        <td> <a href="/update?id=${user.id}"> Actualizar </a> </td>
				    </tr>
				</c:forEach>
			</table>
		
			<br/>
			<br/>
			<br/>
			
			<table>
			    <thead>
			    	<th> IdRaza </th>
			    	<th> Especie </th>
			    </thead>
			
				<c:forEach items="${listOfRaces}" var="races"> <!-- CAMBIO -->
				    <tr>
				    	<td> ${races.id} </td>
				        <td> ${races.species} </td>
				        <td> <a href="/delete?consulta2=${races.id}"> Eliminar </a> </td> <!-- delete consulta 2 -->
				    </tr>
				</c:forEach>
			</table>
			<br/>
			<a href="index.jsp"> Ir a index</a>
			<br/>
			<br/>
		</form>
	</body>
</html>