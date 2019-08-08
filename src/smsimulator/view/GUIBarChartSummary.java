package smsimulator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import smsimulator.Controler.MediatorInterface;


public class GUIBarChartSummary extends JPanel implements Component {
    
    private MediatorInterface mediator;

    public GUIBarChartSummary() {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7445,  "Lowest Capital", "Financial");
        dataset.addValue(24448, "Highest Capital", "Financial");
        dataset.addValue(4297,  "Lowest Capital", "IT");
        dataset.addValue(21022, "Highest Capital", "IT");
        
        JFreeChart chart = ChartFactory.createBarChart("This panel is not working yet", null, "Capital", dataset);
        chart.addSubtitle(new TextTitle("It will be implemented in the next version"));
        chart.setBackgroundPaint(Color.white);

        chart.getLegend().setFrame(BlockBorder.NONE);
        
        ChartPanel CP = new ChartPanel(chart);
        
        this.setLayout(new java.awt.BorderLayout());
        this.add(CP,BorderLayout.CENTER);
        this.validate();
    }
    
    
    @Override
    public void setMediator(MediatorInterface mediator) {
        this.mediator = mediator;
    }
    
    
    @Override
    public String getName() {
        return "BarChart";
    }
    
}