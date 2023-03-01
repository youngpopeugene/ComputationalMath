package storage;

public class ThirdEquationSystem implements EquationSystem{
    @Override
    public double getFirstEquation(double x, double y) {
        return x + Math.pow(y, 2) - 2;
    }

    @Override
    public double getSecondEquation(double x, double y) {
        return Math.pow(x, 2) + y - 2;
    }

    @Override
    public double getDerivativeXOfFirstEquation(double x, double y) {
        return 1;
    }

    @Override
    public double getDerivativeXOfSecondEquation(double x, double y) {
        return 2 * x;
    }

    @Override
    public double getDerivativeYOfFirstEquation(double x, double y) {
        return 2 * y;
    }

    @Override
    public double getDerivativeYOfSecondEquation(double x, double y) {
        return 1;
    }
}
