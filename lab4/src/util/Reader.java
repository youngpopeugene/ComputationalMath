package util;

import entity.Dot;

import java.util.Scanner;

public class Reader {
    Scanner scanner = new Scanner(System.in);

    public static Dot[] readDots() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Printer.getBlueText("""
                Input number of dots:\s"""));
        int n = Integer.parseInt(scanner.nextLine());
        Dot[] dots = new Dot[n];
        System.out.println(Printer.getBlueText("Input dots:"));
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] xy = line.trim().split(" ");
            double x = Double.parseDouble(xy[0].replace(",", "."));
            double y = Double.parseDouble(xy[1].replace(",", "."));
            dots[i] = new Dot(x, y);
        }
        return dots;
    }
}