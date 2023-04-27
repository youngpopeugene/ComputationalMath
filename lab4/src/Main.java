import entity.Dot;
import entity.DotCollection;
import util.Drawer;
import util.Printer;
import util.Reader;
import work.Approximation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Printer.printInputExample();
        Dot[] dots = Reader.readDots();
        DotCollection.setDots(dots);
        Approximation.run();
        Printer.printResult(Approximation.getFinalNumberApprox());
        Drawer.draw();
    }
}