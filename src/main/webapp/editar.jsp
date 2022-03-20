<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js%22%3E"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>

        <title>Edicion de alumnos</title>
    </head>
    <body>
        <h3 class="mx-3 mt-2 danger">Editar</h3>
        <form action="/edit" method="post" class="form-inline">
            <div class="form-group mx-sm-3 mb-2">
                <span>Nombre:</span> <br /> <input type="text" name="Nombre"> <br />
                <span>Apellido:</span> <br /> <input type="text" name="Apellidos"> <br />
                <span>DNI:</span> <br /> <input type="text" name="DNI"> <br />
                <span>Hora de entrada:</span> <br /> <input type="time" name="HoraEntrada" min="08:00"> <br />
                <span>Hora de salida:</span> <br /> <input type="time" name="HoraSalida"  max="21:00"> <br />
                <span>Curso:</span> <br /> <input type="text" name="Curso" > <br />
                <br />
                <button type="submit" class="btn btn-outline-info">Editar!</button>
            </div>
        </form>
        <a class="mx-3  link-secondary" href="welcome">Listado de alumnos</a>
        <a class="mx-3  link-secondary" href="index.jsp">Añadir</a>
    </body>
</html>