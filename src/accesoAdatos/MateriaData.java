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
    private Connection con=null;
    
    public MateriaData(){
        con=Coneccion.getConnection();
    }
    public void guardarMateria(Materia materia){
        String sql= "INSERT INTO materia (Nombre, año,estado) VALUES (? , ?, ? ,?)";
        try {
            //esto de aca abajo es por no usar el driver de mariaDb
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Materia.getNombre());
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error conectando a BD");
        }
        

    
        
    }
    
    
}
