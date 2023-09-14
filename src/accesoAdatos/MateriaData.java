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
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia Guardada correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error conectando a BD");
        }
        

    
        
    }
    
    public void modificarMateria(Materia materia){
            String sql="UPDATE materia SET nombre= ?, año= ? WHERE idMateria= ?";    
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setInt(3,materia.getIdMateria());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Materia modificada exitosamente");
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar");
        }
    }
    
    public void bajaMateria(Materia materia)        {
        String sql="UPDATE materia SET estado= false WHERE idMateria= ?";
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1,materia.getIdMateria());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Materia dada de Baja");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar");
        }
        
        
    }
            
            
    }

