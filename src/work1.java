package teamwork3first;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class work1 {
    public static void main(String[] args) {

        File dir = new File("results");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        int[] nValues = {2, 5, 10, 30, 50};
        int m = 1000;
        double mu = 0.5;
        double sigma = Math.sqrt(1.0 / 12.0);
        Random random = new Random();

        try (FileWriter writer = new FileWriter("results/clt_data.csv")) {
            writer.write("n,z_score\n");

            for (int n : nValues) {
                for (int i = 0; i < m; i++) {
                    double sum = 0;
                    for (int j = 0; j < n; j++) {
                        sum += random.nextDouble();
                    }

                    double zScore = (sum - (n * mu)) / (sigma * Math.sqrt(n));
                    writer.write(n + "," + zScore + "\n");
                }
            }

            System.out.println("CLT simulasyonu bitti. Veriler results/clt_data.csv dosyasina kaydedildi.");
        } catch (IOException e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
