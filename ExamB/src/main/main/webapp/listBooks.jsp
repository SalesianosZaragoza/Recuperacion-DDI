<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.List,com.mycompany.model.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>

<title>List of books</title>
</head>
<body>
	<div>
		<table>
			  <thead>
			    <tr>
			      <th>id</th>
			      <th>iSBN</th>
			      <th>dateEdicion</th>
			      <th>warehouse</th>
			      <th></th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<% List<Book> books = (List<Book>)request.getAttribute("books"); %>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.getId()}"/></td>
						<td><c:out value="${book.getIsbn()}"/></td>
						<td><c:out value="${book.getShortDate()}"/></td>
						<td><c:out value="${book.getWarehouse().getName()}"/></td>
						<td><a href='/deleteBook?id=${book.getId()}'  role="button" >Delete</a></td>
			    	</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
</body>
</html>