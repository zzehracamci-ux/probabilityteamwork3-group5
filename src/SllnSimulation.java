package teamwork3;

	import java.util.Random;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;

	public class SllnSimulation {
	    public static void main(String[] args) {
	        int n = 10000; 
	        double cumulativeSum = 0;
	        Random random = new Random();
	        
	        
	        File directory = new File("results");
	        if (!directory.exists()) {
	            directory.mkdir();
	        }

	        // file: results/slln_data.csv
	        try (FileWriter writer = new FileWriter("results/slln_data.csv")) {
	            writer.write("n,cumulative_mean,theoretical_mean\n");

	            for (int i = 1; i <= n; i++) {
	                double x = random.nextDouble(); 
	                cumulativeSum += x;
	                double cumulativeMean = cumulativeSum / i;

	                
	                writer.write(i + "," + cumulativeMean + ",0.5\n");
	            }
	            System.out.println("Başarılı! Veriler 'results/slln_data.csv' konumuna kaydedildi.");
	        } catch (IOException e) {
	            System.err.println("Hata oluştu: " + e.getMessage());
	        }
	    }
	}
