<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Characters</title>
</head>
<body>
<form method="post" action="/list">
    <input type="submit" value="seeList">
</form>

<table>
<!-- TAGLIB -->
    <thead>
       <th>Name</th>
       <th>Age</th>
       <th>Holder</th>
       <th>Delete</th>
       <th>Update</th>
    </thead>

	<c:forEach items="${listOfCharacters}" var="character">
		<tr>
	        <td>${character.name}</td>
	        <td>${character.age}</td>
	        <td>${character.holder}</td>
	        <td><a href="/delete?name=${character.name}&age=${character.age}&holder=${character.holder}">Delete</a></td>
	        <td><a href="/update?id=${character.update}">Update</a></td>
	    </tr>
	</c:forEach>
	
</table>
</body>
</html>