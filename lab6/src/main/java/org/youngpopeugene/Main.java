package org.youngpopeugene;

import org.youngpopeugene.math.*;
import org.youngpopeugene.util.Drawer;
import org.youngpopeugene.util.Printer;
import org.youngpopeugene.util.Reader;

public class Main {
    public static void main( String[] args ) {
        int input;
        do {
            input = Reader.methodInput();
            if (input == 4) break;
            MethodHandler.setMethodNumber(input);
            Functions.setFunctionNumber(Reader.functionSelection());
            double a = Reader.inputA();
            double b = Reader.inputB();
            double h = Reader.inputH();
            double y0 = Reader.inputY();
            double eps = 0;
            if (input == 3) eps = Reader.inputEps();
            int e = Reader.inputE();
            double[][] result = MethodHandler.execute(a, b, y0, h, eps);
            Printer.printInterval(a, b, h);
            Printer.printTable(result, e);
            String str = " Эйлера";
            if (input == 2) str = " Рунге-Кутта 4 порядка";
            if (input == 3) str = " Адамса";
            Drawer.draw(result, "Метод" + str);
        } while (true);
        System.out.println(Printer.getRedText(">>> Завершение работы <<<"));
    }
}
