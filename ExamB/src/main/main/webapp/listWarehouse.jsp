<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.mycompany.model.Warehouse" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of warehouses</title>
</head>
<body>
< background-image: url(https://img.freepik.com/vector-gratis/fondo-tecnologia-digital-alambre-malla-red_1017-27428.jpg?size=626&ext=jpgmariposa_p.png)">

<div>
		<div>
			<h1>Warehouses Old</h1>
			<table>
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>name</th>
			      <th>books</th>
			      <th></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Warehouse> warehouses_old = (List<>)request.getAttribute("warehousess_old"); %>
				<c:forEach var="almacen" items="${almacenes_old}">
					<tr>
						<td><c:out value="${warehouse.getId()}"/></td>
						<td><c:out value="${warehouse.getName()}"/></td>
					 	<td><select class="custom-select" multiple readonly>
							<c:forEach var="book" items="${warehouse.getBooks()}">
								<option><c:out value="${book.getISBN()}"/></option>
							</c:forEach>
					 	</select></td>
					 	<td><a href='/deletewarehouse?id=${warehouse.getId()}&type=old'  role="button" >Delete</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		<hr />
		<div>
			<h1>Warehouses New</h1>
			<table>
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>name</th>
			      <th>books</th>
			      <th></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Warehouse> warehouses_new = (List<Warehouse>)request.getAttribute("warehouses_new"); %>
				<c:forEach var="warehouse" items="${warehouses_new}">
					<tr>
						<td><c:out value="${warehouse.getId()}"/></td>
						<td><c:out value="${warehouse.getName()}"/></td>
					 	<td><select class="custom-select" multiple readonly>
							<c:forEach var="book" items="${warehouse.getBooks()}">
								<option><c:out value="${book.getISBN()}"/></option>
							</c:forEach>
					 	</select></td>
					 	<td><a href='/deleteWarehouse?id=${warehouse.getId()}&type=new' " role="button" >Delete</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
	</html>