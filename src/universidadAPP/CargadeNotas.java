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
import javax.swing.table.TableColumnModel;
import universidadAPP.Entidades.Ealumno;
import universidadAPP.Entidades.Inscripcion;
import universidadAPP.Entidades.Materia;
import universidadAPP.Entidades.MateriasYnotas;
/**
 *
 * @author perey
 */
public class CargadeNotas extends javax.swing.JInternalFrame {

    /**
     * Creates new form CargadeNotas
     */
    InscripcionData Insc= new InscripcionData();
     private Connection con = null;
      private DefaultTableModel formatoTabla;
      
      
    public CargadeNotas() {
        this.formatoTabla = new DefaultTableModel(){
            public boolean isCellEditable(int fila, int columna){
                if (columna==2){
                    return true;
                }
                return false;
                
                
            }
            
            
        };
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbguardar = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();
        ApeNom = new javax.swing.JLabel();
        jTdni = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTapellido = new javax.swing.JTextField();

        jLabel1.setText("Carga de Notas");

        jLabel2.setText("Ingrese DNI del Alumno:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Nota"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jbguardar.setText("Guardar Cambios");
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });

        jbsalir.setText("Salir");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido:");

        jTapellido.setEditable(false);
        jTapellido.setBackground(new java.awt.Color(228, 211, 211));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jbguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbsalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(132, 132, 132)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTdni, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApeNom)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ApeNom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Validaciones
        String tdni=jTdni.getText();
        int dni=0;
        if (tdni.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar un Dni");
            return;
        }
              
        try{
        dni=Integer.parseInt(tdni);
        }catch (NumberFormatException n){
            JOptionPane.showMessageDialog(this, "Ingrese sólo números");
            jTdni.setText(null);
            jTdni.requestFocus();
            return;       
        }      
        //PRIMERO, VOY A OBTENER EL ID DEL ALUMNO A TRVES DE DNI
        
        //creo un objeto tipo AlumnoData para acceder a sus metodos
        AlumnoData alu=new AlumnoData();
        InscripcionData insc=new InscripcionData();
               
        Ealumno alumno=new Ealumno();
        alumno=alu.buscarAlumnoPorDni(dni);
        jTapellido.setText(alumno.getApellido());
        
        //Obtengo el id del alumno
        int idAlu=alumno.getIdAlumno();
        //obtengo un array con las materias y las notas del alumno y la cargo en el Jtable
        ArrayList<MateriasYnotas> lista=new ArrayList<>();
        lista=insc.obtenerDatosAlumnoNota(idAlu);
        for(MateriasYnotas m:lista){
             formatoTabla.addRow(new Object[]{m.getIdMateria(),m.getNombre(),m.getNota()});
           }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
    
    
    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //int filaSeleccionada=jTable1.getSelectedRow();
        //int nota=(Integer) formatoTabla.getValueAt(filaSeleccionada,2);
    
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        // TODO add your handling code here:
        //Este metodo va a recorrer la tabla y hacer un update por cada fila
        
        //Valido que haya algo en la tabla
        int filas=jTable1.getRowCount();
        if (filas==0){
            JOptionPane.showMessageDialog(this, "La tabla está vacia, busque un alumno primero");
            return;
                    
        }
        //Valido que las notas sean correctas
        if (validoNotas()==false){
            JOptionPane.showMessageDialog(this,"Revise sólo se acepta numeros entre 0 y 10");
            return;
                    
        }
        
        
        
        
        AlumnoData alu=new AlumnoData();
        InscripcionData insc=new InscripcionData();
        int dni=Integer.parseInt(jTdni.getText());
        Ealumno alumno=new Ealumno();
        alumno=alu.buscarAlumnoPorDni(dni);
       //Obtengo el id del alumno
        int idAlu=alumno.getIdAlumno();
        int cantFilas=formatoTabla.getRowCount();
        int nota;
        int idmat;
                Object notaTabla;
        Object idTabla;
        String NotaSt;
        String idSt;
        for (int i=0;i<cantFilas;i++){
            idTabla=formatoTabla.getValueAt(i,0);
            notaTabla=formatoTabla.getValueAt(i, 2);
            NotaSt=notaTabla.toString();
            idSt=idTabla.toString();
            nota=Integer.parseInt(NotaSt);
            idmat=Integer.parseInt(idSt);
                
        //    System.out.println("IdMat:" + idMat);
        //    System.out.println("nota:"+nota);
            insc.actualizarNota(idAlu, idmat, nota);
                     
        }
        JOptionPane.showMessageDialog(this,"Datos Modificados con éxito");
        
        
        
        
        
        
    }//GEN-LAST:event_jbguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApeNom;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTapellido;
    private javax.swing.JTextField jTdni;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbsalir;
    // End of variables declaration//GEN-END:variables


    public void cargoListaAlu(){
        int auxid;
        AlumnoData alu=new AlumnoData();
        ArrayList<Ealumno> listadoAlumnoCombo=new ArrayList<>();
        MateriaData mat=new MateriaData();
        //int idMat=mat.devuelveIdMateria(mat.MateriasTodas().toString());
        listadoAlumnoCombo=(ArrayList<Ealumno>) alu.ListarAlumnosidape();
        for (Ealumno alux : listadoAlumnoCombo){
        //jcbSalumno.addItem(new Object[]{alux.getIdAlumno(),alux.getApellido()});
        
}
    }
    
private void formatoTabla(){
    formatoTabla.addColumn("Codigo");
    formatoTabla.addColumn("Nombre");
    formatoTabla.addColumn("Nota (Doble Click Edita ");
    jTable1.setModel(formatoTabla);
                    
}
    public void limpioForm(){
   
  formatoTabla.setNumRows(0);
    formatoTabla();
}
    public boolean validoNotas(){
        Object notaTabla;
        String notaSt;
        int nota=0;
        int filas=jTable1.getRowCount();
        for (int i=0; i<filas;i++){
            notaTabla=formatoTabla.getValueAt(i,2);
            notaSt=notaTabla.toString();
            try{
            nota=Integer.parseInt(notaSt);
            }catch (NumberFormatException n){
                
                return false;
            }
            if (nota<=0 || nota>10){
                
                return false;
            }         
            
        }
        return true;
        
        
        
        
        
    }
    
    
}