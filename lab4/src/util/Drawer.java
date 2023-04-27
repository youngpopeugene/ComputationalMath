package util;

import entity.DotCollection;
import work.Approximation;

import java.io.File;
import java.io.IOException;

public class Drawer {

    public static void draw() throws IOException {
        int finalNumberApprox = Approximation.getFinalNumberApprox();
        double[] finalCoefficients = Approximation.getFinalCoefficients();
        switch (finalNumberApprox) {
            case 2 -> new ProcessBuilder("python3"
                    , new File("plots/p" + finalNumberApprox + ".py").getAbsolutePath()
                    , String.format("%.4f", DotCollection.minX()).replace(",", ".")
                    , String.format("%.4f", DotCollection.maxX()).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[2]).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[1]).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[0]).replace(",", ".")
            ).start();
            case 3 -> new ProcessBuilder("python3"
                    , new File("plots/p" + finalNumberApprox + ".py").getAbsolutePath()
                    , String.format("%.4f", DotCollection.minX()).replace(",", ".")
                    , String.format("%.4f", DotCollection.maxX()).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[3]).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[2]).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[1]).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[0]).replace(",", ".")
            ).start();
            default -> new ProcessBuilder("python3"
                    , new File("plots/p" + finalNumberApprox + ".py").getAbsolutePath()
                    , String.format("%.4f", DotCollection.minX()).replace(",", ".")
                    , String.format("%.4f", DotCollection.maxX()).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[1]).replace(",", ".")
                    , String.format("%.4f", finalCoefficients[0]).replace(",", ".")
            ).start();
        }

        System.out.println(new File("plots/p" + finalNumberApprox + ".py").getAbsolutePath()
                + " " + String.format("%.4f", DotCollection.minX()).replace(",", ".")
                + " " + String.format("%.4f", DotCollection.maxX()).replace(",", ".")
                + " " + String.format("%.4f", finalCoefficients[1]).replace(",", ".")
                + " " + String.format("%.4f", finalCoefficients[0]).replace(",", ".")
        );
    }

}
