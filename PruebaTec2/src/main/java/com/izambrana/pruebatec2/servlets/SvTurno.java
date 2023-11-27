package com.izambrana.pruebatec2.servlets;

import com.izambrana.pruebatec2.logica.Ciudadano;
import com.izambrana.pruebatec2.logica.Controladora;
import com.izambrana.pruebatec2.logica.Turno;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        //PUREBA
        String ciudadanoStr = request.getParameter("ciudadano");
        int ciudadanoId = Integer.parseInt(ciudadanoStr);

        //Convertir fecha
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-mm-dd");
            Date fechaTurno = sdf.parse(fecha);

            //Crear un objeto turno
            Turno turno = new Turno();
            turno.setNumero(Integer.parseInt(numeroTurno));
            turno.setDescTramite(descripcion);
            turno.setFechaTurno(fechaTurno);

            // Obtener ciudadano para setearlo
            Ciudadano ciudadano = control.obtenerCiudadanoPorId(ciudadanoId);
            turno.setCiudadano(ciudadano);

            //Se persiste el equipo en la BD
            control.crearTurno(turno);

        } catch (ParseException ex) {
            Logger.getLogger(SvTurno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
