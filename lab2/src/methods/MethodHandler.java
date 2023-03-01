package methods;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class MethodHandler {
    public static void execute(double a, double b, double accuracy, int typeOfMethod)  throws TimeoutException {
        switch(typeOfMethod){
            case 1 -> {
                ChordMethod.execute(a, b, accuracy);
            }
            case 2 -> {
                NewtonMethod.execute(a, b, accuracy);
            }
            case 3 -> {
                SimpleIterationMethod.execute(a, b, accuracy);
            }
        }
    }
}
