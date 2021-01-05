<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista almacenes y libros</title>
</head>
<body>
<form action="cargarListado" method="post">
	<input type="submit" value="ver listado">
</form>


<%
List<AlmacenOld> almacenesOld = (List<AlmacenOld>)request.getAttribute("listAllAlmacenesOld");
List<AlmacenNew> almacenesNew = (List<AlmacenNew>)request.getAttribute("listAllAlmacenesNew");
 pageContext.setAttribute("almacenesOld", almacenesOld);
 pageContext.setAttribute("almacenesNew", almacenesNew);
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
			<td>Cod.</td>
			<td>Name</td>
			<td>Borrar</td>
			<td>Añadir Libro</td>
			<td>Libros</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="almacenOld1" items="${listAllAlmacenesOld}">
			<tr>
				<td><c:out value="${almacenOld1.id}"/> </td>
				<td><c:out value="${almacenOld1.nombre}"/> </td>
				<td><a href="/deleteAlmacenOld?id=${almacenOld1.id}">DELETE</a> </td>
				<td><a href="/recoveryAddIdAlmacenOld?id=${almacenOld1.id}">Añadir Libro</a> </td>
	    		<td>
	    			<c:forEach var="libro" items="${almacenOld1.libros}">
	    				<c:out value="${libro.isbn} "/>
	    				<c:out value="${libro.fechaEdicion} "/>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>
		<c:forEach var="almacenNew1" items="${listAllAlmacenesNew}">
			<tr>
				<td><c:out value="${almacenNew1.id}"/> </td>
				<td><c:out value="${almacenNew1.nombre}"/> </td>
				<td><a href="/deleteAlmacenNew?id=${almacenNew1.id}">DELETE</a> </td>
				<td><a href="/recoveryAddIdAlmacenNew?id=${almacenNew1.id}">Añadir Libro</a> </td>
	    		<td>
	    			<c:forEach var="libro" items="${almacenNew1.libros}">
	    				<c:out value="${libro.isbn} "/>
	    				<c:out value="${libro.fechaEdicion} "/>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>
		
	</tbody>
</table>

</body>
</html>