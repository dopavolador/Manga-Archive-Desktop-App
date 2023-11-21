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
    
    
    public boolean registrarMangaBD(int precio, int autorID, int demografiaID, String titulo, ArrayList<Integer> generos){
       return new MangaDAO(precio, autorID, demografiaID, titulo, generos).registrarMangaBD();
   }   
    
    
}
