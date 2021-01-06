<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Warehouse" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Listado de Almacenes</title>
</head>
<body>
	<div class="container-fluid">
		<div class="m-4">
			<nav class="navbar navbar-light bg-light justify-content-between">
			  	<a class="navbar-brand">Listado de Almacenes</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item p-1">
						<a href='/almacen_insertar.jsp' class="btn btn-info" role="button" aria-disabled="true">Insertar</a>
						<a href='/listadoLibros' class="btn btn-primary" role="button" aria-disabled="true">Libros</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="p-4">
			<h1>Almacenes Old</h1>
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nombre</th>
			      <th scope="col">libros</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
			  	List<Warehouse> almacenes_old = (List<Warehouse>)request.getAttribute("oldWarehouses");
			  	%>
				<c:forEach var="warehouse" items="${almacenes_old}">
					<tr>
						<td><c:out value="${warehouse.getId()}"/></td>
						<td><c:out value="${warehouse.getName()}"/></td>
					 	<td><select class="custom-select" multiple readonly>
							<c:forEach var="book" items="${warehouse.getLibros()}">
								<option><c:out value="${book.getIsbn()}"/></option>
							</c:forEach>
					 	</select></td>
					 	<td class="col-1 text-right"><a href='/editarAlmacen?id=${warehouse.getId()}&type=old' class="btn btn-success" role="button" aria-disabled="true">Editar</a></td>
					 	<td class="col-1 text-left"><a href='/borrarAlmacen?id=${warehouse.getId()}&type=old' class="btn btn-danger" role="button" aria-disabled="true">Borrar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		<hr />
		<div class="p-4">
			<h1>Almacenes New</h1>
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nombre</th>
			      <th scope="col">libros</th>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
			  	List<Warehouse> almacenes_new = (List<Warehouse>)request.getAttribute("newWarehouses");
			  	%>
				<c:forEach var="warehouse" items="${almacenes_new}">
					<tr>
						<td><c:out value="${warehouse.getId()}"/></td>
						<td><c:out value="${warehouse.getName()}"/></td>
					 	<td><select class="custom-select" multiple readonly>
							<c:forEach var="book" items="${warehouse.getBooks()}">
								<option><c:out value="${book.getIsbn()}"/></option>
							</c:forEach>
					 	</select></td>
					 	<td class="col-1 text-right"><a href='/editarAlmacen?id=${warehouse.getId()}&type=new' class="btn btn-success" role="button" aria-disabled="true">Editar</a></td>
					 	<td class="col-1 text-left"><a href='/borrarAlmacen?id=${warehouse.getId()}&type=new' class="btn btn-danger" role="button" aria-disabled="true">Borrar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>