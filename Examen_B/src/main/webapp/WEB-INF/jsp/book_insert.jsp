<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.List,es.salesianos.model.Warehouse" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insertar Empresa</title>
</head>
<body>
	<div class="container-fluid">
		<div class="m-4">
			<nav class="navbar navbar-light bg-light justify-content-between">
			  	<a class="navbar-brand">Inserta un libro</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item p-1">
						<a href='/BookList' class="btn btn-primary" role="button" aria-disabled="true">Volver</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="p-4">
			<p>Rellena el formulario</p>
			<form:form action="BookInsert" method="POST" modelAttribute="book">
				Isbn: <form:input type="text" path="isbn"/><br/>
				Fecha Edición: <form:input path="dateString" type="date" onchange="onDateChange(this)"/><br/>
				Almacen:
				 <select id="warehouse_helper">
					<option>- Selecciona una fecha primero -</option>
				 </select> 
				 
				
				 <form:select id="warehouse_old" path="warehouseOldId" style="display: none" disabled="disabled">
  					<c:forEach var="warehouse" items="${oldWarehouses}">
					     <form:option value="${warehouse.getId()}" label="${warehouse.getName()}" />				
					</c:forEach>
				  </form:select>
				  <form:select id="warehouse_new" path="warehouseNewId" style="display: none" disabled="disabled">
  					<c:forEach var="warehouse" items="${newWarehouses}">
					     <form:option value="${warehouse.getId()}" label="${warehouse.getName()}" />				
					</c:forEach>
				  </form:select>
				<button type="submit" class="btn btn-primary">Insertar</button>
			</form:form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script type="text/javascript">
	let oldWarehouses;
	let newWarehouses;
	let warehouse_helper;
	
	window.onload = function() {
		oldWarehouses = document.getElementById('warehouse_old');
		newWarehouses = document.getElementById('warehouse_new');
		warehouse_helper = document.getElementById('warehouse_helper');
	}

	function onDateChange(input) {
		let d = new Date(input.value);
		let year = d.getFullYear();
		if (isNaN(year)) {
			return;
		}
		
		warehouse_helper.style.display = "none";
		warehouse_helper.disabled = true;
		if (year < 2000) {
			console.log("<2000");
			newWarehouses.disabled = true;
			newWarehouses.style.display = "none";
			oldWarehouses.disabled = false;
			oldWarehouses.style.display = "inline-block";
		} else {
			console.log(">=2000");
			oldWarehouses.disabled = true;
			oldWarehouses.style.display = "none";
			newWarehouses.style.display = "inline-block";
			newWarehouses.disabled = false;
		}
	}
	</script>
</body>
</html>