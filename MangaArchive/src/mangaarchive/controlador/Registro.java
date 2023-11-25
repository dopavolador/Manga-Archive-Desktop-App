/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.controlador;

import java.util.ArrayList;
import mangaarchive.modelo.*;

/**
 *
 * @author Emilia
 */
public class Registro {
    
    public int registrarMangaBD(String titulo, int precio, int anio, int autorID, int demografiaID, ArrayList<Integer> generos){
        MangaDAO manga = new MangaDAO(titulo,precio,anio,autorID,demografiaID,generos);
        return manga.registrarMangaBD();
   }   
    
    public int registrarAutorBD(String nombre, int nacionalidadID) {
        AutorDAO autor = new AutorDAO(nombre, nacionalidadID);
        return autor.registrarAutorBD();
    }
    
}
