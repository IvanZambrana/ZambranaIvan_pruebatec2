package com.izambrana.pruebatec2.logica;

import com.izambrana.pruebatec2.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //Para Ciudadanos
    public void crearCiudadano(Ciudadano ciudadano) {
        controlPersis.crearCiudadano(ciudadano);
    }
    
    public Ciudadano obtenerCiudadanoPorId(int id){
        return controlPersis.obtenerCiudadano(id);
    }
    
     //Para Turnos
    public void crearTurno(Turno turno) {
        controlPersis.crearTurno(turno);
    }
    
    public List<Turno> obtenerTurnos(){
        return controlPersis.traerTurnos();
    }
    
}
