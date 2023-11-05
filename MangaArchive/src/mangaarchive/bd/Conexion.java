/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.bd;

import java.sql.*;
import javax.swing.JOptionPane;
import mangaarchive.controlador.*;

/**
 *
 * @author ASUS-TUF-GAMING
 */
public class Conexion {
    
    Connection conectar = null;
    
    public Connection conectar(){
        try{
            Class.forName(Credenciales.DRIVER);
            conectar=DriverManager.getConnection(Credenciales.URL,Credenciales.USUARIO,Credenciales.CLAVE);
            JOptionPane.showMessageDialog(null, "Conexion exitosa", "Conexion", JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Sin Conexion"+e, "Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return conectar;
    }
    
}