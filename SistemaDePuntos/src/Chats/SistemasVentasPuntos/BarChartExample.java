package Chats.SistemasVentasPuntos;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartExample extends JFrame {

  private static final long serialVersionUID = 1L;

  public BarChartExample(String appTitle) {
    super(appTitle);

    // Create Dataset
    CategoryDataset dataset = createDataset();
    
    //Create chart
    JFreeChart chart=ChartFactory.createBarChart(
        "Puntaje por Zonas de SP", //Chart Title
        "Sectores o Zonas de Ventas", // Category axis
        "Indices de  y Puntos", // Value axis
        dataset,
        PlotOrientation.VERTICAL,
        true,true,false
       );

    ChartPanel panel=new ChartPanel(chart);
    setContentPane(panel);
  }

  private CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Population in 2005
    dataset.addValue(10, "Zona 1", "Junio");
    dataset.addValue(45, "Zona 2", "Junio");
    dataset.addValue(20, "Zona 3", "Junio");

    // Population in 2010
    dataset.addValue(15, "Zona 1", "Julio");
    dataset.addValue(20, "Zona 2", "Julio");
    dataset.addValue(25, "Zona 3", "Julio");

    // Population in 2015
    dataset.addValue(32, "Zona 1", "Agosto");
    dataset.addValue(45, "Zona 2", "Agosto");
    dataset.addValue(30, "Zona 3", "Agosto");

    return dataset;
  }

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeAndWait(()->{
      BarChartExample example=new BarChartExample("Sistemas de Puntos");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
}