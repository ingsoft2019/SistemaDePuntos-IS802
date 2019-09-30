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
public class ConsultasParaGraficas {
    //Metodo para consultar el sexo de los cliente
    public static ResultSet consultarSexoClientes( ) {
        String consulta = "select sexo from Persona";
        ResultSet resp = Conexion.Conexion.consulta(consulta);
        return resp;
    }
    
}
