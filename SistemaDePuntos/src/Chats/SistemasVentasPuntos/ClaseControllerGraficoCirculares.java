/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chats.SistemasVentasPuntos;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Vector;
/**
 *
 * @author Evert Gonzalez
package Chats.SistemasVentasPuntos;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author Evert Gonzalez
 */
public class ClaseControllerGraficoCirculares {
   static ResultSet resultado;
       public List<ChartsCircularResponse> listarvalores(String zona) throws Exception {
        try {

            resultado =  Conexion.Conexion.consulta("select top (5) * from(\n" +
"\n" +
"select top (1000) concat(p.pnombre,' ',p.snombre,' ',p.papellido,' ', p.sapellido ) as nombrecompleto, C.puntos_actuales\n" +
"\n" +
" ,(select (cast(datediff(dd,p.fecha_nacimiento,GETDATE()) / 365.25 as int))) as edad, \n" +
" p.fecha_nacimiento\n" +
" from [PR].[dbo].[Persona] P \n" +
" inner join [PR].[dbo].Zona Z on Z.id_zona = P.id_zona\n" +
" inner join [PR].[dbo].Cliente C on C.id_persona = P.id_persona\n" +
" where  (select (cast(datediff(dd,p.fecha_nacimiento,GETDATE()) / 365.25 as int))) > 5 and  Z.zona= 'zona 4'\n" +
" order by C.puntos_actuales desc \n" +
" ) as fch\n" +
"where fch.edad BETWEEN 18  AND 48  ");
            List<ChartsCircularResponse> listaResponse = new ArrayList<>();
            
            System.err.println(resultado);
               Vector v = new Vector();
                 while (resultado.next()) {
               
             
                v.add(resultado.getString(1));
                System.out.println("El Valor es: "+resultado.getString(1));
                v.add(resultado.getString(2));
                v.add(resultado.getString(3));
                v.add(resultado.getString(4));
         
               
            }
                  System.err.println(v.get(0));
                  System.err.println(v.get(1));
                  System.err.println(v.get(2));
                  System.err.println(v.get(3));
                 System.err.println("El tamaño del vector es:"+v.size());
                 v.toArray();
                 System.err.println("El tamaño del vector es:"+v);
                  
            
         
//                        for (int i = 0; i < listapresentacion.size(); i++) {
//                listaResponse.add(new modelGraficoCircular(
//                        
//                        listapresentacion.get(i).getNumpresentacion(),
//                        listapresentacion.get(i).getCr(),
//                        listapresentacion.get(i).getNumpreremota(),
//                        listapresentacion.get(i).getClasificacionservicio(),
//                        listapresentacion.get(i).getDesdocumentoconsignado(),
//                        listapresentacion.get(i).getCodservicio(),
//                        listapresentacion.get(i).getOrigen(),
//                        listapresentacion.get(i).getFechapresentacion(),
//                        listapresentacion.get(i).getEstadopresentacion(),
//                        listapresentacion.get(i).getPresentante(),
//                        listapresentacion.get(i).getAfavorde(),
//                        listapresentacion.get(i).getTimbres(),
//                        listapresentacion.get(i).getImpuesto(),
//                        listapresentacion.get(i).getNombrefuncionario(),
//                        listapresentacion.get(i).getNuminstrumento(),
//                        listapresentacion.get(i).getFechainstrumento(),
//                        listapresentacion.get(i).getTipodocumento()
//                ));
//            }


            return listaResponse;
        } catch (Exception ex) {
            Logger.getLogger(ClaseControllerGraficoCirculares.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    
}