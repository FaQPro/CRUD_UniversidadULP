/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadAPP;

import accesoAdatos.Coneccion;        
import accesoAdatos.AlumnoData;
import accesoAdatos.MateriaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import accesoAdatos.InscripcionData;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import universidadAPP.Entidades.Ealumno;
/**
 *
 * @author perey
 */
public class CargadeNotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form CargadeNotas
     */
     private Connection con = null;
      private DefaultTableModel formatoTabla = new DefaultTableModel();
    public CargadeNotas() {
        initComponents();
         limpioForm();
        cargoListaAlu();
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
        jLabel2 = new javax.swing.JLabel();
        jcbSalumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbguardar = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();
        ApeNom = new javax.swing.JLabel();

        jLabel1.setText("Carga de Notas");

        jLabel2.setText("Selecciones un alumno :");

        jcbSalumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbSalumnoMouseClicked(evt);
            }
        });
        jcbSalumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSalumnoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Nota"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jbguardar.setText("Guardar");

        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbSalumno, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApeNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jbguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbsalir)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbSalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApeNom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbguardar)
                    .addComponent(jbsalir))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbsalirActionPerformed

    private void jcbSalumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSalumnoActionPerformed
        // TODO add your handling code here:
        
           List<String> materias = new ArrayList<String>();
       String aux=jcbSalumno.getSelectedItem().toString() ;
       String auxid =aux.substring(0,1);
        System.out.println(""+auxid);
       for (int i=1 ; i<=3 ; i++){
           if(aux.substring(i,1).equals("-")) {
               
           }else {
               auxid=auxid.concat(aux.substring(i, 1));
           }
           
       }
       String sql ="SELECT materia.idMateria, materia.nombre, inscripcion.nota from materia "
                  + "JOIN inscripcion ON (materia.idMateria=inscripcion.idMateria) WHERE inscripcion.idAlumno=?";
             try {
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
              ps.setInt(1, Integer.parseInt(auxid));
                ResultSet rs = ps.executeQuery();
                 String materia;
            while (rs.next()) {
               // materia = new Materia();
                formatoTabla.addRow(new Object[]{rs.getInt("idMateria"),rs.getString("nombre"),rs.getInt("nota")});
               
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener Inscripciones."+ex.getMessage());

}
    }//GEN-LAST:event_jcbSalumnoActionPerformed

    private void jcbSalumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbSalumnoMouseClicked
//        List<String> materias = new ArrayList<String>();
//       String aux=jcbSalumno.getSelectedItem().toString() ;
//       String auxid =aux.substring(0,1);
//        System.out.println(""+auxid);
//       for (int i=1 ; i<=3 ; i++){
//           
//           
//       }
           
       
//        auxid=jcbSalumno.getSelectedItem();
//        System.out.println("id"auxid);
          /* String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
                    + " materia WHERE inscripcion.idMateria = materia.idMaterialn"
                    + "AND inscripcion.idAlumno = ?;";*/
          String sql ="SELECT materia.idMateria, materia.nombre, inscripcion.nota from materia "
                  + "JOIN inscripcion ON (materia.idMateria=inscripcion.idMateria) WHERE inscripcion.idAlumno=?";
//             try {
//                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//              ps.setInt(1, auxid.hashCode());
//                ResultSet rs = ps.executeQuery();
//                 String materia;
//            while (rs.next()) {
//               // materia = new Materia();
//                formatoTabla.addRow(new Object[]{rs.getInt("idMateria"),rs.getString("nombre"),rs.getInt("nota")});
//               
//            }
//
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Error al obtener Inscripciones."+ex.getMessage());
//
//}


        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSalumnoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApeNom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbsalir;
    private javax.swing.JComboBox<String> jcbSalumno;
    // End of variables declaration//GEN-END:variables


    public void cargoListaAlu(){

      int  auxid;

        AlumnoData alu=new AlumnoData();
        
ArrayList<Ealumno> listadoAlumnoCombo=new ArrayList<>();
 MateriaData mat=new MateriaData();
//int idMat=mat.devuelveIdMateria(mat.MateriasTodas().toString());
listadoAlumnoCombo=(ArrayList<Ealumno>) alu.ListarAlumnosidape();
        for (Ealumno alux : listadoAlumnoCombo){
    String item = alux.getIdAlumno()+" -"+alux.getApellido();
             
    jcbSalumno.addItem(item);
}
    }
    
private void formatoTabla(){
    formatoTabla.addColumn("Codigo");
    formatoTabla.addColumn("Nombre");
    formatoTabla.addColumn("Nota");
   
    jTable1.setModel(formatoTabla);
                    
}
    public void limpioForm(){
    jcbSalumno.removeAllItems();
  formatoTabla.setNumRows(0);
    formatoTabla();
}
}