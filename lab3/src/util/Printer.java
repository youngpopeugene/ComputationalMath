package util;

import storage.FunctionStorage;

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

    public static void printFunctions() {
        System.out.println(Printer.getYellowText("[1] 2*x^3 - 9*x^2 + 3*x + 11"));
        System.out.println(Printer.getYellowText("[2] 3*x^5 + x^2 + 0.1"));
        System.out.println(Printer.getYellowText("[3] sin(x) + cos(x)"));
        System.out.println(Printer.getYellowText("[4] 1 / x"));
        System.out.print(getBlueText("""
                    Your choice:\s"""));
    }

    public static void printMethods() {
        System.out.println(Printer.getYellowText("[1] Rectangle method"));
        System.out.println(Printer.getYellowText("[2] Trapezoid method"));
        System.out.println(Printer.getYellowText("[3] Simpson method"));
        System.out.print(getBlueText("""
                Your choice:\s"""));
    }

    public static void printRectangleMethods() {
        System.out.println(Printer.getYellowText("[1] Right rectangles"));
        System.out.println(Printer.getYellowText("[2] Left rectangles"));
        System.out.println(Printer.getYellowText("[3] Medium rectangles"));
        System.out.print(getBlueText("""
                Your choice:\s"""));
    }

    public static void printResult(double a, double b, int n, double integral1, double accuracy, double error){
        System.out.println(getGreenText("—————————————————RESULT—————————————————"));
        System.out.println(getGreenText("Standart I = " + FunctionStorage.getIntegral(a, b)));
        System.out.println(getGreenText("Calculated I = " + integral1));
        System.out.println(getGreenText("Absolute error = " + error));
        System.out.println(getGreenText("Relative error = " + 100 * Math.abs(error/(FunctionStorage.getIntegral(a, b))) + " %"));
        System.out.println(getGreenText("ε = " + accuracy));
        System.out.println(getGreenText("n = " + n));
        System.out.println(getGreenText("————————————————————————————————————————"));
    }



}
