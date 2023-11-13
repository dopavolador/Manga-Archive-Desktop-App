/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

/**
 *
 * @author Alvaro Mora y Bastian Heresmann
 */
public class Manga {
    
    private int id,precio,autorID,demografiaID;
    private String titulo;
    
    public Manga(){
        id=0;
    }
    
    public Manga(int id, String titulo, int precio, int autorID, int demografiaID){
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.autorID = autorID;
        this.demografiaID = demografiaID;
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

    @Override
    public String toString() {
        return "Manga{" + "id=" + id + ", precio=" + precio + ", autorID=" + autorID + ", demografiaID=" + demografiaID + ", titulo=" + titulo + '}';
    }
    
}