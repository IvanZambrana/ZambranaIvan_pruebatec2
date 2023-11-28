package com.izambrana.pruebatec2.servlets;

import com.izambrana.pruebatec2.logica.Ciudadano;
import com.izambrana.pruebatec2.logica.Controladora;
import com.izambrana.pruebatec2.logica.Turno;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "SvTurno", urlPatterns = {"/SvTurno"})
public class SvTurno extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("mostrarTurnos".equals(action)) {
            List<Turno> listaTurnos = control.obtenerTurnos();

            String fechaStr = request.getParameter("fecha_turno");
            if (fechaStr != null && !fechaStr.isEmpty()) {
                LocalDate fechaTurno = LocalDate.parse(fechaStr);

                // Filtrar por fecha
                listaTurnos = listaTurnos.stream()
                        .filter(turno -> turno.getFechaTurno().isEqual(fechaTurno))
                        .collect(Collectors.toList());

                // Filtrar por estado "En espera" o "Ya atendido"
                String estado = request.getParameter("opcion");
                if (estado != null && !estado.isEmpty()) {
                    listaTurnos = listaTurnos.stream()
                            .filter(turno -> {
                                if ("en_espera".equals(estado)) {
                                    return "En espera".equals(turno.getEstado());
                                } else if ("ya_atendido".equals(estado)) {
                                    return "Ya atendido".equals(turno.getEstado());
                                }
                                return false;
                            })
                            .collect(Collectors.toList());
                }
            }

            request.setAttribute("listaTurnos", listaTurnos);
            String fechaParam = request.getParameter("fecha_turno");
            request.setAttribute("fecha_turno", fechaParam);
        }

        if ("cambiarEstado".equals(action)) {
            String idTurnoStr = request.getParameter("idTurno");
            int idTurno = Integer.parseInt(idTurnoStr);

            Turno turno = control.obtenerTurnoPorId(idTurno);

            turno.setEstado("Ya atendido");

            control.actualizarTurno(turno);

            // Obtener la lista actualizada de turnos
            List<Turno> listaTurnosActualizada = control.obtenerTurnos();

            // Establecer la lista actualizada como un atributo de solicitud
            request.setAttribute("listaTurnos", listaTurnosActualizada);

        }

        // Redirigir a la página listar_turnos.jsp
        request.getRequestDispatcher("listar_turnos.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Tomar datos del JSP
        String numeroTurno = request.getParameter("numero_turno");
        String fecha = request.getParameter("fecha_turno");
        String descripcion = request.getParameter("descripcion");
        String ciudadanoStr = request.getParameter("ciudadanoId");
        int ciudadanoId = Integer.parseInt(ciudadanoStr);
        LocalDate fechaTurno = LocalDate.parse(fecha);

        //Crear un objeto turno
        Turno turno = new Turno();
        turno.setNumero(Integer.parseInt(numeroTurno));
        turno.setDescTramite(descripcion);
        turno.setFechaTurno(fechaTurno);
        turno.setEstado("En espera"); //Siempre que se crea comienza con el estado "En espera"

        // Obtener ciudadano para setearlo
        Ciudadano ciudadano = control.obtenerCiudadanoPorId(ciudadanoId);
        turno.setCiudadano(ciudadano);

        control.crearTurno(turno);

        request.setAttribute("ciudadanoId", ciudadanoId);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Turno agregado con éxito. Para agregar otro turno para el mismo usuario, vuelva a la página.");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
