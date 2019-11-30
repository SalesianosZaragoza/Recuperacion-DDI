<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualiza los datos</title>
</head>
<body>
<form action="/update?id=${usuario.id}" method="post">
        <span>ID:</span> <input type="text" value="${usuario.id}" disabled="disabled" name="id"> <br />
        <span>nombre:</span> <input type="text" value="${usuario.nombre}" name="nombre"> <br />
        <span>apellido:</span> <input type="text" value="${usuario.apellido}" name="apellido"> <br />
        <span>dni:</span> <input type="text" value="${usuario.dni}" name="dni"> <br />
        <input type="submit">
    </form>
</body>
</html>