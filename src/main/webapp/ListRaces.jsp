<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Race List</title>
</head>
<body>
<form method="post" action="/ListRaces.jsp">
    <input type="submit" value="ShowList">
</form>
<table>

    <thead>
       <th>ID</th>
       <th>Race</th>   
       <th>Delete</th>
    </thead>

	<c:forEach items="${listraces}" var="race">
	    <tr>
			<td>${race.id}</td>
	        <td>${race.specie}</td>
	        <td><a href="/deleteRace?id=${race.id}">Delete</a></td>
	        <td><a href="/updateRace?id=${race.id}">Update</a></td>  
	    </tr>
	</c:forEach>
</table>
</body>
</html>  