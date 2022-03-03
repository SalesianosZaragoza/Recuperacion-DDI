<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Permiso</title>
    </head>
    <body>
        <h1>Permiso de entrada</h1>
        <table>
            <tr>
                <td>
                    Nombre
                </td>
                <td>
                    Apellido
                </td>
                <td>
                    Hora de entrada
                </td>
                <td>
                    Hora de salida
                </td>
                <td>
                    Entrada
                </td>
            </tr>
            <tr>
                <td>
                    ${nombre}
                </td>
                <td>
                    ${apellidos}
                </td>
                <td>
                    ${entrada}
                </td>
                <td>
                    ${salida}
                </td>
                <td>
                    ${permiso}
                </td>
            </tr>
        </table>
        <br/>
        <br/>
        <a href="comprobacionForm.jsp">Buscar otro alumno</a>
        <br/>
        <br/>
        <a href="welcome">Listado de alumnos</a>
    </body>
</html>