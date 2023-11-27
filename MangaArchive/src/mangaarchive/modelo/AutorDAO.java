/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mangaarchive.bd.Conexion;

public class AutorDAO {
    
    private int id, nacionalidadID;
    private String nombre;

    public AutorDAO(String nombre, int nacionalidadID) {
        this.nombre = nombre;
        this.nacionalidadID = nacionalidadID;
    
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
            System.out.println("Error SQL - obtenerListaAutor: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - obtenerListaAutor: "+ex.getMessage());
        } 
        return listaAutor;
    } 
    
    public String[] obtenerListaNombreAutor(){
        String[] listaAutor= new String[5000];
        try {
            int i = 0;
	    Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            String query="SELECT nombre FROM autor Order by id";
            PreparedStatement stmt = conectar.prepareStatement(query);           
            ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                setNombre(rs.getString("nombre"));
                listaAutor[i]=this.getNombre();
                i++;
            }
            stmt.close();
            conectar.close();            
       } catch (SQLException ex) {
            System.out.println("Error SQL - obtenerListaNombreAutor: "+ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - obtenerListaNombreAutor: "+ex.getMessage());
        } 
        return listaAutor;
    } 
    
    public int registrarAutorBD() {
        try {
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();

            PreparedStatement stmt = conectar.prepareStatement("INSERT INTO autor (nombre, nacionalidad_id) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, this.getNombre());
            stmt.setInt(2, this.getNacionalidadID());

            // Ejecutar la inserción
            stmt.executeUpdate();
            
            // Obtener las claves generadas (en este caso, el ID autoincremental)
            ResultSet generatedKeys = stmt.getGeneratedKeys();

            int lastInsertedId = -1;
            if (generatedKeys.next()) {
                lastInsertedId = generatedKeys.getInt(1);
                System.out.println("Último ID de manga insertado: " + lastInsertedId);
            } else {
                System.out.println("No se pudo obtener el último ID de manga insertado.");
            }
            
            // Cerrar la conexión
            generatedKeys.close();
            stmt.close();
            conectar.close();

            return lastInsertedId;
        } catch (SQLException ex) {
            System.out.println("Error SQL - agregarAutor: " + ex.getMessage());
            return 0;
        } catch (Exception ex) {
            System.out.println("Error - agregarAutor: " + ex.getMessage());
            return 0;
        }
    }
    
    public AutorDTO obtenerAutorPorNombreBD(String nombre){
        AutorDTO autor = null;
        try{
            
            Conexion conexion = new Conexion();
            Connection conectar =  conexion.conectar();
            
            PreparedStatement stmt = conectar.prepareStatement("SELECT * FROM autor WHERE nombre = ?");
            stmt.setString(1, nombre);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                autor = new AutorDTO();
                autor.setId(rs.getInt("id"));
                autor.setNombre(nombre);
                autor.setNacionalidadID(rs.getInt("nacionalidad_id"));
            }
            
            stmt.close();
            conectar.close();
            
            return autor;
        } catch (SQLException ex){
            System.out.println("Error SQL - obtenerAutorPorNombreBD: "+ex.getMessage());
        } catch (Exception ex){
            System.out.println("Error - obtenerAutorPorNombreBD: "+ex.getMessage());
        }
        return autor;
    }
    
    public AutorDTO obtenerAutorPorIDBD(int id){
        try {
            // Establecer la conexión a la base de datos
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();

            // Obtener información principal del autor
            PreparedStatement stmt = conectar.prepareStatement("SELECT * FROM autor WHERE id = " + id);           
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados de la consulta principal
            while (rs.next()) {
                setId(rs.getInt("id"));
                setNombre(rs.getString("nombre"));
                setNacionalidadID(rs.getInt("nacionalidad_id"));
            }

            // Cerrar recursos de la base de datos
            stmt.close();
            conectar.close();   
        } catch (SQLException ex) {
            // Manejar errores de SQL
            System.out.println("Error SQL - obtenerAutorPorIDBD: "+ex.getMessage());
        } catch (Exception ex) {
            // Manejar errores generales
            System.out.println("Error - obtenerAutorPorIDBD: "+ex.getMessage());
        } 
        // Devolver un objeto AutorDTO con la información obtenida
        return new AutorDTO(this.getId(), this.getNombre(), this.getNacionalidadID());
    }   
    
    
    public boolean modificarAutor(int autorID, String nombre, int nacionalidadID) {
        try {
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            //declaro el PreparedStatement para configurar la instrucción a ejecutar
            PreparedStatement stmt = conectar.prepareStatement("UPDATE autor SET nombre=?,nacionalidad_id=? WHERE id=?");
            //Reemplazo los '?' en el stmt       
            stmt.setString(1, nombre);
            stmt.setInt(2, nacionalidadID);
            stmt.setInt(3, autorID);
            //ejecuto la sentencia
            stmt.executeUpdate();       
            
            //cierro las conexiones
            stmt.close();
            conectar.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL - modificarAutor: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error - modificarAutor: " + ex.getMessage());
            return false;
        }
    }
}
