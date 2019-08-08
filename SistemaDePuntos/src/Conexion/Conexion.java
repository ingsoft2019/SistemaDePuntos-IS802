
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
 /*
 * @author bayron
 */
public class Conexion {
    static Connection contacto = null;
    //static String user = "sa";
    //static String pass = "123";
    //static String db = "PR";
    
    /*
        Datos para maquina de Luis Estrada 
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PR";
        String user = "sa";
        String pass = "asd.456";  
    */
    
    public static Connection getConexion(){
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PR";
        String user = "sa";
        String pass = "123";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.print("Conectado");
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion:" + e.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            contacto = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    //metodo que recibe una consulta, la ejecuta y devuelve un Resultado
    public static ResultSet consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try {
            declara =  con.createStatement();
            ResultSet respuesta =  declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
