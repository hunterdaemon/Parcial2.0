/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.vo;

/**
 *
 * @author Labing
 */
public class Recoleccion {
    
String fecha ;
String recolector; 
int id_colmena ;
int kilosdeiel ;
boolean aprobacion ;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRecolector() {
        return recolector;
    }

    public void setRecolector(String recolector) {
        this.recolector = recolector;
    }

    public int getId_colmena() {
        return id_colmena;
    }

    public void setId_colmena(int id_colmena) {
        this.id_colmena = id_colmena;
    }

    public int getKilosdeiel() {
        return kilosdeiel;
    }

    public void setKilosdeiel(int kilosdeiel) {
        this.kilosdeiel = kilosdeiel;
    }

    public boolean isAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }




    
    
}
