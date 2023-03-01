package util;

import storage.EquationStorage;

public class IntervalValidator {
    public static int countRootsInInterval(double a, double b){
        int roots = 0;
        for (double i = a; i <= b; i += 0.0001) {
            if(EquationStorage.getEquation(i) * EquationStorage.getEquation(i + 0.0001) < 0){
                roots++;
            }
        }
        return roots;
    }
}
