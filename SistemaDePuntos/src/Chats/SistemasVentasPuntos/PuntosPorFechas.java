package Chats.SistemasVentasPuntos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PuntosPorFechas extends ApplicationFrame {
static ResultSet resultado;
   public PuntosPorFechas( String applicationTitle , String chartTitle ) throws SQLException {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Dias","Puntos por Dia",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
       
       
        resultado =  Conexion.Conexion.consulta("select m.fecha_movimiento,sum (m.puntos_asignados) as puntos\n" +
"from [PR].dbo.Cliente as c\n" +
"inner join [PR].dbo.Persona as p\n" +
"on c.id_persona = p.id_persona\n" +
"inner join [PR].dbo.Zona as z\n" +
"on p.id_zona = z.id_zona\n" +
"inner join [PR].dbo.Movimiento M on M.id_cliente = c.id_cliente\n" +
"and m.fecha_movimiento between '2019-09-01' and '2019-09-30'\n" +
"where z.zona = 'Zona 4'\n" +
"group by m.fecha_movimiento \n" +
"order by m.fecha_movimiento;");
            List<ChartsCircularResponse> listaResponse = new ArrayList<>();
            String ValorMedio = "Puntos por Fechas" ;
            
           // System.err.println(resultado);
               Vector v = new Vector();
                 while (resultado.next()) {
               // dataset.setValue(resultado.getString(1), new Double(resultado.getString(2)));
                 dataset.addValue( new Double(resultado.getString(2)) , ValorMedio , resultado.getString(1) );
                v.add(resultado.getString(1));
                System.out.println("El Valor es: "+resultado.getString(1));
                System.out.println("El Valor es: "+resultado.getString(2));
                v.add(resultado.getString(2));
               // v.add(resultado.getString(3));
               // v.add(resultado.getString(4));
         
               
            }
//                  System.err.println(v.get(0));
//                  System.err.println(v.get(1));
//                  System.err.println(v.get(2));
//                  System.err.println(v.get(3));
                // System.err.println("El tamaño del vector es:"+v.size());
                 v.toArray();
                // System.err.println("El tamaño del vector es:"+v);
        
        
                 
       // DefaultPieDataset dataset = new DefaultPieDataset();
        int tamano =  v.size()/4;
        
//     for (int i = 0; i < tamano; i++) {
//          System.err.println("ELEMANTOS REALES"+v.get(i));
//        }
        
//        dataset.setValue("Juan", new Double(43));
//        dataset.setValue("Lucas", new Double(10));
//        dataset.setValue("Luis", new Double(27));
//        dataset.setValue("Jeral", new Double(17));
//        dataset.setValue("Byron", new Double(11.0));
//        dataset.setValue("Roger", new Double(19.4));
      //  return dataset; 
      
      
       
       
       
       
       
       
       
     
//      dataset.addValue( 15 , "schools" , "1970" );
//      dataset.addValue( 30 , "schools" , "1980" );
//      dataset.addValue( 60 , "schools" ,  "1990" );
//      dataset.addValue( 120 , "schools" , "2000" );
//      dataset.addValue( 240 , "schools" , "2010" );
//      dataset.addValue( 300 , "schools" , "2014" );
      return dataset;
   }
   
   public static void main( String[ ] args ) throws SQLException {
      PuntosPorFechas chart = new PuntosPorFechas(
         "Puntos Por Dias en Zona" ,
         "Puntos por Dias");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}