/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.controlador;

import java.util.ArrayList;
import mangaarchive.modelo.MangaDAO;

/**
 *
 * @author Emilia
 */
public class Actualizacion {
    
    public boolean actualizarMangaBD(String titulo, int precio, int anio, int autorID, int demografiaID, ArrayList<Integer> generos){
        MangaDAO manga = new MangaDAO(titulo,precio,anio,autorID,demografiaID,generos);
        return manga.modificarManga();
   }  
    
}