<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,es.salesianos.model.Business" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Listado de Empresas</title>
</head>
<body>
	<div class="container-fluid">
		<div class="m-4">
			<nav class="navbar navbar-light bg-light justify-content-between">
			  	<a class="navbar-brand">Listado de Empresas</a>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item p-1">
						<a href='/businessInsert' class="btn btn-info" role="button" aria-disabled="true">Insertar</a>
						<a href='/studentList' class="btn btn-primary" role="button" aria-disabled="true">Alumnos</a>
					</li>
				</ul>
			</nav>
		</div>
		<div>
		<h1>List of Business</h1>
		<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">id</th>
			      <th scope="col">nombre</th>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			 <tbody>
				<c:forEach items="${list}" var="business">
					<tr>
						<td><c:out value="${business.id}"/></td>
						<td><c:out value="${business.name}"/></td>
						<td class="col-1 text-right"><a href='/businessEdit?id=${business.id}' class="btn btn-success" role="button" aria-disabled="true">Editar</a></td>
						<td class="col-1 text-right"><a href='/businessDelete?id=${business.id}' class="btn btn-danger" role="button" aria-disabled="true">Borrar</a></td>
			    	</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>