public class Main {
    public static void main(String[] args) {
        double[][] matrix = Initialization.init();
        Printer.printInitialMatrix(matrix);

        double[][] triangleMatrix = GaussMethod.calculateTriangleMatrix(matrix);
        if(triangleMatrix != null) {
            Printer.printTriangleMatrix(triangleMatrix);

            double determinant = GaussMethod.calculateDeterminant(triangleMatrix);
            Printer.printDeterminant(determinant);

            if (determinant != 0) {
                double[] solutions = GaussMethod.calculateSolutions(triangleMatrix);
                Printer.printSolutions(solutions);

                double[] rv = GaussMethod.calculateResidualVector(matrix, solutions);
                Printer.printResidualVector(rv);
            }
            else
                System.out.println(Printer.getRedText("The system has an infinite number of solutions!"));
        }
        else System.out.println(Printer.getRedText("Error in matrix calculation or system has no solutions!"));

    }
}