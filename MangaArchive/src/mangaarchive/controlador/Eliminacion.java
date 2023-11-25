/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.controlador;

import mangaarchive.modelo.MangaDAO;

/**
 *
 * @author Emilia
 */
public class Eliminacion {
    
    public boolean eliminarMangaBD(int id){
        MangaDAO manga = new MangaDAO();
        return manga.eliminarManga(id);
    }
    
}
