<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,models.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="alumnList" method="post">
	<input type="submit" value="ver listado">
</form>

<% 
 List<Alumn> alumns = (List<Alumn>)request.getAttribute("listAllAlumns");
 out.println(alumns);
 pageContext.setAttribute("alumns", alumns);
%>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<table border="1">
	<thead>
		<tr>
			<td>Nombre</td>
			<td>Edad</td>
			<td>Va a fct?</td>
			<td>empresa</td>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="alumn" items="${listAllAlumns}">
			<tr>
				<td><c:out value="${alumn.userName}"/> </td>
				<td><c:out value="${alumn.classroomName}"/> </td>
				<td><c:out value="${alumn.asistFct}"/> </td>
				<td><c:out value="${alumn.enterprise}"/> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>