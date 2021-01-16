<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista warehousees y libros</title>
</head>
<body>
<!-- si pongo /loadList no va -->
<form action="loadList" method="post">
	<input type="submit" value="ver listado">
</form>


<%
List<WarehouseOld> warehousesOld = (List<WarehouseOld>)request.getAttribute("listAllWarehouseOld");
List<WarehouseNew> warehousesNew = (List<WarehouseNew>)request.getAttribute("listAllWarehouseNew");
 pageContext.setAttribute("warehousesOld", warehousesOld);
 pageContext.setAttribute("warehousesNew", warehousesNew);
%>
<br/>
<div>
	<a href="addWarehouseNew.jsp">Quiero añadir un almacen nuevo</a>
</div>
<div>
	<a href="addWarehouseOld.jsp">Quiero añadir un almacen viejo</a>
</div>
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
		<c:forEach var="warehouseOld1" items="${listAllWarehouseOld}">
			<tr>
				<td><c:out value="${warehouseOld1.id}"/> </td>
				<td><c:out value="${warehouseOld1.name}"/> </td>
				<td><a href="/deleteWarehouseOld?id=${warehouseOld1.id}">DELETE</a> </td>
				<td><a href="/recoveryAddIdWarehouseOld?id=${warehouseOld1.id}">Añadir Libro</a> </td>
	    		<td>
	    			<c:forEach var="book" items="${warehouseOld1.books}">
	    				<div>
		    				<c:out value="${book.isbn} "/>
		    				<c:out value="${book.dateEdition} "/>
	    				</div>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>
		<c:forEach var="warehouseNew1" items="${listAllWarehouseNew}">
			<tr>
				<td><c:out value="${warehouseNew1.id}"/> </td>
				<td><c:out value="${warehouseNew1.name}"/> </td>
				<td><a href="/deleteWarehouseNew?id=${warehouseNew1.id}">DELETE</a> </td>
				<td><a href="/recoveryAddIdWarehouseNew?id=${warehouseNew1.id}">Añadir Libro</a> </td>
	    		<td>
	    			<c:forEach var="book" items="${warehouseNew1.books}">
		    			<div>
		    				<c:out value="${book.isbn} "/>
		    				<c:out value="${book.dateEdition} "/>
		    			</div>
	    			</c:forEach>
	    		</td>
	    	</tr>
		</c:forEach>
		
	</tbody>
</table>

</body>
</html>