<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Warehouse" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insertar Libro</title>
</head>
<body>
	<div class="container-fluid">
		<div class="m-4">
			<nav class="navbar navbar-light bg-light justify-content-between">
			  	<a class="navbar-brand">Insertar un nuevo Libro</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item p-1">
						<a href='/listadoLibros' class="btn btn-primary" role="button" aria-disabled="true">Volver</a>
					</li>
				</ul>
			</nav>
		</div>
		<div class="p-4">
			<p>Rellena el formulario a continuación.</p>
			<form action="insertarLibro" method="post">
				<div>
					<span for="isbn">Isbn</span>
					<input id="isbn" type="text" name="isbn">
				</div>
				<div>
					<span for="editionDate">Fecha Edición</span>
					<input id="editionDate" type="date" name="editionDate" onchange="onDateChange(this)">
				</div>
				<div>
					<span>Almacen:</span>
					<select id="warehouse_helper">
						<option>- Selecciona una fecha primero -</option>
					</select>
					<% List<Warehouse> oldWarehouses = (List<Warehouse>) request.getAttribute("oldWarehouses"); %>
					<select id="oldWarehouses" name="oldWarehouses" style="display: none" disabled>
						<c:forEach var="warehouse" items="${oldWarehouses}">
							<option value="${warehouse.getId()}">
								<c:out value="${warehouse.getName()}" />
							</option>
						</c:forEach>
					</select>
					<% List<Warehouse> newWarehouses = (List<Warehouse>) request.getAttribute("newWarehouses"); %>
					<select id="newWarehouses" name="newWarehouses" style="display: none" disabled>
						<c:forEach var="warehouse" items="${newWarehouses}">
							<option value="${warehouse.getId()}">
								<c:out value="${warehouse.getName()}" />
							</option>
						</c:forEach>
					</select>
				</div>
	 			<button type="submit" class="btn btn-primary">Insertar</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script type="text/javascript">
	var oldWarehouses;
	var newWarehouses;
	var warehouse_helper;
	
	window.onload = function() {
		oldWarehouses = document.getElementById('oldWarehouses');
		newWarehouses = document.getElementById('newWarehouses');
		warehouse_helper = document.getElementById('warehouse_helper');
	}

	function onDateChange(input) {
		var d = new Date(input.value);
		var year = d.getFullYear();
		if (isNaN(year)) {
			return;
		}
		
		warehouse_helper.style.display = "none";
		warehouse_helper.disabled = true;
		if (year < 2000) {
			newWarehouses.disabled = true;
			newWarehouses.style.display = "none";
			oldWarehouses.disabled = false;
			oldWarehouses.style.display = "inline-block";
		} else {
			oldWarehouses.disabled = true;
			oldWarehouses.style.display = "none";
			newWarehouses.style.display = "inline-block";
			newWarehouses.disabled = false;
		}
	}
	</script>
</body>
</html>