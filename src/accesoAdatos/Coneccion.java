

package accesoAdatos;

import com.mysql.jdbc.PreparedStatement;
//import java.sql.PreparedStatement;
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
    //agrego esta linea porque no puedo acceder al metodo getConection desde otra clase
    private static Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    //agregue el static en la parte de abajo
    public static Connection getConnection(){
        Connection conexion=null;
        try{
            // Cambie el driver mariadb por el mysql JDBC Driver que lo instalan en la carpeta por defecto
            Class.forName("com.mysql.jdbc.Driver"); //"org.mariadb.jdbc.Driver"
            conexion = (Connection) DriverManager.getConnection(URL, USER, PASS);
            //JOptionPane.showMessageDialog(null, "Conexión Exitosa");
        
        }catch(Exception ex){
            System.err.println("Error: "+ex);
        }
        return conexion;
    }
}
