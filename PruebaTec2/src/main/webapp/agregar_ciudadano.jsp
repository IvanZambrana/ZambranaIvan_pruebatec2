<%-- 
    Document   : agregar_ciudadano
    Created on : 27-nov-2023, 1:19:15
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Datos del Ciudadano</h3>
        <form action="SvCiudadano" method="POST">
            <label for="nombre_ciudadano">Nombre:</label>
            <input type="text" class="form-control" id="nombre_ciudadano" name="nombre_ciudadano" required>
            <br>
            <label for="apellido_ciudadano">Apellidos:</label>
            <input type="text" class="form-control" id="apellido_ciudadano" name="apellido_ciudadano" required>
            <br>
            <label for="dni_ciudadano">DNI:</label>
            <input type="text" class="form-control" id="dni_ciudadano" name="dni_ciudadano" required>
            <br>
            <label for="telefono_ciudadano">Telefono:</label>
            <input type="text" class="form-control" id="telefono_ciudadano" name="telefono_ciudadano" required>
            <br>
            <button type="submit"> Agregar ciudadano</button>
        </form>
    </body>
</html>
