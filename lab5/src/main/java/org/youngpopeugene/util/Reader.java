package org.youngpopeugene.util;

import org.youngpopeugene.entity.Functions;
import org.youngpopeugene.methods.Polynomial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Reader {
    private final Scanner scanner = new Scanner(System.in);

    public void readInput(){
        System.out.println(Printer.getBlueText("Choose type of input:"));
        System.out.println(Printer.getYellowText("1. Table"));
        System.out.println(Printer.getYellowText("2. File"));
        System.out.println(Printer.getYellowText("3. Function"));

        int typeOfInput = Integer.parseInt(scanner.nextLine());

        ArrayList<Double[]> values = new ArrayList<>();
        double x;

        switch(typeOfInput){
            case 1 -> {
                System.out.println(Printer.getBlueText("Enter number of values:"));
                System.out.println(Printer.getYellowText("n > 2"));
                int n = Integer.parseInt(scanner.nextLine());
                while (n < 3){
                    System.out.println(Printer.getBlueText("Enter number of values:"));
                    System.out.println(Printer.getYellowText("n > 2"));
                    n = Integer.parseInt(scanner.nextLine());
                }

                System.out.println(Printer.getBlueText("Enter table:"));
                System.out.println(Printer.getYellowText("x1 y1"));
                System.out.println(Printer.getYellowText("x2 y2"));
                System.out.println(Printer.getYellowText("... ..."));

                HashSet<Double> setX = new HashSet<>();
                for (int i = 0; i < n; ++i){
                    String[] line = scanner.nextLine().split(" ");
                    Double[] xy = new Double[2];
                    xy[0] = Double.parseDouble(line[0]);

                    if (setX.contains(xy[0])) {
                        n++;
                        System.out.println(Printer.getRedText("Such X is already existed"));
                        continue;
                    }

                    setX.add(xy[0]);
                    xy[1] = Double.parseDouble(line[1]);
                    values.add(xy);
                }

                System.out.println(Printer.getBlueText("Enter X coordinate to find an approximate value:"));
                x = Double.parseDouble(scanner.nextLine());
                while(setX.contains(x)){
                    System.out.println(Printer.getBlueText("Enter X coordinate to find an approximate value:"));
                    x = Double.parseDouble(scanner.nextLine());
                }

                Polynomial.setX(x);
                Polynomial.setValues(values);
            }
            case 3 -> {
                Printer.printFunctions();

                int numberOfFunction = Integer.parseInt(scanner.nextLine());
                while(numberOfFunction < 1 || numberOfFunction > 3){
                    Printer.printFunctions();
                    numberOfFunction = Integer.parseInt(scanner.nextLine());
                }
                Functions.setNumberOfFunction(numberOfFunction);

                System.out.println(Printer.getBlueText("Enter number of values:"));
                System.out.println(Printer.getYellowText("n > 2"));
                int n = Integer.parseInt(scanner.nextLine());
                while (n < 3){
                    System.out.println(Printer.getBlueText("Enter number of values:"));
                    System.out.println(Printer.getYellowText("n > 2"));
                    n = Integer.parseInt(scanner.nextLine());
                }

                System.out.println(Printer.getBlueText("Enter list of x:"));
                System.out.println(Printer.getYellowText("x1"));
                System.out.println(Printer.getYellowText("x2"));
                System.out.println(Printer.getYellowText("..."));
                HashSet<Double> setX = new HashSet<>();
                for (int i = 0; i < n; ++i){
                    Double[] xy = new Double[2];
                    xy[0] = Double.parseDouble(scanner.nextLine());

                    if (xy[0] <= 0 && numberOfFunction == 3){
                        n++;
                        System.out.println(Printer.getRedText("X cannot be negative or equal zero because chosen function is ln(x)"));
                        continue;
                    }

                    if (setX.contains(xy[0])) {
                        n++;
                        System.out.println(Printer.getRedText("Such X is already existed"));
                        continue;
                    }

                    setX.add(xy[0]);
                    xy[1] = Functions.f(xy[0]);
                    values.add(xy);
                }

                System.out.println(Printer.getBlueText("Enter X coordinate to find an approximate value:"));
                x = Double.parseDouble(scanner.nextLine());
                while(setX.contains(x)){
                    System.out.println(Printer.getBlueText("Enter X coordinate to find an approximate value:"));
                    x = Double.parseDouble(scanner.nextLine());
                }

                Polynomial.setX(x);
                Polynomial.setValues(values);
            }
            default -> {
                readInput();
            }
        }

    }


}
