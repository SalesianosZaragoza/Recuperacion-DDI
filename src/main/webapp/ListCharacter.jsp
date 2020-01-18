<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Character List</title>
</head>
<body>
<form method="post" action="ListCharacter">
    <input type="submit" value="ShowList">
</form>
<table>

    <thead>
       <th>ID</th>
       <th>Name</th>
       <th>RingBearer</th>
       <th>Race Code</th>  
       <th>Delete</th>
       <th>Update</th>
    </thead>

	<c:forEach items="${listcharacter}" var="character">
	    <tr>
			<td>${character.id}</td>
	        <td>${character.name}</td>
	        <td>${character.ringBearer}</td>
	        <td>${character.raceName}</td>
	        <td><a href="/deleteCharacter?id=${character.id}">Delete</a></td>
	        <td><a href="/updateCharacter?id=${character.id}">Update</a></td>   
	    </tr>
	</c:forEach>
</table>
</body>
</html>  