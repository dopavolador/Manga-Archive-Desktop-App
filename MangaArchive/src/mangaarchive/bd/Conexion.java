/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangaarchive.bd;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro Mora Y Bastian Heresmann
 */

public class Conexion implements Credenciales {
    
    Connection conectar = null;
    
    public Connection conectar()
    {
        try
        {
            Class.forName(DRIVER);
            conectar=DriverManager.getConnection(URL,USUARIO,CLAVE);
            JOptionPane.showMessageDialog(null, "Conexion exitosa", "Conexion", JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Sin Conexion"+e, "Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return conectar;
    }
    
}