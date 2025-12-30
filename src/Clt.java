
	package teamwork3first;

	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Random;

	public class work1 {

	    public static void main1(String[] args) {

	        /* -----------------------------
	           CLT PARAMETERS
	        ----------------------------- */
	        int[] nValues = {2, 5, 10, 30, 50}; // different n values
	        int m = 1000;                     // number of experiment for each n
	        double mu = 0.5;                  // expected value U[0,1] 
	        double sigma = Math.sqrt(1.0 / 12.0); // U[0,1] std deviation

	        Random random = new Random();

	        /* -----------------------------
	           Create a folder named "results" 
	        ----------------------------- */
	        File resultsDir = new File("results");
	        if (!resultsDir.exists()) {
	            resultsDir.mkdirs();
	        }

	        File outputFile = new File(resultsDir, "clt_data.csv");

	        /* -----------------------------
	           write folder csv
	        ----------------------------- */
	        try (FileWriter writer = new FileWriter(outputFile)) {

	            // CSV title
	            writer.write("n,z_score\n");

	            // CLT simulation
	            for (int n : nValues) {
	                for (int i = 0; i < m; i++) {

	                    double sum = 0.0;

	                    // n independent and identically distributed (i.i.d.) random variables from a standard uniform distribution U[0,1]
	                    for (int j = 0; j < n; j++) {
	                        sum += random.nextDouble();
	                    }

	                    // Z-score (CLT standardization)
	                    double zScore = (sum - n * mu) / (sigma * Math.sqrt(n));

	                    // write to csv
	                    writer.write(n + "," + zScore + "\n");
	                }
	            }

	            System.out.println("CLT simulation completed.");
	            System.out.println("Results saved to: results/clt_data.csv");

	        } catch (IOException e) {
	            System.out.println("File writing error: " + e.getMessage());
	        }
	    }
	

   
