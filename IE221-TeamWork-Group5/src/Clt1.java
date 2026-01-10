
	package teamwork5;


	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Random;

	/**
	 * Detailed simulation for the Central Limit Theorem (CLT).
	 * Demonstrates how the sum of independent variables follows a 
	 * Normal Distribution regardless of the original distribution. [cite: 23, 27]
	 */
	public class work1 {

	    public static void main(String[] args) {
	        // Array of different sample sizes to show convergence rate [cite: 37, 41]
	        int[] nValues = {2, 5, 10, 30, 50}; 
	        // m: Number of times we repeat the experiment for each n [cite: 33, 37]
	        int replications = 1000; 
	        
	        // Parameters for Uniform(0,1) distribution [cite: 24]
	        double mu = 0.5; 
	        double sigma = Math.sqrt(1.0 / 12.0); // Standard deviation formula for U(0,1)

	        Random random = new Random();

	        // Prepare the directory for the report data [cite: 15]
	        File resultsDir = new File("results");
	        if (!resultsDir.exists()) {
	            resultsDir.mkdirs();
	        }

	        // Output file for CLT standardized data
	        File outputFile = new File(resultsDir, "clt_data.csv");

	        try (FileWriter writer = new FileWriter(outputFile)) {
	            // CSV columns for n and its corresponding Z-score
	            writer.write("n,z_score\n");

	            // Outer loop: iterate through different sample sizes
	            for (int n : nValues) {
	                // Inner loop: perform 'm' replications for each sample size [cite: 33]
	                for (int i = 0; i < replications; i++) {
	                    double sum = 0.0;

	                    // Generate 'n' samples and sum them up
	                    for (int j = 0; j < n; j++) {
	                        sum += random.nextDouble();
	                    }

	                    // Standardize the sum using the CLT formula 
	                    // Z = (Sum - E[Sum]) / StdDev(Sum)
	                    double zScore = (sum - n * mu) / (sigma * Math.sqrt(n));

	                    // Export the Z-score to create histograms in the report [cite: 41]
	                    writer.write(n + "," + zScore + "\n");
	                }
	            }
	            System.out.println("CLT Data successfully saved to " + outputFile.getPath());
	        } catch (IOException e) {
	            System.err.println("Critical IO Error: " + e.getMessage());
	        }
	    }

		}
