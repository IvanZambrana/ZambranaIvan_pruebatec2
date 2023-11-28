<%-- 
    Document   : listar_turnos
    Created on : 27-nov-2023, 1:13:23
    Author     : Ivan
--%>

<%@page import="java.util.List"%>
<%@page import="com.izambrana.pruebatec2.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Lista de turnos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    </head>
    <body>
        <h1>Listado de turnos</h1>
        <form action="SvTurno" method="GET">
            <div class="form-group">
                <label for="fecha_turno">Fecha:</label>
                <input type="date" class="form-control" id="fecha_turno" name="fecha_turno" required
                       value="<%= request.getParameter("fecha_turno")%>">
            </div>
            <div>
                <label>
                    <input type="radio" name="opcion" value="en_espera">
                    En espera
                </label>

                <label>
                    <input type="radio" name="opcion" value="ya_atendido">
                    Ya atendido
                </label>
            </div>
            <div class="container">
                <button type="submit" name="action" value="mostrarTurnos">Mostrar turnos</button>
                <a href="index.jsp">Volver a página principal</a>
                <% if (request.getAttribute("listaTurnos") != null) { %>
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID Turno</th>
                            <th>Número Turno</th>
                            <th>Descripción de Incidencia</th>
                            <th>Fecha</th>
                            <th>Nombre Ciudadano</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Turno turno : (List<Turno>) request.getAttribute("listaTurnos")) {%>
                        <tr>
                            <td><%= turno.getId()%></td>
                            <td><%= turno.getNumero()%></td>
                            <td><%= turno.getDescTramite()%></td>
                            <td><%= turno.getFechaTurno()%></td>
                            <td><%= turno.getCiudadano()%></td>
                            <td><%= turno.getEstado()%></td>
                            <td>
                            <td>
                                <a href="SvTurno?action=cambiarEstado&idTurno=<%= turno.getId()%>" 
                                   onclick="return confirm('¿Deseas solucionar esta incidencia?')"
                                   <% if ("Ya atendido".equals(turno.getEstado())) { %>style="display:none;"<% } %>
                                   >
                                    Solucionar Incidencia
                                </a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% }%>
        </form>
    </div>
</body>
</html>
