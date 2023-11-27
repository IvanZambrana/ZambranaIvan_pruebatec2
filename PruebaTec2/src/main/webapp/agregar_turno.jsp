<%-- 
    Document   : agregar_turno
    Created on : 26-nov-2023, 22:48:01
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incidencia</title>
    </head>
    <body>
        <div class="container">
            <h2>Turno de incidencia para <%= request.getAttribute("nombreCiudadano") %></h2>
            <form action="SvTurno" method="POST">
                <input type="text" name="ciudadano" value="<%= request.getAttribute("ciudadanoId") %>" />
                <div class="form-group">
                    <label for="numero_turno">Número de Turno:</label>
                    <input type="text" class="form-control" id="numero_turno" name="numero_turno" required>
                </div>
                <div class="form-group">
                    <label for="fecha_turno">Fecha:</label>
                    <input type="date" class="form-control" id="fecha_turno" name="fecha_turno" required>
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción del Trámite:</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Agregar Turno</button>
            </form>
        </div>
    </body>
</html>
