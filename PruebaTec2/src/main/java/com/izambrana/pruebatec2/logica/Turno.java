package com.izambrana.pruebatec2.logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ivan
 */
@Entity
public class Turno implements Serializable {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private String descTramite;
    private LocalDate fechaTurno;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;
    
    
    //Constructores
    public Turno() {
    }

    public Turno(int numero, String descTramite, Ciudadano ciudadano, LocalDate fechaTurno) {
        this.numero = numero;
        this.descTramite = descTramite;
        this.ciudadano = ciudadano;
        this.fechaTurno = fechaTurno;
        this.estado = "En espera";
    }
    
    //Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescTramite() {
        return descTramite;
    }

    public void setDescTramite(String descTramite) {
        this.descTramite = descTramite;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
