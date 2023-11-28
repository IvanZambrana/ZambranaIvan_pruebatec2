package com.izambrana.pruebatec2.servlets;

import com.izambrana.pruebatec2.logica.Ciudadano;
import com.izambrana.pruebatec2.logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "SvCiudadano", urlPatterns = {"/SvCiudadano"})
public class SvCiudadano extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Tomar datos del JSP
        String nombre = request.getParameter("nombre_ciudadano");
        String apellido = request.getParameter("apellido_ciudadano");
        String dni = request.getParameter("dni_ciudadano");
        String numTelefono = request.getParameter("telefono_ciudadano");

        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(nombre);
        ciudadano.setApellidos(apellido);
        ciudadano.setDni(dni);
        ciudadano.setTelefono(numTelefono);

        //Se persiste el equipo en la BD
        control.crearCiudadano(ciudadano);

        request.setAttribute("nombreCiudadano", nombre);
        request.setAttribute("apellidoCiudadano", apellido);
        request.setAttribute("ciudadanoId", ciudadano.getId());

        // Redirigir a la página de agregar_turno con el parámetro en la URL
        response.sendRedirect("agregar_turno.jsp?ciudadanoId=" + ciudadano.getId());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
