package storage;

public class EquationSystemStorage {

    private static int numberOfEquationSystem;

    public static void setNumberOfEquationSystem(int numberOfEquationSystem) {
        EquationSystemStorage.numberOfEquationSystem = numberOfEquationSystem;
    }

    public static int getNumberOfEquationSystem() {
        return numberOfEquationSystem;
    }

    public static EquationSystem getEquationSystem(){
        switch(numberOfEquationSystem){
            case 1 -> {
                return new FirstEquationSystem();
            }
            case 2 -> {
                return new SecondEquationSystem();
            }
            default -> {
                return new ThirdEquationSystem();
            }
        }
    }

}
