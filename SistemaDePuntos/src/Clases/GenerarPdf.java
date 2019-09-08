package Clases;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class GenerarPdf {
    private Font fuenteBolt = new Font(Font.FontFamily.COURIER,10,Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER,10,Font.NORMAL);
    private Font fuenteItalica = new Font(Font.FontFamily.COURIER,10,Font.ITALIC);
    
    public void generarPdf(String header, String puntosAnteriores, String puntosAsignados, String puntosActuales, String footer, String rutaImagen, String salida){
        try {
            Rectangle tamanio = new Rectangle(558, 372);
            Document documento = new Document(tamanio, 36,36,10,10);
            PdfWriter.getInstance(documento, new FileOutputStream("prueba.pdf"));
            documento.open();
            documento.add(getHeader(header));
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(100, 100);
            imagen.setAlignment(Element.ALIGN_CENTER);
            documento.add(imagen);
            documento.add(getInfo(puntosAnteriores));
            documento.add(getInfo(puntosAsignados));
            documento.add(getInfo("----------------------"));
            documento.add(getInfo(puntosActuales));
            documento.add(getFooter(footer));
            documento.close();
            
        } catch (Exception e) {
            System.out.println("Error: "+ e);
        }
    }
    private Paragraph getHeader(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteBolt);
        p.add(c);
        return p;
    }
    private Paragraph getInfo(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }
    private Paragraph getFooter(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteItalica);
        p.add(c);
        return p;
    }
}
