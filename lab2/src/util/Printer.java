package util;

import storage.EquationStorage;
import storage.EquationSystemStorage;

public class Printer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public static String getRedText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    public static String getGreenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    public static String getBlueText(String text) {
        return ANSI_BLUE + text + ANSI_RESET;
    }

    public static String getYellowText(String text) {
        return ANSI_YELLOW + text + ANSI_RESET;
    }

    public static void printEquations() {
        System.out.println(Printer.getYellowText(
                "[1] х^3 – 0,2x^2 + 0,5x + 1,5 = 0\n" +
                        "[2] e^(-x) - 1/2 * sin^2(x) = 0\n" +
                        "[3] tg(0,55x + 0,1) - x^2 = 0\n" +
                        "[4] (1 + x^2) * e^(-x) + sin(x) = 0\n" +
                        "[5] 4 * sin(x) + 1 - x = 0"));
    }

    public static void printEquationSystems() {
        System.out.println(Printer.getYellowText(
                "[1] sin(x - 0,6) - y = 1,6\n" +
                "    3x - cos(y) = 0,9\n\n" +
                "[2] cos(x) + y = 1,5\n" +
                "    2x - sin(y - 0,5) = 1\n\n" +
                "[3] x + y^2 = 2\n" +
                "    x^2 + y = 2"));
    }

    public static void printResult(double x, int i){
        System.out.println(getGreenText("—————————————————RESULT—————————————————"));
        System.out.println(getGreenText("x = " + x));
        System.out.println(getGreenText("f(x) = " + EquationStorage.getEquation(x)));
        System.out.println(getGreenText("Number of iterations: " + i));
        System.out.println(getGreenText("————————————————————————————————————————"));
    }

    public static void printSystemResult(double x, double y, int i){
        System.out.println(getGreenText("—————————————————RESULT—————————————————"));
        System.out.println(getGreenText("x = " + x));
        System.out.println(getGreenText("y = " + y));
        System.out.println(getGreenText("f1(x,y) = " + EquationSystemStorage.getEquationSystem().getFirstEquation(x, y)));
        System.out.println(getGreenText("f2(x,y) = " + EquationSystemStorage.getEquationSystem().getSecondEquation(x, y)));
        System.out.println(getGreenText("Number of iterations: " + i));
        System.out.println(getGreenText("————————————————————————————————————————"));
    }
}

