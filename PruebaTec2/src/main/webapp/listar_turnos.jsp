<%-- 
    Document   : listar_turnos
    Created on : 27-nov-2023, 1:13:23
    Author     : Ivan
--%>

<%@page import="java.util.List"%>
<%@page import="com.izambrana.pruebatec2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de turnos</title>
    </head>
    <body>
        <h1>Listado de turnos</h1>
        <div class="container">
            <h2>Listado de Turnos</h2>
            <form action="SvTurno" method="GET">
                <button type="submit" name="action" value="mostrarTurnos">Mostrar turnos</button>
                <% if (request.getAttribute("listaTurnos") != null) { %>
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID Turno</th>
                            <th>Número Turno</th>
                            <th>Descripción de Incidencia</th>
                            <th>Fecha</th>
                            <th>Nombre Ciudadano</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Turno turno : (List<Turno>) request.getAttribute("listaTurnos")) {%>
                        <tr>
                            <td><%= turno.getId()%></td>
                            <td><%= turno.getNumero()%></td>
                            <td><%= turno.getDescTramite()%></td>
                            <td><%= turno.getFechaTurno()%></td>
                            <td><%= turno.getCiudadano()%>}</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% }%>
            </form>
        </div>
    </body>
</html>
