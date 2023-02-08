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

    public static void printMatrix(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf(getGreenText("%8.2f\t"), matrix[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printInitialMatrix(double[][] initialMatrix){
        System.out.println(Printer.getYellowText("\nInitial matrix:"));
        printMatrix(initialMatrix);
    }
    public static void printTriangleMatrix(double[][] triangleMatrix){
        System.out.println(Printer.getBlueText("Triangle matrix: "));
        printMatrix(triangleMatrix);
    }

    public static void printDeterminant(double determinant){
        System.out.println(Printer.getBlueText("Matrix determinant: "));
        System.out.printf(Printer.getGreenText("%8.2f\t\n\n"), determinant);
    }

    public static void printSolutions(double[] solutions){
        System.out.println(Printer.getBlueText("Solutions for SLAE: "));
        for (double v : solutions) System.out.printf(Printer.getGreenText("%8.2f\t"), v);
        System.out.println("\n");
    }

    public static void printResidualVector(double[] rv){
        System.out.println(Printer.getBlueText("Residual vector: "));
        for (double i : rv) System.out.printf(Printer.getGreenText("%8.2f\t"), i);
        System.out.println();
    }
}
