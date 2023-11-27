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
        // Verificar si la acción es mostrarTurnos
        String action = request.getParameter("action");
        if ("mostrarTurnos".equals(action)) {
            // Obtener la lista de turnos desde la base de datos
            List<Turno> listaTurnos = control.obtenerTurnos();

            String fechaStr = request.getParameter("fecha_turno");
            if (fechaStr != null && !fechaStr.isEmpty()) {
                // Convertir String a LocalDate
                LocalDate fechaTurno = LocalDate.parse(fechaStr);

                // Filtrar por fecha
                listaTurnos = listaTurnos.stream()
                        .filter(turno -> turno.getFechaTurno().isEqual(fechaTurno))
                        .collect(Collectors.toList());

                // Filtrar por estado "En espera" o "Ya atendido"
                String estado = request.getParameter("opcion");
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

            // Establecer la lista como un atributo de solicitud
            request.setAttribute("listaTurnos", listaTurnos);
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
        String ciudadanoStr = request.getParameter("ciudadano");
        int ciudadanoId = Integer.parseInt(ciudadanoStr);

        //Convertir fecha
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
        //Se persiste el equipo en la BD
        control.crearTurno(turno);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
