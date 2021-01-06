<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="cargarListado" method="post">
	<input type="submit" value="ver listado">
</form>

<% 
 List<UserClassroomDto> users = (List<UserClassroomDto>)request.getAttribute("listAllUsers");
 out.println(users);
 pageContext.setAttribute("users", users);
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
			<td>Curso</td>
			<td>Opciones</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user1" items="${listAllUsers}">
			<tr>
				<td><c:out value="${user1.userName}"/> </td>
				<td><c:out value="${user1.classroomName}"/> </td>
				<td><a href="/edit?id=${user1.userName}">EDITAR</a> </td>
				
	    	</tr>
		</c:forEach>
	</tbody>
</table>

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
		<td>Fecha</td>
		<td>Curso</td>
	</tr>
</thead>
<tbody>
<%

if(null != users && !users.isEmpty()){
	for (UserClassroomDto user2 : users) {
		out.println("<tr>");
		out.println("<td>");
		out.println(user2.getUserName());
		out.println("</td>");
		out.println("<td>");
		out.println(user2.getClassroomName());
		out.println("</td>");
		out.println("</tr>");
	}
		
}
%>
</tbody>
</table>







</body>
</html>