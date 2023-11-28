<%-- 
    Document   : agregar_turno
    Created on : 26-nov-2023, 22:48:01
    Author     : Ivan
--%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.izambrana.pruebatec2.logica.Controladora" %>
<%@ page import="com.izambrana.pruebatec2.logica.Ciudadano" %>
<%@page contentType="text/html" pageEncoding="UTF-8"  language="java"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Reportar Incidencia</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    </head>
    <body>
        <%
            String ciudadanoIdStr = request.getParameter("ciudadanoId");
            int ciudadanoId = Integer.parseInt(ciudadanoIdStr);

            Controladora control = new Controladora();
            Ciudadano ciudadano = control.obtenerCiudadanoPorId(ciudadanoId);
        %>

        <h2>Turno de incidencia para <%= ciudadano.getNombre()%> <%= ciudadano.getApellidos()%></h2>
        <form action="SvTurno" method="POST">
            <input type="hidden" name="ciudadanoId" value="<%= ciudadanoId%>" />
            <div class="form-group">
                <label for="numero_turno">Número de Turno:</label>
                <input type="text" class="form-control" id="numero_turno" name="numero_turno" required>
            </div>
            <div class="form-group">
                <label for="fecha_turno">Fecha:</label>
                <input type="date" class="form-control" id="fecha_turno" name="fecha_turno" required>
            </div>
            <div class="form-group">
                <label for="descripcion">Descripción del trámite:</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary" onclick="return confirm('¿Deseas agregar esta incidencia?')">Agregar Turno</button>
        </form>
        <a href="index.jsp">Volver a página principal</a>
        
    </body> 
</html>
