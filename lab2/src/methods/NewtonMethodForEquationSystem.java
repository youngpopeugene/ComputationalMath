package methods;


import storage.EquationSystem;
import storage.EquationSystemStorage;
import util.Printer;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import static java.lang.Math.abs;

public class NewtonMethodForEquationSystem {
    public static void execute(double x_0, double y_0, double accuracy) throws NoSuchElementException, TimeoutException {
        double x_i = x_0;
        double y_i = y_0;
        int i = 0;
        EquationSystem equationSystem = EquationSystemStorage.getEquationSystem();
        double[][] matrix = new double[2][3];

        while(true){
            matrix[0][0] = equationSystem.getDerivativeXOfFirstEquation(x_i, y_i);
            matrix[0][1] = equationSystem.getDerivativeYOfFirstEquation(x_i, y_i);
            matrix[0][2] = - equationSystem.getFirstEquation(x_i, y_i);
            matrix[1][0] = equationSystem.getDerivativeXOfSecondEquation(x_i, y_i);
            matrix[1][1] = equationSystem.getDerivativeYOfSecondEquation(x_i, y_i);
            matrix[1][2] = - equationSystem.getSecondEquation(x_i, y_i);
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.printf(Printer.getGreenText("%8.2f\t"), matrix[row][col]);
                }
                System.out.println();
            }
            System.out.println();
            double[] results = MatrixGaussMethod.calculateSolutions(matrix);
            x_i += results[0];
            y_i += results[1];
            System.out.println(results[0] + " " + results[1]);
            i++;
            if (i >= 1000) throw new TimeoutException();
            if(Math.abs(results[0]) < accuracy || Math.abs(results[1]) < accuracy) break;
        }

        Printer.printSystemResult(x_i, y_i, i);
    }

    private static class MatrixGaussMethod{
        static Integer findMaxColumnElement(double[][] matrix, int i) throws NoSuchElementException{
            int n = matrix.length;
            int point = 0;
            double max = 0;
            for (int j = i; j < n; j++) {
                if (max < abs(matrix[j][i])) {
                    max = abs(matrix[j][i]);
                    point = j;
                }
            }
            if (max == 0) throw new NoSuchElementException();
            return point;
        }

        static double[][] calculateTriangleMatrix(double[][] matrix) throws NoSuchElementException{
            int n = matrix.length;
            for(int i = 0; i < n; i++) {

                Integer point = findMaxColumnElement(matrix, i);

                for (int j = i; j <= n; j++) {
                    double temp = matrix[i][j];
                    matrix[i][j] = matrix[point][j];
                    matrix[point][j] = temp;
                }

                for (int k = n; k >= i; k--)
                    matrix[i][k] /= matrix[i][i];


                for (int j = i + 1; j < n; j++){
                    double k = matrix[i][i]/matrix[j][i];
                    for (int l = i; l <= n; l++) {
                        matrix[j][i] = matrix[j][l]*k - matrix[i][l];
                    }
                }

            }
            return matrix;
        }

        static double[] calculateSolutions(double[][] matrix) throws NoSuchElementException{
            double[][] triangleMatrix = calculateTriangleMatrix(matrix);
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
    }
}

