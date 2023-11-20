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

public class AutorDAO {
    
    private int id, nacionalidadID;
    private String nombre;

    public AutorDAO(int id, int nacionalidadID, String nombre) {
        this.id = id;
        this.nacionalidadID = nacionalidadID;
        this.nombre = nombre;
    }

    public AutorDAO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNacionalidadID() {
        return nacionalidadID;
    }

    public void setNacionalidadID(int nacionalidadID) {
        this.nacionalidadID = nacionalidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public ArrayList<AutorDTO> obtenerListaAutor(){
        ArrayList<AutorDTO> listaAutor= new ArrayList<AutorDTO>();
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="SELECT * FROM autor Order by id";
            PreparedStatement stmt = conectar.prepareStatement(query);           
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                setId(rs.getInt("id"));
                setNombre(rs.getString("nombre"));
                setNacionalidadID(rs.getInt("nacionalidad_id"));
                listaAutor.add(new AutorDTO(this.getId(), this.getNombre(), this.getNacionalidadID()));
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - buscarPorId: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - buscarPorId: "+ex.getMessage());
        } 
        return listaAutor;
    } 
}
