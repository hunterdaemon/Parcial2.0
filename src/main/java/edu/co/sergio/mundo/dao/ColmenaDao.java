package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Colmena;
import edu.co.sergio.mundo.vo.Recoleccion;
import edu.co.sergio.mundo.vo.Visitas_Tecnicas;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2
 * Clase que permite la gestion de la tabla Depto en la base de datos.
 * 
 * CREATE TABLE Depto(
 *     id_depto integer,
 *     nom_depto varchar(40),
 *     PRIMARY KEY(id_depto)
 * );
 */
 

public class ColmenaDao  {

    
	/**
	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
	 * @return List<Departamento> Retorna la lista de Departamentos existentes en la base de datos
	 */
    
	public List<Colmena> findAll() {
		List<Colmena> Colmenas= null;
	    String query = "SELECT * FROM Colmenas";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
            
	    int id =0;
            int Poblacion_Cantidad=0;
	    String Poblacion_Calidad = null;
            boolean Presencia_Reina;
            boolean Produccion_Miel;
            boolean Panales_Miel;
            int Panal_Cera=0;
            int Panal_Alimento=0;
            int Panal_Cria=0;
            int Panal_Vacio=0;
            
	    while (rs.next()){
	    	if(Colmenas == null){
	    		Colmenas= new ArrayList<Colmena>();
	    	}
	      
                Colmena registro= new Colmena();
                
	        id = rs.getInt("idColmenas");
	        registro.setIdColmenas(id);
	        
                Poblacion_Cantidad = rs.getInt("Poblacion_Cantidad");
	        registro.setPoblacion_Cantidad(Poblacion_Cantidad);
                
	        Poblacion_Calidad = rs.getString("Poblacion_Calidad");
	        registro.setPoblacion_Calidad(Poblacion_Calidad) ;
	        
                Presencia_Reina=rs.getBoolean("Presencia_Reina");
                registro.setPresencia_Reina(Presencia_Reina);
                
                Produccion_Miel=rs.getBoolean("Produccion_Miel");
                registro.setProduccion_Miel(Produccion_Miel);
                
                Panales_Miel=rs.getBoolean("Panales_Miel");
                registro.setPanales_Miel(Panales_Miel);
                
                Panal_Cera=rs.getInt("Panal_Cera");
                registro.setPanal_Cera(Panal_Cera);
                
                Panal_Alimento=rs.getInt("Panal_Alimento");
                registro.setPanal_Alimento(Panal_Alimento);
                
                Panal_Cria=rs.getInt("Panal_Cria");
                registro.setPanal_Cria(Panal_Cria);
                
                Panal_Vacio=rs.getInt("Panal_Vacio");
                registro.setPanal_Vacio(Panal_Vacio);
                
                
	        Colmenas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Colmenas");
			e.printStackTrace();
		}
	    
	    return Colmenas;
	}

	public List<Recoleccion> findAll3() {
		List<Recoleccion> Recolecciones= null;
	    String query = "SELECT * FROM Recoleccion";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    
	    int idRecoleccion;    
            String Fecha ;
            String Fabrica;
            int KilosMiel;
            
	    while (rs.next()){
	    	if(Recolecciones == null){
	    		Recolecciones= new ArrayList<Recoleccion>();
	    	}
	      
	        Recoleccion registro= new Recoleccion();
                
                idRecoleccion=rs.getInt("idRecoleccion");
                registro.setidRecoleccion(idRecoleccion);
	        
                Fecha = rs.getString("Fecha");
	        registro.setFecha(Fecha);
	        
	        Fabrica= rs.getString("Fabrica");
	        registro.setFabrica(Fabrica); 
                
                KilosMiel=rs.getInt("KilosMiel");
                registro.setKilosMiel(KilosMiel);
               
	        Recolecciones.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Recoleccion");
			e.printStackTrace();
		}
	    
	    return Recoleccion;
	}

        public List<Visitas_Tecnicas> findAll2() {
		List<Visitas_Tecnicas> Visitas_Tecnica= null;
	    String query = "SELECT * FROM Visitas_Tecnicas";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    
	    int idVisita_Tecnica;
            String Nombre;    
            String Fecha;
            boolean aprobacion ;
            
	    while (rs.next()){
	    	if(Visitas_Tecnica == null){
	    		Visitas_Tecnica= new ArrayList<Visitas_Tecnicas>();
	    	}
	      
	        Visitas_Tecnicas registro= new Visitas_Tecnicas();
                
                idVisita_Tecnica=rs.getInt("idVisita_Tecnica");
                registro.setidVisita_Tecnica(idVisita_Tecnica);
	        
                Nombre = rs.getString("Nombre");
	        registro.setNombre(Nombre);
	        
	        Fecha= rs.getString("Fecha");
	        registro.setFecha(Fecha); 
                
                aprobacion=rs.getBoolean("Aprobacion_Recoleccion");
                registro.setaprobacion(aprobacion);
               
	        Visitas_Tecnica.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Visita_Tecnica");
			e.printStackTrace();
		}
	    
	    return Visitas_Tecnica;
	}
        
	
}
