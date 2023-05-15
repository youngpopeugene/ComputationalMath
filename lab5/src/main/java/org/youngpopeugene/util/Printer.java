package org.youngpopeugene.util;

import org.youngpopeugene.methods.Polynomial;

import java.util.ArrayList;

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
        System.out.println(getBlueText("Choose function:"));
        System.out.println(getYellowText("1. x^2 + 239"));
        System.out.println(getYellowText("2. 2^x - x + 1"));
        System.out.println(getYellowText("3. ln(x)"));
    }

    private static void printLagrangeResult(double result) {
        System.out.printf(getGreenText("%-10s %.5f\n"),"Lagrange:", result);
    }

    private static void printNewtonResult(double result) {
        System.out.printf(getGreenText("%-10s %.5f\n"),"Newton:", result);
    }

    public static void printResult(double lagrangeResult, double newtonResult) {
        System.out.println();
        System.out.println(getGreenText("———————RESULT———————"));
        printLagrangeResult(lagrangeResult);
        printNewtonResult(newtonResult);
        System.out.println();
    }

    public static void printFiniteDifferenceTable() {
        System.out.println(getGreenText("————————————————————Finite Difference Table————————————————————"));
        ArrayList<Double[]> values = Polynomial.getValues();
        ArrayList<ArrayList<Double>> table = new ArrayList<>();
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        for (Double[] value: values){
            x.add(value[0]);
            y.add(value[1]);
        }
        table.add(x);
        table.add(y);
        int n = values.size();
        for(int i = 0; i < values.size() - 1; i++){
            ArrayList<Double> delta = new ArrayList<>();
            for(int j = 0; j < n - 1; j++){
                delta.add(table.get(table.size() - 1).get(j + 1) - table.get(table.size() - 1).get(j));
            }
            table.add(delta);
            n--;
        }

        int numRows = table.size();
        int numColumns = table.get(0).size();
        System.out.printf(getYellowText("%-4s\t"), "x");
        System.out.printf(getYellowText("%-4s\t"), "y");
        for (int row = 2; row < numRows; row++) {
            String str = String.valueOf(row-1);
            System.out.printf(getYellowText("%-4s\t"), "Δ^" + str + "y" );
        }
        System.out.println();
        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows; row++) {
                try{
                    System.out.printf(getGreenText("%-4.3f\t"), table.get(row).get(col));
                }catch(IndexOutOfBoundsException e){
                    System.out.printf(getRedText("%-4f\t"), null);
                }
            }
            System.out.println();
        }

    }
}