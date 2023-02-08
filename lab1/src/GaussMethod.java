import static java.lang.Math.abs;

public class GaussMethod {
    public static double calculateDeterminant(double[][] triangleMatrix) {
        double det = 1;
        int size = triangleMatrix.length;
        for(int i = 0; i < size; i++)
            det = det * triangleMatrix[i][i];
        return det;
    }

    public static double[] calculateSolutions(double[][] triangleMatrix) {
        int size = triangleMatrix.length;
        double[] solutions = new double[size];
        for(int i = size - 1; i >= 0; i--){
            double root = triangleMatrix[i][size];
            for(int j = i + 1; j < size; j++){
                root -= solutions[j] * triangleMatrix[i][j];
            }
            solutions[i] = root/triangleMatrix[i][i];
        }
        return solutions;
    }

    public static double[] calculateResidualVector(double[][] matrix, double[] x) {
        int n = matrix.length;
        double[] dis = new double[n];
        for(int i = 0; i < n; i++){
            double r = matrix[i][n];
            for(int j = 0; j < n; j++){
                r -= matrix[i][j]*x[j];
            }
            dis[i] = r;
        }
        return dis;
    }

    public static Integer findMaxColumnElement(double[][] matrix, int i){
        int n = matrix.length;
        int point = 0;
        double max = 0;
        for (int j = i; j < n; j++) {
            if (max < abs(matrix[j][i])) {
                max = abs(matrix[j][i]);
                point = j;
            }
        }
        System.out.printf(Printer.getYellowText("Max column element: %.2f\t\n"), max);
        if (max == 0) return null;
        return point;
    }

    public static double[][] calculateTriangleMatrix(double[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++) {
            System.out.println(Printer.getBlueText("Iteration № " + (i+1)));

            Integer point = findMaxColumnElement(matrix, i);

            if (point == null) return null;

            if(point != i) System.out.println(Printer.getYellowText("Swapping lines №" + (point + 1) + " and № " + (i+1)));
            else System.out.println(Printer.getYellowText("No swapping required"));

            for (int j = i; j <= n; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[point][j];
                matrix[point][j] = temp;
            }

            System.out.println(Printer.getYellowText("After swapping:"));
            Printer.printMatrix(matrix);

            for (int k = n; k >= i; k--)
                matrix[i][k] = matrix[i][k] / matrix[i][i];

            for (int k = i + 1; k < n; k++)
                for (int j = n; j >= i; j--) {
                    matrix[k][j] -= matrix[k][i] * matrix[i][j];
                }

            System.out.println(Printer.getYellowText("After matrix transformation №" + (i+1)));
            Printer.printMatrix(matrix);
        }
        return matrix;
    }
}