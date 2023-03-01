package methods;

import storage.EquationStorage;
import util.Printer;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class NewtonMethod {
    public static void execute(double a, double b, double accuracy) throws TimeoutException {
        double xi_1;
        double fxi_1;
        double dxi_1;
        double xi;
        double fxi;
        double dxi;
        if (EquationStorage.getEquation(a)*EquationStorage.getDoubleDerivative(a) > 0){
            xi_1 = a;
        } else{
            xi_1 = b;
        }

        int i = 1;
        while(true){
            fxi_1 = EquationStorage.getEquation(xi_1);
            dxi_1 = EquationStorage.getDerivative(xi_1);
            xi = xi_1 - fxi_1/dxi_1;
            fxi = EquationStorage.getEquation(xi);
            dxi = EquationStorage.getDerivative(xi);
            if (Math.abs(xi - xi_1) <= accuracy){
                System.out.println(Printer.getYellowText("Reason for terminating the iterative process: |x_i - x_{i-1}| <= ε"));
                break;
            } else if (Math.abs(fxi/dxi) <= accuracy) {
                System.out.println(Printer.getYellowText("Reason for terminating the iterative process: |f(x_i)/f'(x_i)| <= ε"));
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
