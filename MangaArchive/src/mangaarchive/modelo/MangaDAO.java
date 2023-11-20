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

/**
 *
 * @author Emilia
 */
public class MangaDAO {
    
    private int id,precio,autorID,demografiaID;
    private String titulo;

    public MangaDAO() {
    }

    public MangaDAO(int id, int precio, int autorID, int demografiaID, String titulo) {
        this.id = id;
        this.precio = precio;
        this.autorID = autorID;
        this.demografiaID = demografiaID;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAutorID() {
        return autorID;
    }

    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }

    public int getDemografiaID() {
        return demografiaID;
    }

    public void setDemografiaID(int demografiaID) {
        this.demografiaID = demografiaID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public boolean registrarManga(MangaDTO manga){
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
    
    public ArrayList<MangaDTO> obtenerListaManga(){
        ArrayList<MangaDTO> listaManga= new ArrayList<MangaDTO>();
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="SELECT * FROM manga Order by id";
            PreparedStatement stmt = conectar.prepareStatement(query);           
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                setId(rs.getInt("id"));
                setTitulo(rs.getString("titulo"));
                setPrecio(rs.getInt("precio"));
                setAutorID(rs.getInt("autor_id"));
                setDemografiaID(rs.getInt("demografia_id"));
                listaManga.add(new MangaDTO(this.getId(), this.getTitulo(), this.getPrecio(), this.getAutorID(), this.getDemografiaID()));
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
    
    public boolean eliminarManga(int id){
        try {
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="DELETE FROM manga WHERE id=?";
            PreparedStatement stmt = conectar.prepareStatement(query);        
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conectar.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL - eliminarManga: "+ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error - eliminarManga: "+ex.getMessage());
            return false;
        }          
    }
    
}
