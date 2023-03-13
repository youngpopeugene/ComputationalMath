import methods.MethodHandler;
import methods.RectangleMethod;
import storage.FunctionStorage;
import util.Printer;
import util.Reader;

import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        int numberOfFunction = Reader.readNumberOfFunction();
        FunctionStorage.setNumberOfFunction(numberOfFunction);
        int typeOfMethod = Reader.readTypeOfMethod();
        MethodHandler.setTypeOfMethod(typeOfMethod);
        if (typeOfMethod == 1) RectangleMethod.setTypeOfRectangleMethod(Reader.readTypeOfRectangleMethod());
        double[] ab = Reader.readAB();
        double accuracy = Reader.readAccuracy();
        try {
            MethodHandler.execute(ab[0], ab[1], accuracy);
        }catch (TimeoutException e){
            System.out.println(Printer.getRedText("Error!"));
            System.out.println(Printer.getRedText("There is a discontinuity of the first kind in the selected interval"));
        }
    }
}