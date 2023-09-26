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
import universidadAPP.Alumno;
import universidadAPP.Entidades.Ealumno;
import universidadAPP.Entidades.Materia;
import universidadAPP.Entidades.MateriasYnotas;


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
       String sqla="SELECT idAlumno FROM alumno";
       String sqlm="SELECT idMateria FROM materia";
          Ealumno alu = null;
          Materia mat=null;
        try {
            PreparedStatement ps= (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement psa= (PreparedStatement) con.prepareStatement(sqla);
            PreparedStatement psm= (PreparedStatement) con.prepareStatement(sqlm);
            
            ResultSet rs=ps.executeQuery();
            ResultSet rsa=psa.executeQuery();
            ResultSet rsm=psm.executeQuery();
            while (rs.next()){
                Inscripcion insc=new  Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripto"));
                if(rsa.next()){
                 alu.setIdAlumno(rsa.getInt("idAlumno"));
                
                }
                if(rsm.next()){
                 mat.setIdMateria(rsm.getInt("idMateria"));
                }
            //    Alumno alu=alumD.buscarAlumno(rs.getInt("idAlumno")); aguardo metodo buscar alumno
            //    Materia mat = matD.buscarMateria(rs.getInt("idMateria")) ; aguardo metodo buscar materia
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("nota"));
            actuales.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en conexion a Base de Datos");
        }
        return actuales;
        
    }
    public List <Materia> obtenerMateriasCursadas(int idAlumno) {
      List<Materia> materias = new ArrayList<Materia>();
 List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
       
          /* String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
                    + " materia WHERE inscripcion.idMateria = materia.idMaterialn"
                    + "AND inscripcion.idAlumno = ?;";*/
          String sql ="SELECT materia.idMateria, materia.nombre, inscripcion.nota from materia "
                  + "JOIN inscripcion ON (materia.idMateria=inscripcion.idMateria) WHERE inscripcion.idAlumno=?";
             try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
        Materia materia;
        Inscripcion insc;
            while (rs.next()) {
                insc=new Inscripcion();
               materia = new Materia();
               insc.setNota(idAlumno);
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
               // materia.setAño(rs.getInt("año"));
                materias.add(materia);
               inscripciones.add(insc);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener Inscripciones."+ex.getMessage());

}

return materias;
    }
    
    public List<Materia> obtenerMateriasNocursadas(int idAlumno){
        
        ArrayList<Materia> materias=new ArrayList<>();
        
        String sql ="SELECT * FROM materia WHERE estado=1 AND idMateria not in"
                +"(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
        
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
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
       
    public List<Ealumno> obtenerAlumnosporMateria(int idMateria){
        
        
            ArrayList<Ealumno> aluMateria = new ArrayList<>();
            
           // String sql ="SELECT a.idAlumno, dni , nombre , apellido , fechaNacimiento , estado"
             //       + "FROM inscripcion i ,alumno a WHERE i.idAlumno = a.idAlumno AND idMateria=? AND a.estado =1";
             
          String sql = "SELECT alumno.idAlumno, alumno.dni, alumno.nombre, alumno.apellido, alumno.fechaNacimiento, alumno.estado FROM alumno JOIN inscripcion ON (alumno.idAlumno=inscripcion.idAlumno) WHERE inscripcion.idMateria=?";
   
             
          try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql) ;
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            Ealumno alumno;
            while (rs.next()){
                alumno=new Ealumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                aluMateria.add(alumno);
            }
                    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de Coneccion con la Base de Datos ");
        }
          return aluMateria;
    }
    
    

     public List<Inscripcion> obtenerInscripcionesporAlumno(int idAlumno){
        
       ArrayList<Inscripcion> actuales = new ArrayList<>();
       String sql ="SELECT * FROM inscripcion WHERE idAlumnmo=?";
       String sqla="SELECT idAlumno FROM alumno";
       String sqlm="SELECT idMateria FROM materia";
          Ealumno alu = null;
          Materia mat=null;
        try {
            PreparedStatement ps= (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement psa= (PreparedStatement) con.prepareStatement(sqla);
            PreparedStatement psm= (PreparedStatement) con.prepareStatement(sqlm);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            ResultSet rsa=psa.executeQuery();
            ResultSet rsm=psm.executeQuery();
            while (rs.next()){
                Inscripcion insc=new  Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripto"));
                if(rsa.next()){
                 alu.setIdAlumno(rsa.getInt("idAlumno"));
                
                }
                if(rsm.next()){
                 mat.setIdMateria(rsm.getInt("idMateria"));
                }
            //    Alumno alu=alumD.buscarAlumno(rs.getInt("idAlumno")); aguardo metodo buscar alumno
            //    Materia mat = matD.buscarMateria(rs.getInt("idMateria")) ; aguardo metodo buscar materia
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getDouble("nota"));
            actuales.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en conexion a Base de Datos");
        }
        return actuales;
     }
     
     
    
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
    
    public void actualizarNota(int idAlumno,int idMateria,int nota){
        
        try {
            String sql="UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
           int filas = ps.executeUpdate();
           
           if (filas>0){
               
               //JOptionPane.showMessageDialog(null,"Nota actualizada con exito");
               
               
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la Base de Datos");
        }
        
    }

    public ArrayList<MateriasYnotas> obtenerDatosAlumnoNota(int idAlumno){
        String sql="SELECT materia.idMateria,materia.nombre, inscripcion.nota from materia join inscripcion on (materia.idMateria=inscripcion.idMateria) WHERE inscripcion.idAlumno=?";
        ArrayList<MateriasYnotas> resultado=new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
            resultado.add(new MateriasYnotas(rs.getInt(1),rs.getString(2),rs.getInt(3)));
                    }
            return resultado;
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al obtener datos alumno y nota");
        }
        return null;
    }
    
}
