import java.util.*;

/**
 * IE 221 Probability | Fall 2024-2025
 * Team Work 5: Distribution Comparison and Limits of SLLN and CLT [cite: 1, 2, 3]
 */
public class IE221_Teamwork5 {
    private static Random rand = new Random();

    public static void main(String[] args) {
        // Defined distributions for analysis as specified in the assignment
        String[] distributions = {"Uniform", "Exponential", "Pareto_Alpha3", "Pareto_Alpha1.5", "Cauchy"};

        for (String dist : distributions) {
            System.out.println("\n************************************************");
            System.out.println("ANALYSIS FOR: " + dist.toUpperCase());
            System.out.println("************************************************");

            // TASK 1: Strong Law of Large Numbers (SLLN) Analysis [cite: 18]
            // We generate n=10,000 observations to observe convergence behavior [cite: 19, 20]
            System.out.println("\n--- SLLN Analysis (Cumulative Mean) ---");
            runSLLN(dist, 10000);

            // TASK 2: Central Limit Theorem (CLT) Analysis [cite: 21]
            // We analyze different sample sizes (n) with m=1000 replications [cite: 22]
            System.out.println("\n--- CLT Analysis (Sample Means for n=30 and n=100) ---");
            runCLT(dist, 30, 1000);
            runCLT(dist, 100, 1000);
        }
    }

    /**
     * Random Variable Generator using Inverse Transform Sampling.
     * Covers all 5 required distributions with specified parameters.
     */
    public static double generate(String type) {
        double u = rand.nextDouble();
        switch (type) {
            case "Uniform":
                // Uniform distribution (a=0, b=1)
                return u;
            case "Exponential":
                // Exponential distribution (lambda=1)
                return -Math.log(1 - u);
            case "Pareto_Alpha3":
                // Pareto distribution (alpha=3, xm=1)
                return 1.0 / Math.pow(1 - u, 1.0 / 3.0);
            case "Pareto_Alpha1.5":
                // Pareto distribution (alpha=1.5, xm=1)
                return 1.0 / Math.pow(1 - u, 1.0 / 1.5);
            case "Cauchy":
                // Cauchy distribution (x0=0, gamma=1)
                return Math.tan(Math.PI * (u - 0.5));
            default:
                return 0;
        }
    }

    /**
     * SLLN Implementation: Calculates cumulative means to observe convergence[cite: 19].
     */
    public static void runSLLN(String distType, int n) {
        double cumulativeSum = 0;
        System.out.println("n_Step\tCumulative_Mean");
        for (int i = 1; i <= n; i++) {
            cumulativeSum += generate(distType);

            // Print samples at specific intervals to observe the trend
            if (i == 1 || i == 100 || i % 2500 == 0 || i == n) {
                double currentMean = cumulativeSum / i;
                System.out.printf("%d\t%.5f\n", i, currentMean);
            }
        }
    }

    /**
     * CLT Implementation: Generates sample means for m replications[cite: 22].
     */
    public static void runCLT(String distType, int n, int replications) {
        double totalSampleMeans = 0;

        // m = 1000 replications as required [cite: 22]
        for (int i = 0; i < replications; i++) {
            double sampleSum = 0;
            for (int j = 0; j < n; j++) {
                sampleSum += generate(distType);
            }
            double sampleMean = sampleSum / n;
            totalSampleMeans += sampleMean;

            // Optional: Print first few sample means for visual check
            if (i < 3) {
                // System.out.printf("Repl %d: Mean = %.4f\n", i+1, sampleMean);
            }
        }

        // Calculate the average of sample means to check if it matches E[X] [cite: 13]
        double averageOfMeans = totalSampleMeans / replications;
        System.out.printf("Results for n=%d: Average of %d sample means is %.5f\n", n, replications, averageOfMeans);
    }
}