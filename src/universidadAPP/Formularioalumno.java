/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadAPP;

/**
 *
 * @author perey
 */
public class Formularioalumno extends javax.swing.JInternalFrame {

    /**
     * Creates new form Formularioalumno
     */
    public Formularioalumno() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlapellido = new javax.swing.JLabel();
        jlDNI = new javax.swing.JLabel();
        jlnombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jtapellido = new javax.swing.JTextField();
        jtFnacimiento = new javax.swing.JTextField();
        jtnombre = new javax.swing.JTextField();
        jrestado = new javax.swing.JRadioButton();
        jbeliminar = new javax.swing.JButton();
        jbguardar = new javax.swing.JButton();
        jbnuevo = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();
        jbbuscar = new javax.swing.JButton();

        jLabel1.setText("Alumno");

        jlapellido.setText("Apellido :");

        jlDNI.setText("Documento :");

        jlnombre.setText("Nombre :");

        jLabel5.setText("Estado :");

        jLabel6.setText("Fecha de Nacimiento :");

        jrestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrestadoActionPerformed(evt);
            }
        });

        jbeliminar.setText("Eliminar");
        jbeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeliminarActionPerformed(evt);
            }
        });

        jbguardar.setText("Guardar");
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });

        jbnuevo.setText("Nuevo");
        jbnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnuevoActionPerformed(evt);
            }
        });

        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });

        jbbuscar.setText("Buscar");
        jbbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlapellido)
                            .addComponent(jlnombre)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtFnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jbnuevo)
                                .addGap(18, 18, 18)
                                .addComponent(jbeliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jbguardar)
                                .addGap(26, 26, 26)
                                .addComponent(jbsalir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrestado)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbbuscar)
                                .addGap(26, 26, 26)))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jlDNI)
                    .addContainerGap(354, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbbuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlapellido)
                    .addComponent(jtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlnombre)
                    .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrestado))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtFnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbeliminar)
                    .addComponent(jbguardar)
                    .addComponent(jbnuevo)
                    .addComponent(jbsalir))
                .addGap(15, 15, 15))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(jlDNI)
                    .addContainerGap(327, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrestadoActionPerformed

    private void jbeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbeliminarActionPerformed

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jbnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnuevoActionPerformed
        

// TODO add your handling code here:
    }//GEN-LAST:event_jbnuevoActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jbbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbbuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbbuscar;
    private javax.swing.JButton jbeliminar;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbnuevo;
    private javax.swing.JButton jbsalir;
    private javax.swing.JLabel jlDNI;
    private javax.swing.JLabel jlapellido;
    private javax.swing.JLabel jlnombre;
    private javax.swing.JRadioButton jrestado;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtFnacimiento;
    private javax.swing.JTextField jtapellido;
    private javax.swing.JTextField jtnombre;
    // End of variables declaration//GEN-END:variables
}
