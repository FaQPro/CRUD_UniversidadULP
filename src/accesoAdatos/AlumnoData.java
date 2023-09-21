

package accesoAdatos;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadAPP.Entidades.Ealumno;

/**

 */
public class AlumnoData {
    private Connection con=null;
    
    public AlumnoData (){
        con=Coneccion.getConnection();
    }
    
    public void guardarAlumno(Ealumno alumno){
        
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
       
        
        try {
          PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1, alumno.getDni());
          ps.setString(2, alumno.getApellido());
          ps.setString(3, alumno.getNombre());
          ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
          ps.setBoolean (5, alumno.isEstado());
          ps.executeUpdate();
          
          ResultSet rs=ps.getGeneratedKeys();
          if(rs.next()){
          
              alumno.setIdAlumno(rs.getInt(1));
              JOptionPane.showMessageDialog(null, "Alumno Agregado con éxito");
          }
         ps.close(); 
        } catch (SQLException ex) {
            System.err.println("error al acceder: "+ex);
        }
    
    
    }

    
    public void modificarAlumno(Ealumno alumno){
    
        String sql="UPDATE alumno SET dni= ?, apellido= ?, nombre= ?, fechaNacimiento=? WHERE idAlumno = ?";
        try {
            PreparedStatement ps= (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            int okAlumno =ps.executeUpdate();
            if (okAlumno==1){
            JOptionPane.showMessageDialog(null, "OK \n Alumno Modificado");
            }
            
            
        } catch (HeadlessException | SQLException e) {
            System.err.println("error al acceder: "+e);
        }
    
    }
    
    //Eliminado Logico por estado a 0/false UPDATE 
    public void eliminarAlumno(int id){
        String sql="UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if (exito==1) {
                
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
                
            }
        } catch (SQLException ex) {
           System.err.println("error al acceder: "); 
        }
    }

    public Ealumno buscarAlumno (int id){
    String sql="SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno =? AND estado =1";
    Ealumno alumno=null;    
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                alumno=new Ealumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                
            }else {
            JOptionPane.showMessageDialog(null, "No existe ese alumno ");
            }
            ps.close();
                    
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos "+ex);
        }
    return alumno;
    }

    public Ealumno buscarAlumnoPorDni (int dni){
    String sql="SELECT idAlumno,dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni =? AND estado =1";
    Ealumno alumno=null;    
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                alumno=new Ealumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                
            }else {
            JOptionPane.showMessageDialog(null, "No existe ese alumno ");
            }
            ps.close();
                    
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos "+ex);
        }
    return alumno;
    }

     public List<Ealumno> ListarAlumnos (){
    String sql="SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE estado =1";
    ArrayList<Ealumno> alumnos=new ArrayList<>();    
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Ealumno alumno=new Ealumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                alumnos.add(alumno);
            }
            ps.close();
                    
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos "+ex);
        }
    return alumnos;
    }
}
