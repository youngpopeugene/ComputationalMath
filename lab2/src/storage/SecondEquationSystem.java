package storage;

public class SecondEquationSystem implements EquationSystem{
    @Override
    public double getFirstEquation(double x, double y) {
        return Math.cos(x) + y - 1.5;
    }

    @Override
    public double getSecondEquation(double x, double y) {
        return 2 * x - Math.sin(y - 0.5) - 1;
    }

    @Override
    public double getDerivativeXOfFirstEquation(double x, double y) {
        return -Math.sin(x);
    }

    @Override
    public double getDerivativeXOfSecondEquation(double x, double y) {
        return 2;
    }

    @Override
    public double getDerivativeYOfFirstEquation(double x, double y) {
        return 1;
    }

    @Override
    public double getDerivativeYOfSecondEquation(double x, double y) {
        return -Math.cos(y - 0.5);
    }
}
