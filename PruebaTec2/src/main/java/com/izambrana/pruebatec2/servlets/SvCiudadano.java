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

        //Crear un nuevo objeto Ciudadano
        Ciudadano ciudadano = new Ciudadano();

        //Añadir atributos
        ciudadano.setNombre(nombre);
        ciudadano.setApellidos(apellido);
        ciudadano.setDni(dni);
        ciudadano.setTelefono(numTelefono);

        //Se persiste el equipo en la BD
        control.crearCiudadano(ciudadano);

        // Guardar el nombre del ciudadano como un atributo de solicitud
        request.setAttribute("nombreCiudadano", nombre);
        // Guardar el ID del ciudadano como un atributo de solicitud
        request.setAttribute("ciudadanoId", ciudadano.getId());

        // Redirigir a la página de agregar_turno
        request.getRequestDispatcher("agregar_turno.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
