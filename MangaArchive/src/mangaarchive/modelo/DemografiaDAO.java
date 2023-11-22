/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mangaarchive.bd.Conexion;


public class DemografiaDAO {
    
    private int id;
    private String nombre;

    public DemografiaDAO() {
    }

    public DemografiaDAO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<DemografiaDTO> obtenerListaDemografia(){
        ArrayList<DemografiaDTO> listaDemografia= new ArrayList<DemografiaDTO>();
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="SELECT * FROM demografia Order by id";
            PreparedStatement stmt = conectar.prepareStatement(query);           
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                setId(rs.getInt("id"));
                setNombre(rs.getString("nombre"));
                listaDemografia.add(new DemografiaDTO(this.getId(), this.getNombre()));
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - obtenerListaDemografia: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - obtenerListaDemografia: "+ex.getMessage());
        } 
        return listaDemografia;
    } 
    
    public DemografiaDTO obtenerDemografiaPorIDBD(int id){
        try {
            // Establecer la conexión a la base de datos
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();

            // Obtener información principal de Demografia
            PreparedStatement stmt = conectar.prepareStatement("SELECT * FROM demografia WHERE id = " + id);           
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados de la consulta principal
            while (rs.next()) {
                setId(rs.getInt("id"));
                setNombre(rs.getString("nombre"));
            }

            // Cerrar recursos de la base de datos
            stmt.close();
            conectar.close();   
        } catch (SQLException ex) {
            // Manejar errores de SQL
            System.out.println("Error SQL - obtenerDemografiaPorIDBD: "+ex.getMessage());
        } catch (Exception ex) {
            // Manejar errores generales
            System.out.println("Error - obtenerDemografiaPorIDBD: "+ex.getMessage());
        } 
        // Devolver un objeto DemografiaDTO con la información obtenida
        return new DemografiaDTO(this.getId(),this.getNombre());
    }  
    
}
