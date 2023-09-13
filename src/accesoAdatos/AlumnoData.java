

package accesoAdatos;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
          
        } catch (SQLException ex) {
            System.err.println("error al acceder: ");
        }
    
    
    }
}
