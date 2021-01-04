<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Warehouse" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Listado de Almacenes</title>
<style>
	table, th, td {
	  border: 1px solid black;
	}
	
	table {
	  border-collapse: collapse;
	}
</style>
</head>
<body>
	<div>
		<div>
			<h1>Almacenes Old</h1>
			<table>
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>nombre</th>
			      <th>libros</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Warehouse> oldWarehouses = (List<Warehouse>)request.getAttribute("oldWarehouses"); %>
				<c:forEach var="warehouse" items="${oldWarehouses}">
					<tr>
						<td><c:out value="${warehouse.getId()}"/></td>
						<td><c:out value="${warehouse.getName()}"/></td>
					 	<td>
					 		<div>
								<c:forEach var="book" items="${warehouse.getBooks()}">
									<div><c:out value="${book.getIsbn()}"/></div>
								</c:forEach>
					 		</div>
					 	</td>
					 	<td><a href='/deleteWarehouse?id=${warehouse.getId()}&type=old'>Borrar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		<hr />
		<div>
			<h1>Almacenes New</h1>
			<table>
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>nombre</th>
			      <th>libros</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Warehouse> newWarehouses = (List<Warehouse>)request.getAttribute("newWarehouses"); %>
				<c:forEach var="warehouse" items="${newWarehouses}">
					<tr>
						<td><c:out value="${warehouse.getId()}"/></td>
						<td><c:out value="${warehouse.getName()}"/></td>
					 	<td>
					 		<div>
								<c:forEach var="book" items="${warehouse.getBooks()}">
									<div><c:out value="${book.getIsbn()}"/></div>
								</c:forEach>
					 		</div>
					 	</td>
					 	<td><a href='/deleteWarehouse?id=${warehouse.getId()}&type=new'>Borrar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
</html>