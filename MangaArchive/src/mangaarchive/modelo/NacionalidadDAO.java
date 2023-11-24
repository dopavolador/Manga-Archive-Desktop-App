/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import mangaarchive.bd.Conexion;

/**
 *
 * @author Emilia
 */
public class NacionalidadDAO {
    private int id;
    private char iso;
    private String pais, gentilicio;

    public NacionalidadDAO() {
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
    
    public void consultarNacionalidad(JComboBox combo)
    {
        try (Connection conectar = new Conexion().conectar();
             PreparedStatement stmt = conectar.prepareStatement("SELECT pais FROM nacionalidad");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                combo.addItem(rs.getString("pais"));
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
