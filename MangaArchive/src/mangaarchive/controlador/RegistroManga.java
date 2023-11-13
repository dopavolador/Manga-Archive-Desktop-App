/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.controlador;

import mangaarchive.bd.*;
import mangaarchive.modelo.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Álvaro Mora y Bastian Heresmann
 */
public class RegistroManga {
    /*
    Agrega mangas al sistema, retornando true or false dependiendo de si falla o no
    */
    public boolean addManga(Manga manga){
        try{
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query = "INSERT INTO manga (id, titulo, precio, autor_id, demografia_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conectar.prepareStatement(query);
            stmt.setInt(1, manga.getId());
            stmt.setString(2, manga.getTitulo());
            stmt.setInt(3, manga.getPrecio());
            stmt.setInt(4, manga.getAutorID());
            stmt.setInt(5, manga.getDemografiaID());
            stmt.executeUpdate();
            stmt.close();
            conectar.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL - agregarManga: "+ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error - agregarManga: "+ex.getMessage());
            return false;
        }  
    }
    
    /*
    Busca un manga por id,  retorna el manga, si no retorna un manga con solo un dato "0"
    */
    public Manga buscarPorId(int id){
        Manga manga=new Manga();        
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query = "SELECT * FROM manga WHERE id=?";
            PreparedStatement stmt = conectar.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if (rs.next()) {
                manga.setId(id);
                manga.setTitulo(rs.getString("titulo"));
                manga.setPrecio(rs.getInt("precio"));
                manga.setAutorID(rs.getInt("autor_id"));
                manga.setDemografiaID(rs.getInt("demografia_id"));
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - buscarPorId: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - buscarPorId: "+ex.getMessage());
        }   
        return manga;
    }
    
    /*
    Obtiene los datos de la tabla manga y los devuelve en forma de arrayList
    */
    public ArrayList<Manga> listarManga(){
        ArrayList<Manga> listaManga= new ArrayList<Manga>();
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="SELECT * FROM manga Order by id";
            PreparedStatement stmt = conectar.prepareStatement(query);           
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                Manga manga = new Manga();
                manga.setId(rs.getInt("id"));
                manga.setTitulo(rs.getString("titulo"));
                manga.setPrecio(rs.getInt("precio"));
                manga.setAutorID(rs.getInt("autor_id"));
                manga.setDemografiaID(rs.getInt("demografia_id"));
                listaManga.add(manga);
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - buscarPorId: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - buscarPorId: "+ex.getMessage());
        } 
        return listaManga;
    }   
    
}
