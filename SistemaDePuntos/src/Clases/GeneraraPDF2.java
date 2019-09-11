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
//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class GeneraraPDF2 {
    
    public static void generarPdf(String puntosActuales, String puntosAnteriores, String puntosAsignados, String cliente) throws FileNotFoundException, DocumentException, PrinterException, IOException{
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String Fecha = formatoFecha.format(fechaActual);  
        
        Font fuenteBolt = new Font(Font.FontFamily.COURIER,12,Font.BOLD);
        Font fuenteNormal = new Font(Font.FontFamily.COURIER,10,Font.NORMAL);
        Font fuenteItalica = new Font(Font.FontFamily.COURIER,10,Font.ITALIC);
        
        Chunk cEncabezado = new Chunk("Factura Puntos REGIS", fuenteBolt);
        Chunk cCliente = new Chunk("Cliente: "+ cliente, fuenteNormal);
        Chunk cPuntosActuales = new Chunk("Puntos actuales: "+ puntosActuales, fuenteNormal);
        Chunk cPuntosAnteriores = new Chunk("Puntos anteriores: "+ puntosAnteriores, fuenteNormal);
        Chunk cPuntosAsignados = new Chunk("Puntos Asignados: "+ puntosAsignados, fuenteNormal);
        Chunk cSeparador = new Chunk("__________________________", fuenteNormal);
        Chunk cSaltoLinea = new Chunk(" ", fuenteNormal);
        Chunk cFooter = new Chunk(Fecha, fuenteItalica);
        
        Paragraph encabezabo = new Paragraph(cEncabezado);
        encabezabo.setAlignment(Element.ALIGN_CENTER);
        
        Paragraph p1 = new Paragraph(cPuntosAnteriores);
        Paragraph p2 = new Paragraph(cCliente);
        Paragraph p3 = new Paragraph(cPuntosAsignados);
        Paragraph p4 = new Paragraph(cPuntosActuales);
        Paragraph separador = new Paragraph(cSeparador);
        Paragraph saltoLinea = new Paragraph (cSaltoLinea);
        
        Paragraph footer = new Paragraph(cFooter);
        
        
        try {
            FileOutputStream archivo = new FileOutputStream("factura.pdf");
            Rectangle tamanio = new Rectangle(170, 254);//6cm x 9 cm// 1 pulg = 72 puntos
            Document documento = new Document(tamanio, 5,5,2,2);
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            //Inicio de Plantilla de la factura PDF
            documento.add(saltoLinea);
            documento.add(encabezabo);
            documento.add(separador);
            documento.add(saltoLinea);
            documento.add(p2);
            documento.add(saltoLinea);
            documento.add(p1);
            documento.add(saltoLinea);
            documento.add(p3);
            documento.add(saltoLinea);
            documento.add(p4);
            documento.add(separador);
            documento.add(saltoLinea);
            documento.add(footer);          
            //Fin de la plantilla
            documento.close();
            
            //abrirArchivo("factura.pdf");
            
            imprimir("factura.pdf");
        }catch (Exception e) {
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
    
    public static void imprimir(String archivo){
        ImprimirPDF impresor = new ImprimirPDF();
        try {
            impresor.imprimir();
        } catch (PrinterException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de impresion", "Error", JOptionPane.ERROR_MESSAGE);
            //LOGGER.log(Level.SEVERE, null, ex);
        }
    }
    
}
