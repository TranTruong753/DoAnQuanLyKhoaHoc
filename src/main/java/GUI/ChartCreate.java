/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import BLL.statisticBLL;
import DTO.cistatisticDTO;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Administrator
 */
public class ChartCreate {
    private statisticBLL stBLL = null;
    
    public ChartCreate() {
        this.stBLL = new statisticBLL();
    }
    public void setDataToChart(JPanel jpnItem) {
        List<cistatisticDTO> listItem = stBLL.getCISDAL();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (cistatisticDTO item : listItem) {
                dataset.addValue(item.getQuantity(), "Số Lượng".toUpperCase(),item.getPersonID());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ phân công".toUpperCase(),
                "Mã giáo viên".toUpperCase(), "Số Lượng lớp".toUpperCase(),
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(408, 305));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
    
}
