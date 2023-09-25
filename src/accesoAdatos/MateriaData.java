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
import java.util.ArrayList;
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
        //Se realiza la conexion a la BD A traves del metodo GetConnection de la clase Coneccion 
        con=Coneccion.getConnection();
    }
    
    public void guardarMateria(Materia materia){
        //Este metodo recibe un objeto del tipo Materia y lo inserta en la BD a través de SQL
       
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
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error conectando a base de Datos en Guardar Materia ");
            }
        
    }
    
    public void modificarMateria(Materia materia){
            //Este método recibe un objeto de tipo Materia y lo utiliza para modificar los datos de la BD
            //a traves de la sentencia UPDATE de SQL
        
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
            JOptionPane.showMessageDialog(null,"Error al conectar en Modificar Materia");
        }
    }
    public boolean buscarNombreMateria(Materia materia){
        //Esta funcion recibe un objeto Materia, del cual utiliza el nombre y el año para buscar el registro correcto
        //en la BD a traves de la sentencia SELECT de SQL y devulve TRUE (si encontró) o FALSE
        
        
        String sql="SELECT * FROM materia WHERE nombre=? AND año=?";
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2,materia.getAño());
            ResultSet rs=ps.executeQuery();
            //En el if compruebo si hubo un resultado, en ese caso, la funcion devuelve true
            if (rs.next()){
                rs.close();
            return true;
            } else { 
                rs.close();
                return false;

            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error de conexion en busqueda por nombre y año materia");
            return false;
            }
        }
    
    public Materia buscarIdMateria(int idmateria)    {
        //Esta funcion recibe un id de materia, y realiza una busqueda en la BD a través de un SElECT
        //al encontrarla devuelve un objeto del tipo Materia
        
        
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
    
    
    public ArrayList<String> MateriasTodas(){
        //Esta funcion devuelve un ArrayList cargado con todos los nombres de materias
        //Ordenado por nombre-
        
    ArrayList<String> listaMat=new ArrayList<>();
    String sql="SELECT nombre FROM materia ORDER BY nombre";
    try {
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            listaMat.add(rs.getString("nombre"));
        }
        return listaMat;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error intentando traer los nombres de las materias");
            }
    return null;    
            
   }
    
     public int devuelveIdMateria(String nombreMat){
         
         //Esta funcion recibe un nombre de una materia y devuelve el Id de la misma haciendo una busqueda 
         //en la BD a traves de SQL
         
        String sql="SELECT idMateria FROM materia WHERE nombre=? ";
         
        try {
            PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, nombreMat );
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                //acá utilizo el indice de la columna que tiene el dato que quiero en lugar de escribir el nombre
                return rs.getInt(1);
               
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error buscando el nombre de la materia");
            return 0;
            }
    return 0;
    }
    
        
}
        
        
        
        
        
    

        
        
        
        
        
    
    
            
            
    

