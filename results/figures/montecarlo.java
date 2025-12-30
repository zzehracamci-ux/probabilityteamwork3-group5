package teamwork3first;
import java.util.Random;
public class montecarlo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        int n = 10000; // Önerilen gözlem sayısı
		        int pointsInsideCircle = 0;
		        Random random = new Random();

		        System.out.println("n\tEstimated Pi");
		        System.out.println("--------------------");

		        for (int i = 1; i <= n; i++) {
		            // 1. [0,1] aralığında rastgele x ve y koordinatları üret
		            double x = random.nextDouble();
		            double y = random.nextDouble();

		            // 2. x^2 + y^2 <= 1 koşulunu kontrol et
		            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
		                pointsInsideCircle++;
		            }

		            // 3. Pi tahminini hesapla: 4 * (daire içindeki / toplam)
		            double piEstimate = 4.0 * pointsInsideCircle / i;

		            // Belirli aralıklarla gelişimi konsola yazdır (Grafik verisi için)
		            if (i % 1000 == 0 || i == 1) {
		                System.out.printf("%d\t%.5f%n", i, piEstimate);
		            }
		        }

		        double finalPi = 4.0 * pointsInsideCircle / n;
		        System.out.println("--------------------");
		        System.out.println("Final Estimated Pi: " + finalPi);
		        System.out.println("True Pi Value: " + Math.PI);
		    }
		

	}


