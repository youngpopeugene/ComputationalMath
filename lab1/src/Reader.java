import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private static int size;
    public static int getSize() {
        return size;
    }
    public static int readSize() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String sizeString = scanner.nextLine();

                isOver(sizeString);

                size = Integer.parseInt(sizeString);
                if(size >= 2 && size <= 20){
                    return size;
                }else{
                    System.out.println(Printer.getRedText("Error! Size of matrix has to be greater than 2 and less than 20"));
                    System.out.println(Printer.getBlueText("Enter size of matrix: "));
                }
            } catch (NumberFormatException e){
                System.out.println(Printer.getRedText("Error! Size of matrix has to be an integer"));
                System.out.println(Printer.getBlueText("Enter size of matrix: "));
            }
        }
    }

    private static double[][] readMatrix(int size){
        double[][] matrix = new double[size][size+1];
        for (int i = 0; i < size; i++) {
            Scanner scanner = new Scanner(System.in);
            String row  = scanner.nextLine();
            String[] rowElements = row.split(" ");

            isOver(rowElements[0]);

            if (rowElements.length != size + 1) {
                System.out.println(Printer.getRedText("Error! The given size doesn't correspond to the real one"));
                return null;
            }

            for(int j = 0; j < rowElements.length; j++) {
                try{
                    matrix[i][j] = Double.parseDouble(rowElements[j]);
                } catch (NumberFormatException e){
                    System.out.println(Printer.getRedText("Error! Matrix consists of double numbers"));
                    return null;
                }
            }
        }
        return matrix;
    }

    public static double[][] loopReadMatrix(int size){
        double[][] matrix = readMatrix(size);
        while(matrix == null){
            System.out.println(Printer.getBlueText("Enter matrix: "));
            matrix = readMatrix(size);
        }
        return matrix;
    }

    public static String readTypeOfInput(){
        Scanner scanner = new Scanner(System.in);
        String typeOfInput = scanner.nextLine();

        isOver(typeOfInput);

        while (!(typeOfInput.equals("keyboard") || typeOfInput.equals("k") || typeOfInput.equals("f") || typeOfInput.equals("file"))) {
            System.out.println(Printer.getRedText("Error!"));
            System.out.println(Printer.getBlueText("Enter type of file1: keyboard [k] or file [f]"));
            typeOfInput = scanner.nextLine();

            isOver(typeOfInput);

        }
        return typeOfInput;
    }

    public static double[][] readMatrixFromFile(List<String> list){
        size = Integer.parseInt(list.get(0));
        double[][] matrix = new double[size][size+1];
        for (int i = 1; i < list.size(); i++) {
            String row = list.get(i);
            String[] rowElements = row.split(" ");

            if (rowElements.length != size + 1){
                System.out.println(Printer.getRedText("Error! The given size doesn't correspond to the real one"));
                return null;
            }

            for(int j = 0; j < rowElements.length; j++) {
                try{
                    matrix[i-1][j] = Double.parseDouble(rowElements[j]);
                } catch (NumberFormatException e){
                    System.out.println(Printer.getRedText("Error! Matrix consists of double numbers"));
                    return null;
                }
            }
        }
        return matrix;
    }

    public static List<String> readFileName(){
        List<String> list = null;
        while(list == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Printer.getBlueText("Enter name of file:"));
            String fileName = scanner.nextLine();

            isOver(fileName);

            try {
                list = Files.readAllLines(Paths.get("files/" + fileName));
            } catch (IOException e) {
                list = null;
                System.out.println(Printer.getRedText("Error! No such file"));
            }
        }
        return list;
    }

    private static void isOver(String string){
        if (string.equals("/exit")){
            System.exit(0);
        }
    }
}
