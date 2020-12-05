/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigInteger;
import java.util.HashMap;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author evand
 */
public class ChartUtils {

    //Gráfico de Pizza
    private static PieDataset createDatasetPizza(HashMap<String, BigInteger> map) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        map.forEach((cidade, numero) -> {
            dataset.setValue(cidade, numero);
        });

        return dataset;
    }

    private static DefaultCategoryDataset createDatasetHBar(HashMap<String, BigInteger> map) {
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        map.forEach((tabela, numero) -> {
            barDataset.setValue(numero, "Tabelas", tabela.substring(tabela.lastIndexOf(".")+1));
        });
        return barDataset;
    }

    private static JFreeChart createChartPizza(PieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart(
                title, // título do gráfico
                dataset, // dados    
                true, // incluir legenda   
                true,
                false);

        return chart;
    }

    private static JFreeChart createChartHbar(DefaultCategoryDataset dataset, String title) {
        //cria aqui o gráfico
        JFreeChart chart = ChartFactory.createBarChart(title, "Tabela", "Número", dataset , 
                PlotOrientation.HORIZONTAL, false, true, false);
        return chart;
    }

    public void gerarGraficoPizza(JPanel panel, String title, HashMap<String, BigInteger> map) {
        Dimension dimensao = panel.getPreferredSize();
        JFreeChart chart = createChartPizza(createDatasetPizza(map), title);
        panel.setLayout(new BorderLayout());
        ChartPanel cp = new ChartPanel(chart) {
            public Dimension getPreferredSize() {
                //return new Dimension(500, 300);
                return dimensao; //seta o tamanho do gráfico de acordo com o definido no jpanel
            }
        };
        panel.add(cp, BorderLayout.CENTER);
        panel.validate();
    }

    public void gerarGraficoHBarras(JPanel panel, String title,
            HashMap<String, BigInteger> map) {
        Dimension dimensao = panel.getPreferredSize();
        JFreeChart chart = createChartHbar(createDatasetHBar(map), title);
        panel.setLayout(new BorderLayout());
        ChartPanel cp = new ChartPanel(chart) {
            public Dimension getPreferredSize() {
                return dimensao;
            }
        };
        panel.add(cp, BorderLayout.CENTER);
        panel.validate();

    }
}
