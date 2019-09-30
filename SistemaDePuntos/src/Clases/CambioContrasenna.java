/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;

/**
 *
 * @author Luis Estrada
 */
public class CambioContrasenna {
        //Metodo para consultar el ID de la usuario adminstrador 
    public static ResultSet consultarUsuarioyPass(String usuario, String pass) {
        String consulta = "Select usuario, contrasena from Admin where usuario='" + usuario + "' and contrasena ='" + pass + "'";
        ResultSet resp = Conexion.Conexion.consulta(consulta);
        return resp;
    }
    
    //Metdodo para cambiao de contraseña
    public static ResultSet cambioPass(String usuario, String pass) {
        String consulta ="UPDATE Admin SET usuario ='" + usuario + "',contrasena ='"+ pass +"' WHERE usuario ='"+ usuario +"'";
        ResultSet res = Conexion.Conexion.consulta(consulta);
        return res;
    }
}