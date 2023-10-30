

package mangaarchive.vista;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    
    private JTabbedPane tabbedPane;
    private JPanel panelAgregar, panelModificar, panelEliminar, panelListar;

    public Main() {
        setTitle("MANGA ARCHIVE");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        panelAgregar = new JPanel();
        panelAgregar.add(new JLabel("Agregar formulario aquí"));

        panelModificar = new JPanel();
        panelModificar.add(new JLabel("Modificar formulario aquí"));

        panelEliminar = new JPanel();
        panelEliminar.add(new JLabel("Eliminar formulario aquí"));

        panelListar = new JPanel();
        panelListar.add(new JLabel("Listado de productos aquí"));

        tabbedPane.addTab("Agregar", panelAgregar);
        tabbedPane.addTab("Modificar", panelModificar);
        tabbedPane.addTab("Eliminar", panelEliminar);
        tabbedPane.addTab("Listar", panelListar);

        add(tabbedPane, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.setVisible(true);
    }
}