/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAdatos;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadAPP.Entidades.Inscripcion;
import accesoAdatos.MateriaData;
import accesoAdatos.AlumnoData;
import java.sql.ResultSet;
import universidadAPP.Entidades.Materia;

/**
 *
 * @author perey
 */
public class InscripcionData {

    private Connection con = null;
    private AlumnoData alumD = new AlumnoData();
    private MateriaData matD = new MateriaData();
    public InscripcionData() {
        con = Coneccion.getConnection();
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        
       ArrayList<Inscripcion> actuales = new ArrayList<>();
       String sql ="SELECT * FROM inscripcion";
       
       
        try {
            PreparedStatement ps= (PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Inscripcion insc=new  Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripto"));
            //    Alumno alu=alumD.buscarAlumno(rs.getInt("idAlumno")); aguardo metodo buscar alumno
            //    Materia mat = matD.buscarMateria(rs.getInt("idMateria")) ; aguardo metodo buscar materia
           // insc.setAlumno(alu);
          //  insc.setMateria(mat);
            insc.setNota(rs.getDouble("nota"));
            actuales.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en conexion a Base de Datos");
        }
        return actuales;
        
    }
   /* public List <Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();

        try {
            String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
                    + " materia WHERE inscripcion.idMateria = materia.idMaterialn"
                    + "AND inscripcion.idAlumno = ?;";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materias.add(materia);

            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener Inscripciones."+ex.getMessage());

}

return materias;
    }
*/
    public void guardarInscripcion(Inscripcion insc){
        try {
            String sql = "INSERT INTO inscripcion(idAlumno , idMateria,nota)VALUES (?,?,?)";
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,insc.getAlumno().getIdAlumno());
            ps.setInt(2,insc.getMateria().getIdMateria());
            ps.setDouble(3,insc.getNota());
            ps.executeUpdate();
            ResultSet rs;
                 rs=ps.getGeneratedKeys();
           if (rs.next()){
              insc.setIdInscripto(rs.getInt(1));
              JOptionPane.showMessageDialog(null,"Inscripcion realizada con exito");
               
           } 
           ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la Base de Datos");
        }
        
        
    }
    public void borrarInscripcionMateriaAlumno(int idAlumno,int idMateria){
        
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ?";
           PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
           ps.setInt(1, idAlumno);
           ps.setInt(2, idMateria);
           int aux = ps.executeUpdate();
           if (aux>0){
               JOptionPane.showMessageDialog(null,"Inscripcion borrada con exito");
               
               
           }
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la Base de Datos");
        } 
            
        
        
    }
    
    public void actualizarNota(int idAlumno,int idMateria,double nota){
        
        try {
            String sql="UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setDouble(1,nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
           int filas = ps.executeUpdate();
           
           if (filas>0){
               
               JOptionPane.showMessageDialog(null,"Nota actualizada con exito");
               
               
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la Base de Datos");
        }
        
    }

    
}
