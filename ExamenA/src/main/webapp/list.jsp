<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,com.mycompany.model.*" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>
<form action="edit" method="post">
	<input type="submit" value="ver listado">
</form>

<table border="1">
	<thead>
		<tr>
			<td>Company</td>
			<td>Name student</td>
			<td>Age</td>
			<td>Asists FCT</td>
			<td>Options</td>
		</tr>
	</thead>
		<c:forEach var="fct" items="${listFct}">
			<tr>
				<td><c:out value="${fct.company}"/> </td>
				<td><c:out value="${fct.name_student}"/> </td>
				<td><c:out value="${fct.age}"/> </td>	
				<td><c:out value="${fct.FCTasists}"/> </td>	
				<td><a href="/edit?id=${fct.name}">Edit</a> </td>		
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>