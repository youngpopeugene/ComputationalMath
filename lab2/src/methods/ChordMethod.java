package methods;

import storage.EquationStorage;
import util.Printer;

import java.util.concurrent.TimeoutException;

public class ChordMethod {
    public static void execute(double a, double b, double accuracy) throws TimeoutException {
        double xi_1 = Integer.MAX_VALUE;
        double xi;
        double ai = a;
        double bi = b;
        double fxi;
        double fai;
        double fbi;
        int i = 1;
        while (true){
            fai = EquationStorage.getEquation(ai);
            fbi = EquationStorage.getEquation(bi);
            xi = (ai * fbi - bi * fai) / (fbi - fai);
            fxi = EquationStorage.getEquation(xi);
            if (fxi * fai < 0){
                bi = xi;
            }else {
                ai = xi;
            }
            if (Math.abs(xi - xi_1) <= accuracy){
                System.out.println(Printer.getYellowText("Reason for terminating the iterative process: |x_i - x_{i-1}| <= ε"));
                break;
            } else if (Math.abs(ai - bi) <= accuracy) {
                System.out.println(Printer.getYellowText("Reason for terminating the iterative process: |a_i - b_i| <= ε"));
                break;
            } else if (Math.abs(fxi) <= accuracy) {
                System.out.println(Printer.getYellowText("Reason for terminating the iterative process: |f(x_i)| <= ε"));
                break;
            }
            xi_1 = xi;
            i++;
            if (i == 10000) throw new TimeoutException();
        }
        Printer.printResult(xi, i);
    }
}
