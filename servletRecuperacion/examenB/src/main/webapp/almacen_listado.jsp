<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Almacen" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Listado de Almacenes</title>
</head>
<body>
	<div>
		<div>
			
		</div>
		<div>
			<h1>Almacenes Old</h1>
			<table>
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>nombre</th>
			      <th>libros</th>
			      <th></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Almacen> almacenes_old = (List<Almacen>)request.getAttribute("almacenes_old"); %>
				<c:forEach var="almacen" items="${almacenes_old}">
					<tr>
						<td><c:out value="${almacen.getId()}"/></td>
						<td><c:out value="${almacen.getName()}"/></td>
					 	<td><select class="custom-select" multiple readonly>
							<c:forEach var="libro" items="${almacen.getLibros()}">
								<option><c:out value="${libro.getIsbn()}"/></option>
							</c:forEach>
					 	</select></td>
					 	<td><a href='/borrarAlmacen?id=${almacen.getId()}&type=old'  role="button" >Borrar</a></td>
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
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Almacen> almacenes_new = (List<Almacen>)request.getAttribute("almacenes_new"); %>
				<c:forEach var="almacen" items="${almacenes_new}">
					<tr>
						<td><c:out value="${almacen.getId()}"/></td>
						<td><c:out value="${almacen.getName()}"/></td>
					 	<td><select class="custom-select" multiple readonly>
							<c:forEach var="libro" items="${almacen.getLibros()}">
								<option><c:out value="${libro.getIsbn()}"/></option>
							</c:forEach>
					 	</select></td>
					 	<td><a href='/borrarAlmacen?id=${almacen.getId()}&type=new' " role="button" >Borrar</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
</html>