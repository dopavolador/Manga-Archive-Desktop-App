/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

/**
 *
 * @author Alvaro Mora y Bastian Heresmann
 */
public class Demografia {
    private int id;
    private String nombre;
    
    public Demografia(){}

    public Demografia(int id, String nombre) {
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

    @Override
    public String toString() {
        return "Demografia{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}