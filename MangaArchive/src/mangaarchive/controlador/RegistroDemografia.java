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
public class RegistroDemografia {
    
    public Demografia buscarPorId(int id){
        Demografia demografia = new Demografia();        
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query = "SELECT * FROM demografia WHERE id=?";
            PreparedStatement stmt = conectar.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if (rs.next()) {
                demografia.setId(id);
                demografia.setNombre(rs.getString("nombre"));
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - buscarPorId: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - buscarPorId: "+ex.getMessage());
        }   
        return demografia;
    }
    
    public ArrayList<Demografia> listarDemografia(){
        ArrayList<Demografia> listaDemografia= new ArrayList<Demografia>();
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="SELECT * FROM demografia Order by id";
            PreparedStatement stmt = conectar.prepareStatement(query);           
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                Demografia demografia = new Demografia();
                demografia.setId(rs.getInt("id"));
                demografia.setNombre(rs.getString("nombre"));
                listaDemografia.add(demografia);
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - buscarPorId: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - buscarPorId: "+ex.getMessage());
        } 
        return listaDemografia;
    } 
    
}