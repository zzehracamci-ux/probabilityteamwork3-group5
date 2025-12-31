
	package teamwork3first;

	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Random;

	public class work1 {

	    public static void main1(String[] args) {

	        /* -----------------------------
	           CLT PARAMETRELERİ
	        ----------------------------- */
	        int[] nValues = {2, 5, 10, 30, 50}; // farklı n değerleri
	        int m = 1000;                     // her n için deney sayısı
	        double mu = 0.5;                  // U[0,1] beklenen değer
	        double sigma = Math.sqrt(1.0 / 12.0); // U[0,1] std sapma

	        Random random = new Random();

	        /* -----------------------------
	           RESULTS KLASÖRÜ OLUŞTUR
	        ----------------------------- */
	        File resultsDir = new File("results");
	        if (!resultsDir.exists()) {
	            resultsDir.mkdirs();
	        }

	        File outputFile = new File(resultsDir, "clt_data.csv");

	        /* -----------------------------
	           CSV DOSYASINA YAZ
	        ----------------------------- */
	        try (FileWriter writer = new FileWriter(outputFile)) {

	            // CSV başlığı
	            writer.write("n,z_score\n");

	            // CLT simülasyonu
	            for (int n : nValues) {
	                for (int i = 0; i < m; i++) {

	                    double sum = 0.0;

	                    // n tane U[0,1] rastgele değişken
	                    for (int j = 0; j < n; j++) {
	                        sum += random.nextDouble();
	                    }

	                    // Z-score (CLT standardizasyonu)
	                    double zScore = (sum - n * mu) / (sigma * Math.sqrt(n));

	                    // CSV'ye yaz
	                    writer.write(n + "," + zScore + "\n");
	                }
	            }

	            System.out.println("CLT simulation completed.");
	            System.out.println("Results saved to: results/clt_data.csv");

	        } catch (IOException e) {
	            System.out.println("File writing error: " + e.getMessage());
	        }
	    }
	

    public static void main(String[] args) {

        /* -----------------------------
           CLT PARAMETRELERİ
        ----------------------------- */
        int[] nValues = {2, 5, 10, 30, 50}; // farklı n değerleri
        int m = 1000;                     // her n için deney sayısı
        double mu = 0.5;                  // U[0,1] beklenen değer
        double sigma = Math.sqrt(1.0 / 12.0); // U[0,1] std sapma

        Random random = new Random();

        /* -----------------------------
           RESULTS KLASÖRÜ OLUŞTUR
        ----------------------------- */
        File resultsDir = new File("results");
        if (!resultsDir.exists()) {
            resultsDir.mkdirs();
        }

        File outputFile = new File(resultsDir, "clt_data.csv");

        /* -----------------------------
           CSV DOSYASINA YAZ
        ----------------------------- */
        try (FileWriter writer = new FileWriter(outputFile)) {

            // CSV başlığı
            writer.write("n,z_score\n");

            // CLT simülasyonu
            for (int n : nValues) {
                for (int i = 0; i < m; i++) {

                    double sum = 0.0;

                    // n tane U[0,1] rastgele değişken
                    for (int j = 0; j < n; j++) {
                        sum += random.nextDouble();
                    }

                    // Z-score (CLT standardizasyonu)
                    double zScore = (sum - n * mu) / (sigma * Math.sqrt(n));

                    // CSV'ye yaz
                    writer.write(n + "," + zScore + "\n");
                }
            }

            System.out.println("CLT simulation completed.");
            System.out.println("Results saved to: results/clt_data.csv");

        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }
}
