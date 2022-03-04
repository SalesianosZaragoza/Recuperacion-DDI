<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js%22%3E"</script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>

        <title>Permiso de entrada</title>
    </head>
    <body>
        <div class="form-group mx-3 mb-2 mt-2">
            <table class="table table-striped">
                <thead>
                    <td class="fw-bold text-center table-active">
                        Nombre
                    </td>
                    <td class="fw-bold text-center table-active">
                        Apellido
                    </td>
                    <td class="fw-bold text-center table-active">
                        Hora de entrada
                    </td>
                    <td class="fw-bold text-center table-active">
                        Hora de salida
                    </td>
                    <td class="fw-bold text-center table-active">
                        Entrada
                    </td>
                </thead>
                <tbody>
                    <td class="text-center">
                        ${nombre}
                    </td>
                    <td class="text-center">
                        ${apellidos}
                    </td>
                    <td class="text-center">
                        ${entrada}
                    </td>
                    <td class="text-center">
                        ${salida}
                    </td>
                    <td class="text-center fst-italic">
                        ${permiso}
                    </td>
                </tbody>
            </table>
        </div>
        <a class="mx-3 link-secondary" href="comprobacionForm.jsp">Buscar otro alumno</a>
        <br/>
        <a class="mx-3 link-secondary" href="welcome">Listado de alumnos</a>
    </body>
</html>