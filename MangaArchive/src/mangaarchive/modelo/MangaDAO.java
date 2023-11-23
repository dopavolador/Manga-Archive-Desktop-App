/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

import java.sql.*;
import java.util.ArrayList;
import mangaarchive.bd.Conexion;

/**
 *
 * @author Emilia
 */
public class MangaDAO {
    
    private int id, precio, autorID, demografiaID, anio;
    private String titulo;
    private ArrayList<Integer> generos;

    public MangaDAO() {
    }

    public MangaDAO(String titulo, int precio, int anio, int autorID, int demografiaID, ArrayList<Integer> generos) {
        this.precio = precio;
        this.autorID = autorID;
        this.demografiaID = demografiaID;
        this.titulo = titulo;
        this.generos = generos;
        this.anio = anio;
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

    public ArrayList<Integer> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Integer> generos) {
        this.generos = generos;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public boolean registrarMangaBD() {
        try {
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();

            // Crear un PreparedStatement con la opción RETURN_GENERATED_KEYS
            PreparedStatement stmt = conectar.prepareStatement(
                    "INSERT INTO manga (titulo, precio, anio, autor_id, demografia_id) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, this.getTitulo());
            stmt.setInt(2, this.getPrecio());
            stmt.setInt(3, this.getAnio());
            stmt.setInt(4, this.getAutorID());
            stmt.setInt(5, this.getDemografiaID());

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

            // Cerrar el ResultSet y el PreparedStatement
            generatedKeys.close();
            stmt.close();

            // Insertar los géneros asociados al manga
            for (int genero : this.getGeneros()) {
                stmt = conectar.prepareStatement("INSERT INTO genero (manga_id, tipo_genero_id) VALUES (?, ?)");
                stmt.setInt(1, lastInsertedId);  // Usar el último ID de manga insertado
                stmt.setInt(2, genero);
                stmt.executeUpdate();
            }

            // Cerrar la conexión
            stmt.close();
            conectar.close();

            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL - agregarManga: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error - agregarManga: " + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<MangaDTO> obtenerListaManga() {
        // Crear una lista para almacenar objetos MangaDTO
        ArrayList<MangaDTO> listaManga = new ArrayList<MangaDTO>();

        try {
            // Establecer la conexión con la base de datos
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();

            // Crear un objeto Statement para ejecutar consultas SQL
            Statement stmt = conectar.createStatement();

            // Ejecutar una consulta para obtener todos los mangas ordenados por ID
            ResultSet rs = stmt.executeQuery("SELECT * FROM manga ORDER BY id");

            // Iterar a través del conjunto de resultados y agregar cada MangaDTO a la lista
            while (rs.next()) {
                // Para cada fila en el resultado, obtener un objeto MangaDTO por ID
                listaManga.add(obtenerMangaPorIDBD(rs.getInt(1)));
            }

            // Cerrar el Statement y la conexión
            stmt.close();
            conectar.close();

        } catch (SQLException ex) {
            // Manejar excepciones relacionadas con SQL
            System.out.println("Error SQL - obtenerListaManga: " + ex.getMessage());
        } catch (Exception ex) {
            // Manejar excepciones generales
            System.out.println("Error - obtenerListaManga: " + ex.getMessage());
        }

        // Devolver la lista de mangas
        return listaManga;
    }  
    
    // Método para obtener información de un manga por su ID desde la base de datos
    public MangaDTO obtenerMangaPorIDBD(int id){
        try {
            // Establecer la conexión a la base de datos
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();

            // Obtener información principal del manga
            PreparedStatement stmt = conectar.prepareStatement("SELECT * FROM manga WHERE id = " + id);           
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados de la consulta principal
            while (rs.next()) {
                setId(rs.getInt("id"));
                setTitulo(rs.getString("titulo"));
                setPrecio(rs.getInt("precio"));
                setAutorID(rs.getInt("autor_id"));
                setDemografiaID(rs.getInt("demografia_id"));
            }

            // Obtener información sobre los géneros del manga
            rs = stmt.executeQuery("SELECT tipo_genero_id FROM genero WHERE manga_id = " + id);
            while (rs.next()) {
                getGeneros().add(rs.getInt(1));
            }

            // Cerrar recursos de la base de datos
            stmt.close();
            conectar.close();   
        } catch (SQLException ex) {
            // Manejar errores de SQL
            System.out.println("Error SQL - obtenerMangaPorIDBD: "+ex.getMessage());
        } catch (Exception ex) {
            // Manejar errores generales
            System.out.println("Error - obtenerMangaPorIDBD: "+ex.getMessage());
        } 
        // Devolver un objeto MangaDTO con la información obtenida
        return new MangaDTO(this.id, this.titulo, this.precio, this.anio, this.autorID, this.demografiaID, this.generos);
    }   
    
    // Método para eliminar un manga y sus registros asociados por su ID desde la base de datos
    public boolean eliminarManga(int id){
        try {
            // Establecer la conexión a la base de datos
            Conexion conexion = new Conexion();
            Connection conectar = conexion.conectar();
            Statement stmt = conectar.createStatement();  

            // Eliminar registros asociados al manga por su ID en las tablas de género y tomo
            stmt.executeUpdate("DELETE FROM genero WHERE manga_id = " + id);
            stmt.executeUpdate("DELETE FROM tomo WHERE manga_id = " + id);

            // Eliminar el manga por su ID de la tabla principal
            stmt.executeUpdate("DELETE FROM manga WHERE id = " + id);

            // Cerrar recursos de la base de datos
            stmt.close();
            conectar.close();

            // Indicar que la eliminación fue exitosa
            return true;
        } catch (SQLException ex) {
            // Manejar errores de SQL e imprimir un mensaje
            System.out.println("Error SQL - eliminarManga: "+ex.getMessage());

            // Indicar que la eliminación no fue exitosa
            return false;
        } catch (Exception ex) {
            // Manejar errores generales e imprimir un mensaje
            System.out.println("Error - eliminarManga: "+ex.getMessage());

            // Indicar que la eliminación no fue exitosa
            return false;
        }          
    }
    
}