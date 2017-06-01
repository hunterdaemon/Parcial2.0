package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Visitas_Tecnicas;
import edu.co.sergio.mundo.vo.Recoleccion;
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
 

public class Visitas_tecnicasDao  {

    
    
    
    
   
    
    
    
    
    
    
	/**
	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
	 * @return List<Departamento> Retorna la lista de Departamentos existentes en la base de datos
	 */
    
	public List<Visitas_Tecnicas> findAll() {
		List<Visitas_Tecnicas> Visitas= null;
	    String query = "SELECT * FROM visitas_tecnicas";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(Visitas_tecnicasDao.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int id =0;
	    String fecha = null;
            String tecnico=null;
            boolean presenciademiel;
            boolean precenciadereina;
            int panalesconaimento=0;
            int panalesconcria=0;
            int panalesconceravacios=0;
            boolean aprobacion;
            
	    while (rs.next()){
	    	if(Visitas == null){
	    		Visitas= new ArrayList<Visitas_Tecnicas>();
	    	}
	      
	        Visitas_Tecnicas registro= new Visitas_Tecnicas();
	        id = rs.getInt("id_visita");
	        registro.setId_visita(id);
	        
	        fecha = rs.getString("fecha");
	        registro.setFecha(fecha) ;
	        
                tecnico=rs.getString("tecnico");
                registro.setTecnico(tecnico);
                
                presenciademiel=rs.getBoolean("presenciademiel");
                registro.setPresenciademiel(presenciademiel);
                
                precenciadereina=rs.getBoolean("precenciadereina");
                registro.setPrecenciadereina(precenciadereina);
                
                panalesconaimento=rs.getInt("panalesconaimento");
                registro.setPanalesconaimento(panalesconaimento);
                
                panalesconcria=rs.getInt("panalesconcria");
                registro.setPanalesconcria(panalesconcria);
                
                panalesconceravacios=rs.getInt("panalesconceravacios");
                registro.setPanalesconceravacios(panalesconceravacios);
                
                aprobacion=rs.getBoolean("aprobacion");
                registro.setAprobacion(aprobacion);
                
                
	        Visitas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Visitas tecnicas");
			e.printStackTrace();
		}
	    
	    return Visitas;
	}

	
	/**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Visitas_Tecnicas
	 * @param Departamento recibe un objeto de tipo Visitas_Tecnicas 
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
////	public boolean insert(Visitas_Tecnicas t) {
////		boolean result=false;
////		Connection connection=null;
////            try {
////                connection = Conexion.getConnection();
////            } catch (URISyntaxException ex) {
////                Logger.getLogger(Visitas_tecnicasDao.class.getName()).log(Level.SEVERE, null, ex);
////            }
////	    String query = " insert into Depto (id_depto,nom_depto)"  + " values (?,?)";
////        PreparedStatement preparedStmt=null;
////	    try {
////			preparedStmt = connection.prepareStatement(query);
////			preparedStmt.setInt (1, t.getId_departamento());
////                        preparedStmt.setString (2, t.getNom_departamento());
////			result= preparedStmt.execute();
////	    } catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return result;
////	}
////
////	/**
////	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Visitas_Tecnicas
////	 * @param Departamento recibe un objeto de tipo Visitas_Tecnicas 
////	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
////	 */
////	public boolean update(Visitas_Tecnicas t) {
////		boolean result=false;
////		Connection connection= null;
////            try {
////                connection = Conexion.getConnection();
////            } catch (URISyntaxException ex) {
////                Logger.getLogger(Visitas_tecnicasDao.class.getName()).log(Level.SEVERE, null, ex);
////            }
////		String query = "update Depto set nom_depto = ? where id_depto = ?";
////		PreparedStatement preparedStmt=null;
////		try {
////		    preparedStmt = connection.prepareStatement(query);
////		    preparedStmt.setString(1, t.getNom_departamento());
////                    preparedStmt.setInt   (2, t.getId_departamento());
////		    if (preparedStmt.executeUpdate() > 0){
////		    	result=true;
////		    }
////			    
////		} catch (SQLException e) {
////				e.printStackTrace();
////		}
////			
////		return result;
////	}
////
////	/**
////	 * Funcion que permite realizar la eliminario de registro en la tabla Visitas_Tecnicas
////	 * @param Departamento recibe un objeto de tipo Visitas_Tecnicas 
////	 * @return boolean retorna true si la operacion de borrado es exitosa.
////	 */
////	public boolean delete(Visitas_Tecnicas t) {
////	   boolean result=false;
////	   Connection connection = null;
////            try {
////                connection = Conexion.getConnection();
////            } catch (URISyntaxException ex) {
////                Logger.getLogger(Visitas_tecnicasDao.class.getName()).log(Level.SEVERE, null, ex);
////            }
////	   String query = "delete from Depto where id_depto = ?";
////	   PreparedStatement preparedStmt=null;
////	   try {
////		     preparedStmt = connection.prepareStatement(query);
////		     preparedStmt.setInt(1, t.getId_departamento());
////		    result= preparedStmt.execute();
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	   
////	   return result;
////	}
}
