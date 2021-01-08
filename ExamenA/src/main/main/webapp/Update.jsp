<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
<form action="/update?id=${student.id}" method="post">
        <span>ID:</span> <input type="text" value="${student.id}" disabled="disabled" name="id"> <br />
        <span>name_student:</span> <input type="text" value="${student.name_student}" name="name_student"> <br />
        <span>age:</span> <input type="text" value="${student.age}" name="age"> <br />
        <span>FCTasists:</span> <input type="text" value="${student.FCTasists}" name="FCTasists"> <br />
		<span>company</span> <input type="text" value="${student.company}" name="company"> <br />
        <input type="submit">
    </form>
</body>
</html>