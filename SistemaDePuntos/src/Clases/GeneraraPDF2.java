/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pc
 */
public class GeneraraPDF2 {
    
    public static void generarPdf(String puntosActuales, String puntosAnteriores, String puntosAsignados) throws FileNotFoundException, DocumentException{
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String Fecha = formatoFecha.format(fechaActual);  
        
        Font fuenteBolt = new Font(Font.FontFamily.COURIER,5,Font.BOLD);
        Font fuenteNormal = new Font(Font.FontFamily.COURIER,3,Font.NORMAL);
        Font fuenteItalica = new Font(Font.FontFamily.COURIER,2,Font.ITALIC);
        
        Chunk cEncabezado = new Chunk("Factura Puntos REGIS", fuenteBolt);
        Chunk cPuntosActuales = new Chunk("Puntos actuales: "+ puntosActuales, fuenteNormal);
        Chunk cPuntosAnteriores = new Chunk("Puntos anteriores: "+ puntosAnteriores, fuenteNormal);
        Chunk cPuntosAsignados = new Chunk("Puntos Asignados: "+ puntosAsignados, fuenteNormal);
        Chunk cFooter = new Chunk(Fecha, fuenteItalica);
        
        Paragraph encabezabo = new Paragraph(cEncabezado);
        encabezabo.setAlignment(Element.ALIGN_CENTER);
        Paragraph p1 = new Paragraph(cPuntosAnteriores);
        Paragraph p2 = new Paragraph(cPuntosAsignados);
        Paragraph p3 = new Paragraph(cPuntosActuales);
        Paragraph footer = new Paragraph(cFooter);
        
        
        try {
            FileOutputStream archivo = new FileOutputStream("factura.pdf");
            Rectangle tamanio = new Rectangle(150, 100);
            Document documento = new Document(tamanio, 36,36,10,10);
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            //Inicio de Plantilla de la factura PDF
            documento.add(encabezabo);
            documento.add(new Paragraph ("____________________________"));
            documento.add(p1);
            documento.add(p2);
            documento.add(p3);
            documento.add(new Paragraph ("____________________________"));
            documento.add(footer);          
            //Fin de la plantilla
            documento.close();
            
            abrirArchivo("factura.pdf");
            
        } catch (Exception e) {
            System.out.println("Error: "+ e);
        }        
    }
    
    public static void abrirArchivo(String archivo){
        try {
            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);
        }catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
