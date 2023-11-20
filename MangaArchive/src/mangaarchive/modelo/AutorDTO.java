/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

/**
 *
 * @author Alvaro Mora y Bastian Heresmann
 */
public class AutorDTO {
    
    private int id, nacionalidadID;
    private String nombre;
      
    public AutorDTO(int id, String nombre, int nacionalidadID){
        this.id = id;
        this.nombre = nombre;
        this.nacionalidadID = nacionalidadID;
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

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nacionalidadID=" + nacionalidadID + ", nombre=" + nombre + '}';
    }
    
}