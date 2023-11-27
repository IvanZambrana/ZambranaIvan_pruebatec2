package com.izambrana.pruebatec2.persistencia;

import com.izambrana.pruebatec2.logica.Ciudadano;
import com.izambrana.pruebatec2.logica.Turno;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class ControladoraPersistencia {
    CiudadanoJpaController ciudadanoJPA= new CiudadanoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    
    //Para Ciudadano
     public void crearCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.create(ciudadano);
    }
     
     public Ciudadano obtenerCiudadano(int id){
         return ciudadanoJPA.findCiudadano(id);
     }
     
      //Para Turno
     public void crearTurno(Turno turno) {
        turnoJPA.create(turno);
    }
     
     public List<Turno> traerTurnos(){
         return turnoJPA.findTurnoEntities();
     }
}
