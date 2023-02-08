public class Initialization {
    public static double[][] init(){
        System.out.println(Printer.getRedText("GAUSS METHOD with the choice of the main element by columns"));
        System.out.println(Printer.getYellowText("If you want to stop program execution type \\exit in console"));
        while(true) {
            System.out.println(Printer.getBlueText("Enter type of input: keyboard [k] or file [f]"));
            String typeOfInput = Reader.readTypeOfInput();
            switch (typeOfInput) {
                case "k":
                case "keyboard": {
                    System.out.println(Printer.getBlueText("Enter size of matrix: "));
                    int size = Reader.readSize();
                    System.out.println(Printer.getBlueText("Enter matrix: "));
                    return Reader.loopReadMatrix(size);
                }
                case "f":
                case "file": {
                    double[][] matrix = Reader.readMatrixFromFile(Reader.readFileName());
                    if (matrix != null) return matrix;
                }
            }
        }
    }

}
