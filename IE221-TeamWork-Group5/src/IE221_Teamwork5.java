import java.util.*;
import java.io.*;

public class IE221_Teamwork5_FINAL {

    // Sabit seed → aynı koşu tekrar üretilebilir
    private static Random rand = new Random(42);

    public static void main(String[] args) {

        String[] distributions = {
                "Uniform",
                "Exponential",
                "Pareto_Alpha3",
                "Pareto_Alpha1.5",
                "Cauchy"
        };

        int[] cltNs = {2, 5, 10, 30, 50, 100};
        int replications = 1000;

        for (String dist : distributions) {
            runSLLN(dist, 10000);
            runCLT(dist, cltNs, replications);
        }

        System.out.println("Simulation completed. CSV files created.");
    }

    // ================= DISTRIBUTIONS =================

    public static double generate(String type) {
        double u = rand.nextDouble();
        switch (type) {
            case "Uniform":
                return u;
            case "Exponential":
                return -Math.log(1 - u);
            case "Pareto_Alpha3":
                return 1.0 / Math.pow(1 - u, 1.0 / 3.0);
            case "Pareto_Alpha1.5":
                return 1.0 / Math.pow(1 - u, 1.0 / 1.5);
            case "Cauchy":
                return Math.tan(Math.PI * (u - 0.5));
            default:
                return 0;
        }
    }

    // ================= MOMENTS =================

    public static Double mean(String dist) {
        switch (dist) {
            case "Uniform": return 0.5;
            case "Exponential": return 1.0;
            case "Pareto_Alpha3": return 1.5;
            case "Pareto_Alpha1.5": return 3.0;
            default: return null; // Cauchy
        }
    }

    public static Double std(String dist) {
        switch (dist) {
            case "Uniform": return Math.sqrt(1.0 / 12.0);
            case "Exponential": return 1.0;
            case "Pareto_Alpha3": return Math.sqrt(0.75);
            default: return null; // Pareto 1.5 & Cauchy
        }
    }

    // ================= SLLN =================

    public static void runSLLN(String dist, int n) {
        try {
            PrintWriter out = new PrintWriter("SLLN_" + dist + ".csv");
            out.println("n,cumulativeMean");

            double sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += generate(dist);
                out.println(i + "," + (sum / i));
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= CLT =================

    public static void runCLT(String dist, int[] ns, int m) {

        Double mu = mean(dist);
        Double sigma = std(dist);

        for (int n : ns) {
            try {
                PrintWriter out = new PrintWriter(
                        "CLT_" + dist + "_n" + n + ".csv"
                );

                for (int i = 0; i < m; i++) {
                    double sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += generate(dist);
                    }
                    double xbar = sum / n;

                    // CLT standardization only if moments exist
                    if (mu != null && sigma != null) {
                        double z =
                                Math.sqrt(n) * (xbar - mu) / sigma;
                        out.println(z);
                    } else {
                        // Bozulmayı göstermek için
                        out.println(xbar);
                    }
                }
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
