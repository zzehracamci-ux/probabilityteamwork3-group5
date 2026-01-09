package teamwork3first;

import java.util.Random;

/**
 * MonteCarloPi Class
 * * This class implements the Monte Carlo method to estimate the value of Pi.
 * It uses a geometric approach by generating random points in a unit square 
 * and calculating the ratio of points that fall inside a quadrant of a unit circle.
 * This simulation serves as a practical application of the Law of Large Numbers. [cite: 24]

 */
public class MonteCarloPi {

    /**
     * Main execution method for the Pi estimation simulation.
     * * Process:
     * 1. Generates n random (x, y) coordinates within [0,1].
     * 2. Checks if each point lies within the unit circle using the Pythagorean theorem.
     * 3. Calculates the Pi estimate using the ratio: Pi ≈ 4 * (points_inside / total_points).
     * 4. Logs the convergence progress to the console.
     * * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        
        // --- Simulation Setup ---
        // n: Total number of random points (observations). 
        // Higher n leads to better precision according to SLLN. [cite: 44]
        int totalPoints = 10000; 
        int pointsInsideCircle = 0;
        Random random = new Random();

        // Print header for the progress table
        System.out.println("n\tEstimated Pi");
        System.out.println("--------------------");

        // --- Simulation Loop ---
        for (int i = 1; i <= totalPoints; i++) {
            
            // 1. Generate random coordinates x and y in the range [0.0, 1.0]
            // These represent a point inside a 1x1 square.
            double x = random.nextDouble();
            double y = random.nextDouble();

            // 2. Geometric condition: Check if the point is inside the unit circle.
            // Formula: x^2 + y^2 <= radius^2 (where radius = 1)
            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                pointsInsideCircle++; // Increment count if point falls inside the circle
            }

            // 3. Pi Estimation Calculation
            // Area of Circle = PI * r^2 | Area of Square = (2r)^2
            // The ratio of points inside to total points approximates (PI / 4).
            double piEstimate = 4.0 * pointsInsideCircle / i;

            // 4. Progress Logging
            // Log results at intervals (every 1000 steps) to observe the convergence rate. 
            if (i % 1000 == 0 || i == 1) {
                System.out.printf("%d\t%.5f%n", i, piEstimate);
            }
        }

        // --- Final Output ---
        double finalPi = 4.0 * pointsInsideCircle / totalPoints;
        System.out.println("--------------------");
        System.out.println("Final Estimated Pi: " + finalPi);
        System.out.println("True Value of Pi  : " + Math.PI);
        
        // Error analysis is a requirement for the Results section of the report. 
        double absoluteError = Math.abs(Math.PI - finalPi);
        System.out.printf("Absolute Error    : %.5f%n", absoluteError);
    }
}



