

package accesoAdatos;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**

 */
public class Coneccion {
    public static final String URL = "jdbc:mysql://us-phx-web776.main-hosting.eu:3306/u351249038_universidadULP";
    public static final String USER = "u351249038_FaQPro";
    public static final String PASS = "Facu@2023";
    PreparedStatement ps;
    ResultSet rs;
    public Connection getConnection(){
        Connection conexion=null;
        try{
            
            Class.forName("org.mariadb.jdbc.Driver"); //"com.mysql.jdbc.Driver"
            conexion = (Connection) DriverManager.getConnection(URL, USER, PASS);
            JOptionPane.showMessageDialog(null, "Conexión Exitosa");
        
        }catch(Exception ex){
            System.err.println("Error: "+ex);
        }
        return conexion;
    }
}
