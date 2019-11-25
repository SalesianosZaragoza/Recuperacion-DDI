<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado del usuarios</title>
</head>
<body>
<form method="post" action="/listado">
    <input type="submit" value="Verlistado">
</form>

<table>
<!-- TAGLIB -->
    <thead>
       <th>Nombre</th>
       <th>Apellido</th>
       <th>Eliminar</th>
       <th>Actualizar</th>
    </thead>

	<c:forEach items="${listOfUsers}" var="user">
	    
	    
	    <tr>
	        <td>${user.nombre}</td>
	        <td>${user.apellido}</td>
	        <td><a href="/delete?name=${user.nombre}&surname=${user.apellido}">Eliminar</a></td>
	        <td><a href="/update?id=${user.id}">Update</a></td>
	        
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
<table>
<%
//scriplet
 List<User> users = (List<User>)request.getAttribute("listOfUsers");
if(users!= null && !users.isEmpty()){
	for(User user : users){
	    out.println("<tr>");
	    out.println("<td>");
	    out.println(user.getNombre());
	    out.println("</td>");
	    out.println("<td>");
        out.println(user.getApellido());
        out.println("</td>");
	    out.println("</tr>");
		
	}
}

%>
</table>







</body>
</html>