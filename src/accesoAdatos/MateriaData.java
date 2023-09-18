/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAdatos;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadAPP.Entidades.Materia;

/**
 *
 * @author rodrigo
 */
public class MateriaData {
    public Connection con=null;
    
    public MateriaData(){
        con=Coneccion.getConnection();
    }
    public void guardarMateria(Materia materia){
        String sql= "INSERT INTO materia (Nombre, año,estado) VALUES (? , ?, ?)";
        try {
            //esto de aca abajo es por no usar el driver de mariaDb
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet guardar=ps.getGeneratedKeys();
            if (guardar.next()){
                materia.setIdMateria(guardar.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia Guardada correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error conectando a base de Datos en Guardar Materia ");
        }
        
    }
    
    public void modificarMateria(Materia materia){
            String sql="UPDATE materia SET nombre= ?, año= ?,estado= ? WHERE idMateria= ?";    
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3,materia.isEstado());
            ps.setInt(4,materia.getIdMateria());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Materia modificada exitosamente");
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar");
        }
    }
    public boolean buscarNombreMateria(Materia materia){
        String sql="SELECT * FROM materia WHERE nombre=? AND año=?";
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            System.out.println(materia.getNombre());
            System.out.println(materia.getAño());
            ps.setString(1, materia.getNombre());
            ps.setInt(2,materia.getAño());
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                System.out.println("Regreso true");
                rs.close();
            return true;
            } else { 
                System.out.println("Regreso false");
                rs.close();
                return false;

            }
            
        }
            
            catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error de conexion en busqueda por nombre y año materia");
                    return false;
                    }
        }
    public Materia buscarIdMateria(int idmateria)    {
        String sql="SELECT * FROM materia WHERE idMateria= ?";
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, idmateria);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Materia mat=new Materia(idmateria,rs.getString(2),rs.getInt(3),rs.getBoolean(4));
                rs.close();
                return mat;
                
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error buscando Materia");
        }
        return null;
        
        
    }
}
        
        
        
        
        
    
    
            
            
    

