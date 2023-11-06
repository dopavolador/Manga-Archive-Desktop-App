/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

/**
 *
 * @author Alvaro Mora y Bastian Heresmann
 */
public class Tomo {
    
    private int mangaID,tomoNum,stock;
    
    public Tomo(){}
    
    public Tomo(int mangaID, int tomoNum, int stock){
        this.mangaID = mangaID;
        this.tomoNum = tomoNum;
        this.stock = stock;
    }

    public int getMangaID() {
        return mangaID;
    }

    public void setMangaID(int mangaID) {
        this.mangaID = mangaID;
    }

    public int getTomoNum() {
        return tomoNum;
    }

    public void setTomoNum(int tomoNum) {
        this.tomoNum = tomoNum;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Tomo{" + "mangaID=" + mangaID + ", tomoNum=" + tomoNum + ", stock=" + stock + '}';
    }
    
}