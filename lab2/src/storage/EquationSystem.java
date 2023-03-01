package storage;

public interface EquationSystem {
    double getFirstEquation(double x, double y);
    double getSecondEquation(double x, double y);
    double getDerivativeXOfFirstEquation(double x, double y);
    double getDerivativeXOfSecondEquation(double x, double y);
    double getDerivativeYOfFirstEquation(double x, double y);
    double getDerivativeYOfSecondEquation(double x, double y);
}
