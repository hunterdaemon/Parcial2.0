package edu.co.sergio.mundo.vo;

public class Visitas_Tecnicas {
    
private int idVisita_Tecnica;
private String	Nombre;    
private String Fecha;
private boolean aprobacion ;

    public int getIdVisita_Tecnica() {
        return idVisita_Tecnica;
    }

    public void setIdVisita_Tecnica(int idVisita_Tecnica) {
        this.idVisita_Tecnica = idVisita_Tecnica;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public boolean isAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }


	
	

}
