/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

import java.util.ArrayList;

/**
 *
 * @author Alvaro Mora y Bastian Heresmann
 */
public class MangaDTO {
    
    private int id, precio, autorID, demografiaID,anio;
    private String titulo;
    ArrayList<Integer> generos;

    public MangaDTO(int id, String titulo, int precio, int anio, int autorID, int demografiaID, ArrayList<Integer> generos){
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.anio = anio;
        this.autorID = autorID;
        this.demografiaID = demografiaID;
        this.generos = generos;
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
    
    @Override
    public String toString() {
        return "Manga{" + "id=" + id + ", precio=" + precio + ", autorID=" + autorID + ", demografiaID=" + demografiaID + ", titulo=" + titulo + '}';
    }
    
}