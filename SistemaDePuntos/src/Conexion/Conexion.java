
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
    
    //Datos para conecion de la BD de Bayron 
    static String servidor = "localhost"; //Nombre del servidor
    static String user = "sa";// nombre de usuario
    static String pass = "123"; // contrasena 
    static String db = "PR"; //nombre de la BD 
    
    /*
    //Datos para conexion de la BD de Luis Estrada  jdbc:sqlserver://DESKTOP-F99GN1I\MSSQLSERVER12:1433;databaseName=SP
    static String servidor = "DESKTOP-F99GN1I";
    static String user = "LuisEstrada";
    static String pass = "asd.456";
    static String db = "SP";
    */
 
    public static Connection getConexion(){
        String url = "jdbc:sqlserver://"+servidor+":1433;databaseName="+db;
        
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
