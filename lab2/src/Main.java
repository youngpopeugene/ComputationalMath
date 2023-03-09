import methods.MethodHandler;
import methods.NewtonMethodForEquationSystem;
import storage.EquationStorage;
import storage.EquationSystemStorage;
import util.IntervalValidator;
import util.Printer;
import util.Reader;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws IOException {
        int typeOfInput = Reader.readTypeOfInput();
        switch (typeOfInput) {
            case 1 -> {
                int numberOfEquation = Reader.readNumberOfEquation();
                EquationStorage.setNumberOfEquation(numberOfEquation);
                new ProcessBuilder("python3", new File("plots/equation" + numberOfEquation + ".py").getAbsolutePath()).start();
                int typeOfMethod = Reader.readTypeOfMethod();
                double accuracy = Reader.readAccuracy();
                double[] values = Reader.readIntervalMultipleTimes();
                int rootsCount = IntervalValidator.countRootsInInterval(values[0], values[1]);
                if (rootsCount > 1){
                    System.out.println(Printer.getRedText("Error!"));
                    System.out.println(Printer.getRedText("Too many roots on interval"));
                    return;
                }
                try{
                    MethodHandler.execute(values[0], values[1], accuracy, typeOfMethod);
                } catch(TimeoutException e){
                    System.out.println(Printer.getRedText("Error!"));
                    System.out.println(Printer.getRedText("Roots not found"));
                }
            }
            case 2 -> {
                int numberOfEquationSystem = Reader.readNumberOfEquationSystem();
                EquationSystemStorage.setNumberOfEquationSystem(numberOfEquationSystem);
                new ProcessBuilder("python3", new File("plots/equation_system" + numberOfEquationSystem + ".py").getAbsolutePath()).start();
                double accuracy = Reader.readAccuracy();
                double[] values = Reader.readInitialApproximation();
                try {
                    NewtonMethodForEquationSystem.execute(values[0], values[1], accuracy);
                } catch (NullPointerException | NoSuchElementException | TimeoutException e ) {
                    System.out.println(Printer.getRedText("Error!"));
                    System.out.println(Printer.getRedText("Roots not found"));
                }
            }
        }
    }
}