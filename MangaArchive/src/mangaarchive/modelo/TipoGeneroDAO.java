/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import mangaarchive.bd.Conexion;

/**
 *
 * @author Emilia
 */
public class TipoGeneroDAO {
    
    private int id;
    private String nombre;

    public TipoGeneroDAO() {
    }

    public TipoGeneroDAO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<TipoGeneroDTO> listarTipoGenero() {
        ArrayList<TipoGeneroDTO> listaTipoGenero = new ArrayList<>();

        try (Connection conectar = new Conexion().conectar();
             PreparedStatement stmt = conectar.prepareStatement("SELECT * FROM tipo_genero Order by id");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                setId(rs.getInt("id"));
                setNombre(rs.getString("nombre"));
                listaTipoGenero.add(new TipoGeneroDTO(this.getId(), this.getNombre()));
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL - listarTipoGeneros: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error - listarTipoGeneros: " + ex.getMessage());
        }

        return listaTipoGenero;
    }
    
    public void consultarTipoGenero(JComboBox combo)
    {
        try (Connection conectar = new Conexion().conectar();
             PreparedStatement stmt = conectar.prepareStatement("SELECT nombre FROM tipo_genero");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                combo.addItem(rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
