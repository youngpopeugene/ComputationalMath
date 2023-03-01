package storage;
import util.Printer;
public class EquationStorage {
    private static int numberOfEquation;

    private static double lambda;

    public static void setNumberOfEquation(int numberOfEquation) {
        EquationStorage.numberOfEquation = numberOfEquation;
    }

    public static int getNumberOfEquation() {
        return numberOfEquation;
    }

    public static double getEquation(double x){
        switch(numberOfEquation){
            case 1 -> {
                return getFirstEquation(x);
            }
            case 2 -> {
                return getSecondEquation(x);
            }
            case 3 -> {
                return getThirdEquation(x);
            }
            case 4 -> {
                return getFourthEquation(x);
            }
            default -> {
                return getFifthEquation(x);
            }
        }
    }

    public static double getDerivative(double x){
        switch(numberOfEquation){
            case 1 -> {
                return getFirstDerivative(x);
            }
            case 2 -> {
                return getSecondDerivative(x);
            }
            case 3 -> {
                return getThirdDerivative(x);
            }
            case 4 -> {
                return getFourthDerivative(x);
            }
            default -> {
                return getFifthDerivative(x);
            }
        }
    }

    public static double getDoubleDerivative(double x){
        switch(numberOfEquation){
            case 1 -> {
                return getFirstDoubleDerivative(x);
            }
            case 2 -> {
                return getSecondDoubleDerivative(x);
            }
            case 3 -> {
                return getThirdDoubleDerivative(x);
            }
            case 4 -> {
                return getFourthDoubleDerivative(x);
            }
            default -> {
                return getFifthDoubleDerivative(x);
            }
        }
    }

    private static double getFirstEquation(double x) {
        return Math.pow(x, 3) - 0.2 * (Math.pow(x, 2)) + 0.5 * x + 1.5;
    }

    private static double getFirstDerivative(double x){
        return 3 * Math.pow(x,2) - 0.4*x + 0.5;
    }

    private static double getFirstDoubleDerivative(double x){
        return 6 * x - 0.4;
    }

    private static double getSecondEquation(double x) {
        return Math.pow(Math.E, -x) - (1.0 / 2.0 * Math.pow(Math.sin(x), 2));
    }

    private static double getSecondDerivative(double x){
        return -((1+Math.pow(Math.E, x)*Math.sin(x)*Math.cos(x))/Math.pow(Math.E, x));
    }

    private static double getSecondDoubleDerivative(double x){
        return 1/Math.pow(Math.E, x) - Math.cos(2*x);
    }

    private static double getThirdEquation(double x) {
        return Math.tan(0.55 * x + 0.1) - Math.pow(x, 2);
    }

    private static double getThirdDerivative(double x){
        return (11)/(20*Math.pow(Math.cos(11/20*x+0.1), 2)) - 2*x;
    }

    private static double getThirdDoubleDerivative(double x){
        return (121*Math.sin(11/20*x + 0.1))/(200*Math.pow(Math.cos(11/20*x+0.1), 3)) - 2;
    }

    private static double getFourthEquation(double x) {
        return (1 + Math.pow(x, 2)) * Math.pow(Math.E, -x) + Math.sin(x);
    }

    private static double getFourthDerivative(double x){
        return (2 * x - 1 - Math.pow(x,2) + Math.pow(Math.E, x)*Math.cos(x))/(Math.pow(Math.E, x));
    }

    private static double getFourthDoubleDerivative(double x){
        return (Math.pow(x,2) - 4*x + 3)/(Math.pow(Math.E, x)) - Math.sin(x);
    }

    private static double getFifthEquation(double x) {
        return 4 * Math.sin(x) + 1 - x;
    }

    private static double getFifthDerivative(double x){
        return 4 * Math.cos(x) - 1;
    }

    private static double getFifthDoubleDerivative(double x){
        return -4 * Math.sin(x);
    }

    public static double[] maxValueOfDerivativeOnInterval(double a, double b){
        double maxY = Math.abs(getDerivative(a));
        double maxX = a;
        for (double i = a; i <= b; i += 0.0001) {
            double value = Math.abs(getDerivative(i));
            if (maxY < value) {
                maxY = value;
                maxX = i;
            }
        }
        return new double[]{maxX, maxY};
    }

    public static void setLambda(double a, double b) {
        lambda = -1 / maxValueOfDerivativeOnInterval(a, b)[1];
    }

    public static double getPhi(double x){
        return x + lambda * getEquation(x);
    }

}
