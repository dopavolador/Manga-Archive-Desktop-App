
package mangaarchive.vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import mangaarchive.bd.*;
import mangaarchive.controlador.*;
import mangaarchive.modelo.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

public class Main extends javax.swing.JFrame {

    ArrayList<Integer> generos;
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null); //CENTRA LA VENTANA
        
        //autoCompletar();
        
        new NacionalidadDAO().consultarNacionalidad(cboCountry);
        cboCountry.setSelectedItem("Japón"); //JAPÓN DEFAULT
        new DemografiaDAO().consultarDemografia(cboDemo);
        new TipoGeneroDAO().consultarTipoGenero(cboGenre);
        mostrarManga();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mangaLabel = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        demographicLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        BTNadd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboDemo = new javax.swing.JComboBox<>();
        mangaLabel1 = new javax.swing.JLabel();
        mangaLabel2 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        mangaLabel3 = new javax.swing.JLabel();
        cboCountry = new javax.swing.JComboBox<>();
        txtManga = new javax.swing.JTextField();
        cboGenre = new javax.swing.JComboBox<>();
        btnGeneroAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManga = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnVerTomo = new javax.swing.JButton();
        btnFiltro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MANGA ARCHIVE");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mangaLabel.setText("Manga:");
        jPanel1.add(mangaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 59, -1, -1));

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        jPanel1.add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 157, -1));

        authorLabel.setText("Autor:");
        jPanel1.add(authorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 102, -1, -1));

        demographicLabel.setText("Demografia:");
        jPanel1.add(demographicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        priceLabel.setText("Precio:");
        jPanel1.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 157, -1));

        BTNadd.setText("Ingresar");
        BTNadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNaddActionPerformed(evt);
            }
        });
        jPanel1.add(BTNadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 80, -1));

        jLabel1.setFont(new java.awt.Font("Cascadia Code", 0, 24)); // NOI18N
        jLabel1.setText("MANGA ARCHIVE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, -1, -1));

        cboDemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDemoActionPerformed(evt);
            }
        });
        jPanel1.add(cboDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 160, -1));

        mangaLabel1.setText("Año:");
        jPanel1.add(mangaLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        mangaLabel2.setText("País:");
        jPanel1.add(mangaLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        txtYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearActionPerformed(evt);
            }
        });
        jPanel1.add(txtYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 157, -1));

        mangaLabel3.setText("Genero:");
        jPanel1.add(mangaLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        cboCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCountryActionPerformed(evt);
            }
        });
        jPanel1.add(cboCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 157, -1));

        txtManga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMangaActionPerformed(evt);
            }
        });
        jPanel1.add(txtManga, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 56, 157, -1));

        cboGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGenreActionPerformed(evt);
            }
        });
        jPanel1.add(cboGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 137, 157, -1));

        btnGeneroAdd.setText("+");
        btnGeneroAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneroAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnGeneroAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, 20));

        tblManga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TITULO", "PRECIO", "AÑO", "AUTOR", "DEMOGRAFIA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblManga);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btnVerTomo.setText("Ver tomos");
        btnVerTomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTomoActionPerformed(evt);
            }
        });

        btnFiltro.setText("Filtros");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnVerTomo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnBuscar)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerTomo)
                    .addComponent(btnFiltro))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void btnEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar
        /*
        manga = registroManga.buscarPorId(Integer.parseInt(this.txtxId.getText()));
        if(manga.getId()!=0){
            if(registroManga.eliminarManga(Integer.parseInt(this.txtxId.getText()))){
                JOptionPane.showMessageDialog(rootPane, "manga eliminado","Comprobacion de datos",JOptionPane.INFORMATION_MESSAGE);
                mostrarManga();
            }else{
                JOptionPane.showMessageDialog(rootPane, "No se eliminó manga de la BD", "Comprobación de Datos", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Manga no existe", "Comprobación de Datos", JOptionPane.ERROR_MESSAGE); 
        }
        */
    }//GEN-LAST:event_btnEliminar

    private void BTNaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNaddActionPerformed

        if (camposObligatoriosCompletos()) {
            int autorID;
            AutorDTO autor = new AutorDAO().obtenerAutorPorNombreBD(txtAuthor.getText());

            if (autor != null) {
                autorID = autor.getId();
            }
            else {
                autorID = new Registro().registrarAutorBD(txtAuthor.getText(), cboCountry.getSelectedIndex() + 1);
            }

            if (new Registro().registrarMangaBD(txtManga.getText(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(txtYear.getText()), autorID, cboDemo.getSelectedIndex() + 1, generos) != 0) {
                mostrarMensaje("Comprobación de Datos", "Manga agregado con éxito!!!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                mostrarMensaje("Comprobación de Datos", "No se agregó manga a la BD", JOptionPane.ERROR_MESSAGE);
            }
        }
        mostrarManga();
    }//GEN-LAST:event_BTNaddActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnVerTomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTomoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerTomoActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void cboDemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDemoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDemoActionPerformed

    private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearActionPerformed

    private void cboCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCountryActionPerformed

    private void txtMangaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMangaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMangaActionPerformed

    private void cboGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGenreActionPerformed

    private void btnGeneroAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneroAddActionPerformed

        generos.add(this.cboGenre.getSelectedIndex());
        
    }//GEN-LAST:event_btnGeneroAddActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNadd;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnGeneroAdd;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVerTomo;
    private javax.swing.JComboBox<String> cboCountry;
    private javax.swing.JComboBox<String> cboDemo;
    private javax.swing.JComboBox<String> cboGenre;
    private javax.swing.JLabel demographicLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mangaLabel;
    private javax.swing.JLabel mangaLabel1;
    private javax.swing.JLabel mangaLabel2;
    private javax.swing.JLabel mangaLabel3;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTable tblManga;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtManga;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables

    private void mostrarManga(){
        String titulo, nombreAutor, nombreDemografia;
        int precio, anio;
        
        DefaultTableModel modelo = (DefaultTableModel) this.tblManga.getModel();
        modelo.setRowCount(0);
        ArrayList<MangaDTO> lista = new MangaDAO().obtenerListaManga();
        for (MangaDTO mangaTemp : lista) {
            titulo = mangaTemp.getTitulo();
            precio = mangaTemp.getPrecio();
            anio = mangaTemp.getAnio();
            nombreAutor = new AutorDAO().obtenerAutorPorIDBD(mangaTemp.getAutorID()).getNombre();
            nombreDemografia = new DemografiaDAO().obtenerDemografiaPorIDBD(mangaTemp.getDemografiaID()).getNombre();
            modelo.addRow(new Object[]{titulo, precio, anio, nombreAutor, nombreDemografia});
        }
    }
    
    private void mostrarMensaje(String titulo, String mensaje, int tipoMensaje) {
        JOptionPane.showMessageDialog(rootPane, mensaje, titulo, tipoMensaje);
    }
    
    private boolean camposObligatoriosCompletos() {
        if (txtManga.getText().isBlank() || txtAuthor.getText().isBlank() || txtPrice.getText().isBlank() || txtYear.getText().isBlank()) {
            mostrarMensaje("Comprobación de Datos", "Todos los campos obligatorios deben estar llenos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /*
    // Esta a medias
    private void autoCompletar(){
        try{
            JList listaSugerencias = new JList(new AutorDAO().obtenerListaNombreAutor());
            AutoCompleteDecorator.decorate(listaSugerencias,this.txtAuthor,ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    */
}