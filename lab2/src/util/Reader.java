package util;

import storage.EquationStorage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    public static int readTypeOfInput(){
        System.out.println(Printer.getBlueText("Choose: non-linear equation [1] or system of non-linear equations [2]"));

        Scanner scanner = new Scanner(System.in);
        String typeOfInput = scanner.nextLine();
        isOver(typeOfInput);

        while (!(typeOfInput.equals("1") || typeOfInput.equals("2"))) {
            System.out.println(Printer.getRedText("Error!"));
            System.out.println(Printer.getBlueText("Choose: non-linear equation [1] or system of non-linear equations [2]"));
            typeOfInput = scanner.nextLine();
            isOver(typeOfInput);

        }
        return Integer.parseInt(typeOfInput);
    }

    public static int readNumberOfEquation(){
        System.out.println(Printer.getBlueText("Input number of non-linear equation:"));
        Printer.printEquations();

        Scanner scanner = new Scanner(System.in);
        String numberOfEquation = scanner.nextLine();
        isOver(numberOfEquation);

        while (!(numberOfEquation.equals("1") || numberOfEquation.equals("2") || numberOfEquation.equals("3") || numberOfEquation.equals("4") || numberOfEquation.equals("5"))) {
            System.out.println(Printer.getRedText("Error!"));
            System.out.println(Printer.getBlueText("Input number of non-linear equation:"));
            Printer.printEquations();
            numberOfEquation = scanner.nextLine();
            isOver(numberOfEquation);

        }
        return Integer.parseInt(numberOfEquation);
    }

    public static int readNumberOfEquationSystem() {
        System.out.println(Printer.getBlueText("Input number of system of non-linear equations:"));
        Printer.printEquationSystems();

        Scanner scanner = new Scanner(System.in);
        String numberOfEquationSystem = scanner.nextLine();
        isOver(numberOfEquationSystem);

        while (!(numberOfEquationSystem.equals("1") || numberOfEquationSystem.equals("2") || numberOfEquationSystem.equals("3"))) {
            System.out.println(Printer.getRedText("Error!"));
            System.out.println(Printer.getBlueText("Input number of system of non-linear equations:"));
            Printer.printEquationSystems();
            numberOfEquationSystem = scanner.nextLine();
            isOver(numberOfEquationSystem);

        }
        return Integer.parseInt(numberOfEquationSystem);
    }

    public static int readTypeOfMethod() {
        System.out.println(Printer.getBlueText("Input type of method:"));
        System.out.println(Printer.getYellowText("[1] Chord method"));
        System.out.println(Printer.getYellowText("[2] Newton's method"));
        System.out.println(Printer.getYellowText("[3] Simple iteration method"));

        Scanner scanner = new Scanner(System.in);
        String numberOfEquation = scanner.nextLine();
        isOver(numberOfEquation);

        while (!(numberOfEquation.equals("1") || numberOfEquation.equals("2") || numberOfEquation.equals("3"))) {
            System.out.println(Printer.getRedText("Error!"));
            System.out.println(Printer.getBlueText("Input type of method:"));
            System.out.println(Printer.getYellowText("[1] Chord method"));
            System.out.println(Printer.getYellowText("[2] Newton's method"));
            System.out.println(Printer.getYellowText("[3] Simple iteration method"));
            numberOfEquation = scanner.nextLine();
            isOver(numberOfEquation);

        }
        return Integer.parseInt(numberOfEquation);
    }

    private static double[] readInterval() {
        double[] values = new double[2];
        while(true){
            try{
                System.out.println(Printer.getBlueText("Input a (left border):"));
                Scanner scanner = new Scanner(System.in);
                double a = scanner.nextDouble();
                values[0] = a;
                break;
            }catch(InputMismatchException e){
                System.out.println(Printer.getRedText("Error!"));
                System.out.println(Printer.getRedText("Don't use dot as delimiter, you have to use comma"));
            }
        }
        while(true){
            try{
                System.out.println(Printer.getBlueText("Input b (right border):"));
                Scanner scanner = new Scanner(System.in);
                double b = scanner.nextDouble();
                values[1] = b;
                break;
            }catch(InputMismatchException e){
                System.out.println(Printer.getRedText("Error!"));
                System.out.println(Printer.getRedText("Don't use dot as delimiter, you have to use comma"));
            }
        }
        return values;
    }

    public static double[] readIntervalMultipleTimes() {
        double[] values = readInterval();
        while (values[0] >= values[1]) {
            System.out.println(Printer.getRedText("Error!"));
            System.out.println(Printer.getRedText("a cannot be greater than b"));
            values = Reader.readInterval();
        }
        return values;
    }

    public static double[] readInitialApproximation() {
        double[] values = new double[2];
        while(true){
            try{
                System.out.println(Printer.getBlueText("Input initial approximation [x]:"));
                Scanner scanner = new Scanner(System.in);
                double x = scanner.nextDouble();
                values[0] = x;
                break;
            }catch(InputMismatchException e){
                System.out.println(Printer.getRedText("Error!"));
                System.out.println(Printer.getRedText("Don't use dot as delimiter, you have to use comma"));
            }
        }
        while(true){
            try{
                System.out.println(Printer.getBlueText("Input initial approximation [y]:"));
                Scanner scanner = new Scanner(System.in);
                double y = scanner.nextDouble();
                values[1] = y;
                break;
            }catch(InputMismatchException e){
                System.out.println(Printer.getRedText("Error!"));
                System.out.println(Printer.getRedText("Don't use dot as delimiter, you have to use comma"));
            }
        }
        return values;
    }


    public static double readAccuracy() {
        while(true){
            try{
                System.out.println(Printer.getBlueText("Input accuracy:"));
                Scanner scanner = new Scanner(System.in);
                double accuracy = scanner.nextDouble();
                if (accuracy >= 1 || accuracy <= 0) throw new InputMismatchException();
                else return accuracy;
            }catch(InputMismatchException e){
                System.out.println(Printer.getRedText("Error!"));
                System.out.println(Printer.getRedText("Don't use dot as delimiter, you have to use comma"));
                System.out.println(Printer.getRedText("Accuracy have to be greater than 0 and less than 1"));
            }
        }
    }

    private static void isOver(String string){
        if (string.equals("/exit")){
            System.exit(0);
        }
    }
}
