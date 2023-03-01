package methods;

import storage.EquationStorage;
import util.Printer;

import java.util.concurrent.TimeoutException;

public class SimpleIterationMethod {
    public static void execute(double a, double b, double accuracy) throws TimeoutException {
        EquationStorage.setLambda(a, b);
        double xi_1 = EquationStorage.maxValueOfDerivativeOnInterval(a,b)[0];
        double xi;
        int i = 1;
        while (true){
            xi = EquationStorage.getPhi(xi_1);
            if (Math.abs(xi - xi_1) <= accuracy) {
                System.out.println(Printer.getYellowText("Reason for terminating the iterative process: |x_i - x_{i-1}| <= ε"));
                break;
            }
            xi_1 = xi;
            i++;
            if (i == 10000) throw new TimeoutException();
        }
        Printer.printResult(xi, i);
    }
}
