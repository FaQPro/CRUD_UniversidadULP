/*

 */
package universidadAPP;

import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import accesoAdatos.AlumnoData;
import static java.lang.String.valueOf;
import universidadAPP.Entidades.Ealumno;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 
 */
public class Formularioalumno extends javax.swing.JInternalFrame {
    
    private Connection con=null;
    AlumnoData datosAlumno=new AlumnoData();
    Ealumno alumno = new Ealumno();
    
    
    
    public Formularioalumno() {
        initComponents();
    }
    
 
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
        jtnombre = new javax.swing.JTextField();
        jbeliminar = new javax.swing.JButton();
        jbguardar = new javax.swing.JButton();
        jbnuevo = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();
        jbbuscar = new javax.swing.JButton();
        jCestado = new javax.swing.JComboBox<>();
        jRestado = new javax.swing.JRadioButton();
        jDfecha = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Alumno");

        jlapellido.setText("Apellido :");

        jlDNI.setText("Documento :");

        jlnombre.setText("Nombre :");

        jLabel5.setText("Estado :");

        jLabel6.setText("Fecha de Nacimiento :");

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

        jCestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));

        jRestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRestadoActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jbnuevo)
                                .addGap(18, 18, 18)
                                .addComponent(jbeliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jbguardar)
                                .addGap(26, 26, 26)
                                .addComponent(jbsalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(57, 57, 57)
                                .addComponent(jRestado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbbuscar)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRestado)
                    .addComponent(jCestado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jDfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jbeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbeliminarActionPerformed

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        
      try {
            Integer dni=Integer.parseInt(jtDNI.getText());
            String nombre=jtnombre.getText();
            String apellido=jtapellido.getText();
            if (nombre.isEmpty()|| apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "no deje campos vacios ");
                return;
            }
            java.util.Date fechaNac=jDfecha.getDate();
            LocalDate fechaNacimiento=fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Boolean estado=jRestado.isSelected();
            
            alumno=new Ealumno(dni,apellido,nombre,fechaNacimiento,estado);
            datosAlumno.modificarAlumno(alumno);
            
 
        } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "debe ingresar un dni valido");
           
        }
      limpiarCampos();
   
        
        
    // PARA ESTADO POR COMBOBOX
     /*String estado = jCestado.getSelectedItem().toString();
        if (estado.equals("activo")) {
            alumno.setEstado(true);
        }else alumno.setEstado(false);
        */
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jbnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnuevoActionPerformed

        try {
            Integer dni=Integer.parseInt(jtDNI.getText());
            String nombre=jtnombre.getText();
            String apellido=jtapellido.getText();
            if (nombre.isEmpty()|| apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "no deje campos vacios ");
                return;
            }
            java.util.Date fechaNac=jDfecha.getDate();
            LocalDate fechaNacimiento=fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Boolean estado=jRestado.isSelected();
             alumno.setDni(dni);
             alumno.setApellido(apellido);
             alumno.setNombre(nombre);
             alumno.setFechaNacimiento(fechaNacimiento);
               
        
             datosAlumno.guardarAlumno(alumno);
                 } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "algun dato es invalido -REVISE POR FAVOR-");
                 }
     limpiarCampos();
     
        
    }//GEN-LAST:event_jbnuevoActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jbbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbuscarActionPerformed
       AlumnoData datosAlumno=new AlumnoData();
        Ealumno alumno = new Ealumno();
     try{   
        Integer dni=Integer.parseInt(jtDNI.getText());
        alumno=datosAlumno.buscarAlumnoPorDni(dni);
        if(alumno!=null){
            
            jtapellido.setText(alumno.getApellido());
            jtnombre.setText(alumno.getNombre());
            jRestado.setSelected(alumno.isEstado());
              //ACTIVO CON COMBOBOX
            //jCestado.setSelectedIndex(alumno.isEstado());
            /*String estado = jCestado.getSelectedItem().toString();
            if (estado.equals("activo")) {
            alumno.setEstado(true);
            }else alumno.setEstado(false);*/
            LocalDate lc= alumno.getFechaNacimiento();
            java.util.Date date=java.util.Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
            jDfecha.setDate(date);
        }
        
        }catch(NumberFormatException err) {
     
         JOptionPane.showMessageDialog(this, "Debe ingresar un numero valido ");
     
     }
        
        
    }//GEN-LAST:event_jbbuscarActionPerformed

    private void jRestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRestadoActionPerformed

    private void limpiarCampos(){
    
        jtDNI.setText("");
        jtapellido.setText("");
        jtnombre.setText("");
        jRestado.setSelected(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCestado;
    private com.toedter.calendar.JDateChooser jDfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRestado;
    private javax.swing.JButton jbbuscar;
    private javax.swing.JButton jbeliminar;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbnuevo;
    private javax.swing.JButton jbsalir;
    private javax.swing.JLabel jlDNI;
    private javax.swing.JLabel jlapellido;
    private javax.swing.JLabel jlnombre;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtapellido;
    private javax.swing.JTextField jtnombre;
    // End of variables declaration//GEN-END:variables
}
