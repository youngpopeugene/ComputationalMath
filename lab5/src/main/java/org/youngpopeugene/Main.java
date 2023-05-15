package org.youngpopeugene;


import org.youngpopeugene.methods.Lagrange;
import org.youngpopeugene.methods.Newton;
import org.youngpopeugene.util.Drawer;
import org.youngpopeugene.util.Printer;
import org.youngpopeugene.util.Reader;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.readInput();
        double lagrangeResult = new Lagrange().execute();
        double newtonResult = new Newton().execute();
        Printer.printResult(lagrangeResult, newtonResult);
        Printer.printFiniteDifferenceTable();
        Drawer.drawLagrange();
        Drawer.drawNewton();
    }
}