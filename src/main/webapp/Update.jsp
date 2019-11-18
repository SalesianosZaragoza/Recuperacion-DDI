<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="welcome" method="post">

        <span>ID:</span> <input type="text" name="id" value="${user.id}" disabled="disabled"> <br />
        <span>nombre:</span> <input type="text" value="${user.nombre}" name="nombre"> <br />
        <span>apellido:</span> <input type="text" value="${user.apellido}" name="apellido"> <br />
        <input type="submit">
    </form>
</body>
</html>