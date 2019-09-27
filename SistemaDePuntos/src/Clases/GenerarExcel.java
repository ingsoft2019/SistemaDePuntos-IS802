/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author pc
 */
public class GenerarExcel {
    public static void WriteExcel() throws IOException,  RowsExceededException,
    WriteException{
        File file = new File("src/reportes/reporteExcel.xls");
        int row=1;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont( WritableFont.ARIAL, 12, WritableFont.NO_BOLD );
        WritableCellFormat cf = new WritableCellFormat(wf);    

        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        
        if (file.createNewFile()) {  
            System.out.println("New File is created!");  
        } else {  
            System.out.println("File already exists.");  
        } 
        
        //FileOutputStream archivo = new FileOutputStream("reporteExcel.xls");
        
        workbook = Workbook.createWorkbook( file, wbSettings );
        //hoja con nombre de la tabla
        workbook.createSheet( "Informacion de los Clientes", 0 );
        excelSheet = workbook.getSheet(0);
        System.out.println(  "creando hoja excel.....Listo"  );

        //Consulta SQL 
        String sql = "SELECT ROW_NUMBER() OVER(ORDER BY p.pnombre ASC) 'No.', CONCAT(p.pnombre, ' ',p.snombre, ' ', p.sapellido, \n" +
            "' ', p.sapellido) Nombre, p.identidad Identidad, p.correo Correo, p.sexo Sexo, p.fecha_nacimiento FechaNacimiento, \n" +
            "z.zona Zona, p.detalle_direccion Direccion, CONCAT(telefono1, ' ',telefono2,' ',telefono3) Telefonos, \n" +
            "puntos_actuales PuntosActuales, puntos_rifa_actuales PuntosRifa, fecha_vencimiento_puntos FechaVencimientoPuntos \n" +
            "FROM Persona p\n" +
            "INNER JOIN Cliente c ON c.id_persona = p.id_persona\n" +
            "INNER JOIN Zona z ON z.id_zona = p.id_zona\n" +
            "WHERE c.estado <> 'I'; ";
         try{
             
            PreparedStatement pstm = Conexion.getConexion().prepareStatement( sql );
            ResultSet res = pstm.executeQuery();
            System.out.println(  "obteniendo registros.....Listo"  );
            Label eNo  = new Label( 0 , 0, "No." , cf );
            Label eNombre  = new Label( 1 , 0, "Nombre" , cf );
            Label eIdentidad  = new Label( 2 , 0, "Identidad" , cf );
            Label eCorreo  = new Label( 3 , 0, "Correo" , cf );
            Label eSexo  = new Label( 4 , 0, "Sexo" , cf );
            Label eFechaNacimiento  = new Label( 5 , 0, "Fecha de Nacimiento" , cf );
            Label eZona  = new Label( 6 , 0, "Zona" , cf );
            Label eDireccion  = new Label( 7 , 0, "Direccion" , cf );
            Label eTelefonos  = new Label( 8 , 0, "Telefonos" , cf );
            Label ePuntosActuales  = new Label( 9 , 0, "Puntos Actuales" , cf );
            Label ePuntosRifa  = new Label( 10 , 0, "Puntos Rifa" , cf );
            Label eFechaVencimientoPuntos  = new Label( 11 , 0, "Fecha de Vencimiento dePuntos" , cf );
            
            excelSheet.addCell(eNo);
            excelSheet.addCell( eNombre );
            excelSheet.addCell( eIdentidad );
            excelSheet.addCell( eCorreo );
            excelSheet.addCell( eSexo );
            excelSheet.addCell( eFechaNacimiento );
            excelSheet.addCell( eZona );
            excelSheet.addCell( eDireccion );
            excelSheet.addCell( eTelefonos );
            excelSheet.addCell( ePuntosActuales );
            excelSheet.addCell( ePuntosRifa );
            excelSheet.addCell( eFechaVencimientoPuntos );
            
            while(res.next())
            {
                Number no     = new Number( 0 , row, res.getInt( "No." ) , cf );
                Label nombre  = new Label( 1 , row, res.getString( "Nombre" ) , cf );
                Label identidad= new Label( 2 , row, res.getString( "Identidad" ) , cf );                  
                Label correo= new Label( 3 , row, res.getString( "Correo" ) , cf );
                Label sexo= new Label( 4 , row, res.getString( "Sexo" ) , cf );
                Label fechaNacimiento= new Label( 5 , row, res.getString("FechaNacimiento" ) , cf );
                Label zona= new Label( 6 , row, res.getString( "Zona" ) , cf );
                Label direccion= new Label( 7 , row, res.getString( "Direccion" ) , cf );
                Label telefonos= new Label( 8 , row, res.getString( "Telefonos" ) , cf );
                Number puntosActuales= new Number( 9 , row, res.getInt( "PuntosActuales" ) , cf );
                Number puntosRifa= new Number( 10 , row, res.getInt( "PuntosRifa" ) , cf );
                Label fechaVencimientoPuntos= new Label( 11 , row, res.getString( "FechaVencimientoPuntos" ) , cf );

                row ++;                  
               try {
                   excelSheet.addCell( no );
                   excelSheet.addCell( nombre );
                   excelSheet.addCell( identidad );
                   excelSheet.addCell( correo );
                   excelSheet.addCell( sexo );
                   excelSheet.addCell( fechaNacimiento );
                   excelSheet.addCell( zona );
                   excelSheet.addCell( direccion );
                   excelSheet.addCell( telefonos );
                   excelSheet.addCell( puntosActuales );
                   excelSheet.addCell( puntosRifa );
                   excelSheet.addCell( fechaVencimientoPuntos );
               } catch (WriteException ex) {
                   System.err.println(  ex.getMessage() );
               } 
            }
           res.close();         
       }catch( SQLException e ){
          System.err.println( e.getMessage() );
      }

      //Escribe el archivo excel en disco
      try {
          workbook.write();
          workbook.close();
          System.out.println(  "Escribiendo en disco....Listo"  );         
      } catch (IOException ex) {
          System.err.println(  ex.getMessage() );
      }
      catch (WriteException ex) {
         System.err.println(  ex.getMessage() );
      }

      System.out.println(  "Proceso completado...."  );

      abrirArchivo();
    }
    public static void abrirArchivo(){
        try {
            File objetofile = new File ("src/reportes/reporteExcel.xls");
            Desktop.getDesktop().open(objetofile);
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
