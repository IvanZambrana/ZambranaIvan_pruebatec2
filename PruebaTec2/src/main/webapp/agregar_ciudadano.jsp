<%-- 
    Document   : agregar_ciudadano
    Created on : 27-nov-2023, 1:19:15
    Author     : Ivan
--%>

<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Agregar Ciudadano</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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
            <label for="telefono_ciudadano">Teléfono:</label>
            <input type="text" class="form-control" id="telefono_ciudadano" name="telefono_ciudadano" required>
            <br>
            <button type="submit" onclick="return confirm('¿Son correctos los datos del ciudadano?')"> Agregar ciudadano</button>
        </form>
        <a href="index.jsp">Volver a página principal</a>

    </body>
</html>
