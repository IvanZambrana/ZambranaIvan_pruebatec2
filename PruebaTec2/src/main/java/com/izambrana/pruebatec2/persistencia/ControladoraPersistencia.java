package com.izambrana.pruebatec2.persistencia;

import com.izambrana.pruebatec2.logica.Ciudadano;
import com.izambrana.pruebatec2.logica.Turno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class ControladoraPersistencia {

    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();

    //Para Ciudadano
    public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.create(ciudadano);
    }

    public Ciudadano obtenerCiudadano(int id) {
        return ciudadanoJPA.findCiudadano(id);
    }

    //Para Turno
    public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }

    public Turno obtenerTurno(int id) {
        return turnoJPA.findTurno(id);
    }

    public List<Turno> traerTurnos() {
        return turnoJPA.findTurnoEntities();
    }

    public void actualizarTurno(Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
