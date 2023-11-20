/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

/**
 *
 * @author Alvaro Mora y Bastian Heresmann
 */
public class NacionalidadDTO {
    
    private int id;
    private char iso;
    private String pais,gentilicio;
    
    public NacionalidadDTO(){}

    public NacionalidadDTO(int id, char iso, String pais, String gentilicio) {
        this.id = id;
        this.iso = iso;
        this.pais = pais;
        this.gentilicio = gentilicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getIso() {
        return iso;
    }

    public void setIso(char iso) {
        this.iso = iso;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGentilicio() {
        return gentilicio;
    }

    public void setGentilicio(String gentilicio) {
        this.gentilicio = gentilicio;
    }

    @Override
    public String toString() {
        return "Nacionalidad{" + "id=" + id + ", iso=" + iso + ", pais=" + pais + ", gentilicio=" + gentilicio + '}';
    }
    
}