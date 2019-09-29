package Chats.SistemasVentasPuntos;
import java.awt.Font;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class GraficoCircularMayorPuntosClientes extends ApplicationFrame {

    
    public GraficoCircularMayorPuntosClientes(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Juan", new Double(43));
        dataset.setValue("Lucas", new Double(10));
        dataset.setValue("Luis", new Double(27));
        dataset.setValue("Jeral", new Double(17));
        dataset.setValue("Byron", new Double(11.0));
        dataset.setValue("Roger", new Double(19.4));
        return dataset;        
    }
    
   
    private static JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Usuarios con Mayor Puntaje",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
    
 
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
    
    
    public static void main(String[] args) {

        GraficoCircularMayorPuntosClientes demo = new GraficoCircularMayorPuntosClientes("Grafico de Mayor Puntaje por Usuarios");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}*/
