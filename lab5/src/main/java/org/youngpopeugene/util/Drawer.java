package org.youngpopeugene.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.youngpopeugene.methods.Lagrange;
import org.youngpopeugene.methods.Newton;
import org.youngpopeugene.methods.Polynomial;


import javax.swing.*;
import java.util.ArrayList;

public class Drawer {
    public static void drawLagrange() {
        Lagrange lagrange = new Lagrange();
        ArrayList<Double[]> values = Polynomial.getValues();

        XYSeries seriesPoints = new XYSeries("Points");
        XYSeries seriesLagrange = new XYSeries("Lagrange");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < values.size(); i++) {
            seriesPoints.add(values.get(i)[0], values.get(i)[1]);
        }

        for (double i = values.get(0)[0]; i <= values.get(values.size() - 1)[0]; i += 0.1) {
            Polynomial.setX(i);
            seriesLagrange.add(i, lagrange.execute());
        }

        dataset.addSeries(seriesPoints);
        dataset.addSeries(seriesLagrange);

        JFreeChart chart = ChartFactory.createXYLineChart("Лагранж", "x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    public static void drawNewton() {
        Newton newton = new Newton();
        ArrayList<Double[]> values = Polynomial.getValues();

        XYSeries seriesPoints = new XYSeries("Points");
        XYSeries seriesNewton = new XYSeries("Newton");

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < values.size(); i++) {
            seriesPoints.add(values.get(i)[0], values.get(i)[1]);
        }

        for (double i = values.get(0)[0]; i <= values.get(values.size() - 1)[0]; i += 0.1) {
            Polynomial.setX(i);
            seriesNewton.add(i, newton.execute());
        }

        dataset.addSeries(seriesPoints);
        dataset.addSeries(seriesNewton);

        JFreeChart chart = ChartFactory.createXYLineChart("Ньютон", "x",
                "y", dataset, PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame =
                new JFrame("MinimalStaticChart");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
