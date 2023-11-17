/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.controlador;

import java.sql.*;
import java.util.*;
import mangaarchive.bd.*;
import mangaarchive.modelo.*;

/**
 *
 * @author 
 */
public class RegistroAutor {
    
    public Autor buscarPorId(int id){
        Autor autor = new Autor();        
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query = "SELECT * FROM autor WHERE id=?";
            PreparedStatement stmt = conectar.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if (rs.next()) {
                autor.setId(id);
                autor.setNombre(rs.getString("nombre"));
                autor.setNacionalidadID(rs.getInt("nacionalidad_id"));
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - buscarPorId: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - buscarPorId: "+ex.getMessage());
        }   
        return autor;
    }
    
    public ArrayList<Autor> listarAutor(){
        ArrayList<Autor> listaAutor= new ArrayList<Autor>();
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="SELECT * FROM autor Order by id";
            PreparedStatement stmt = conectar.prepareStatement(query);           
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNombre(rs.getString("nombre"));
                autor.setNacionalidadID(rs.getInt("nacionalidad_id"));
                listaAutor.add(autor);
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