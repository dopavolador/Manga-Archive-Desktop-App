/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

/**
 *
 * @author Alvaro Mora y Bastian Heresmann
 */
public class GeneroDTO {
    private int mangaID,tipoGeneroID;
    
    public GeneroDTO(){}
    
    public GeneroDTO(int mangaID, int tipoGeneroID){
        this.mangaID = mangaID;
        this.tipoGeneroID = tipoGeneroID;
    }

    public int getMangaID() {
        return mangaID;
    }

    public void setMangaID(int mangaID) {
        this.mangaID = mangaID;
    }

    public int getTipoGeneroID() {
        return tipoGeneroID;
    }

    public void setTipoGeneroID(int tipoGeneroID) {
        this.tipoGeneroID = tipoGeneroID;
    }

    @Override
    public String toString() {
        return "TipoGenero{" + "mangaID=" + mangaID + ", tipoGeneroID=" + tipoGeneroID + '}';
    }
    
}