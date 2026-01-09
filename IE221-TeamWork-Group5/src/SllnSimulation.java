package teamwork5;


import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Detailed simulation for the Strong Law of Large Numbers (SLLN).
 * This class tracks how the cumulative average of independent samples
 * stabilizes at the theoretical mean. [cite: 5, 22]
 */
public class SllnSimulation {

    public static void main(String[] args) {
        // Define the total number of iterations (n)
        int sampleSize = 10000; 
        // Variable to store the running sum of all generated numbers
        double cumulativeSum = 0;
        // Theoretical mean (mu) for a Uniform distribution on [0,1] [cite: 40]
        final double THEORETICAL_MEAN = 0.5; 
        // Random number generator instance
        Random random = new Random();
        
        // Ensure the directory for output files exists [cite: 15]
        File directory = new File("results");
        if (!directory.exists()) {
            directory.mkdir(); // Creates the 'results' folder if missing
        }

        // CSV file path for SLLN results [cite: 40]
        String filePath = "results/slln_data.csv";
        
        // Try-with-resources ensures the writer closes automatically
        try (FileWriter writer = new FileWriter(filePath)) {
            // Write column headers for data analysis 
            writer.write("n,cumulative_mean,theoretical_mean\n");

            for (int i = 1; i <= sampleSize; i++) {
                // Generate a random number X ~ U(0,1)
                double x = random.nextDouble(); 
                // Add the new sample to the total sum
                cumulativeSum += x;
                
                // Calculate current sample mean: M_n = (X1 + ... + Xn) / n 
                double cumulativeMean = cumulativeSum / i;

                // Save data point to CSV for line graph visualization [cite: 33]
                writer.write(i + "," + cumulativeMean + "," + THEORETICAL_MEAN + "\n");
            }
            System.out.println("SLLN Data successfully saved to " + filePath);
        } catch (IOException e) {
            // Error handling for file system issues
            System.err.println("File Error: " + e.getMessage());
        }
    }
}
	
	