package org.youngpopeugene.math;

public class Functions {
    private static int functionNumber;

    public static void setFunctionNumber(int functionNumber) {
        Functions.functionNumber = functionNumber;
    }

    public static double f(double x, double y) {
        switch (functionNumber) {
            case (1) -> {
                return 6 * Math.pow(x, 2) + 5 * x * y;
            }
            case (2) -> {
                return x + Math.cos(y / Math.sqrt(5));
            }
            default -> {
                return y + (1 + x) * (y * y);
            }
        }
    }
}