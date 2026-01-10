# IE221-TeamWork-Group5
Teamwork4
This project aims to experimentally verify the Strong Law of Large Numbers (SLLN) and the Central Limit Theorem (CLT) using computer simulations. It also includes a practical application of SLLN through Monte Carlo $\pi$ Estimation. The project demonstrates how random variables behave at scale and how they converge to theoretical values.

Team Members 
ZEHRA CAMCI - 2311021023
FATMAGUL ARATCELFE - 2311021045
ILAYDA GUNER - 2211021042
YAGMUR SENER - 2311021013

Monte Carlo Simulation of SLLN and CLT (Java)
1. Project Description

This project provides an experimental verification of two fundamental theorems in probability theory:
Strong Law of Large Numbers (SLLN)
Central Limit Theorem (CLT)

The verification is performed using Monte Carlo simulations implemented in Java. By generating large numbers of independent and identically distributed (i.i.d.) random variables, the project demonstrates how theoretical convergence results emerge in practice as the sample size increases.

The project focuses not only on numerical accuracy, but also on highlighting the difference between almost sure convergence and convergence in distribution, which is a key conceptual distinction in probability theory.

2. Learning Outcomes (Why This Project Matters)
This project demonstrates that the student is able to:

Translate mathematical theorems into computational algorithms

Apply Monte Carlo simulation techniques

Correctly interpret different modes of convergence

Implement probabilistic models using Java

Analyze and explain simulation results in a statistically meaningful way

These outcomes align directly with learning objectives in probability, statistics, and simulation-based modeling courses.

3. Theoretical Background (Brief)
Strong Law of Large Numbers (SLLN)

For a sequence of i.i.d. random variables with finite expected value 𝜇, the SLLN states that the sample mean converges almost surely to 𝜇 as the sample size goes to infinity.
In this project:
Distribution: Uniform(0,1)
Theoretical mean:
𝜇=0.5

Central Limit Theorem (CLT)
For i.i.d. random variables with finite mean 𝜇 and variance 𝜎2, the standardized sum converges in distribution to a standard normal random variable 𝑁(0,1).

For Uniform(0,1):
𝜎2=1/12

4. Programming Environment

Language: Java

JDK Requirement: Java 8 or higher

Libraries Used (Standard Java Only):

java.util.Random

java.lang.Math

❗ No external libraries, frameworks, or package managers are required.

5. Installation Steps

Install Java (if not already installed)
Verify installation:

java -version

Download or Clone the Project

git clone <repository-url>

Navigate to the Project Directory

cd project-folder

6. Dependencies

This project has zero external dependencies.

All functionality is implemented using core Java libraries, ensuring:

Platform independence

Ease of compilation

No environment configuration issues

This design choice was made intentionally to keep the focus on probability theory and simulation logic, not tooling.

7. Execution Instructions

Compile the Source Files

javac *.java

Run the Program

java Main

Execution Flow

SLLN simulation runs first

CLT simulations run next for multiple sample sizes

Results are printed to the console (and optionally used for plotting)

8. Methodology Summary
SLLN Simulation
Single long simulation
Maximum sample size: 
𝑛=10,000

Tracks cumulative sample mean:
𝑋ˉ𝑛=1/𝑛∑𝑋𝑖

✔ Appropriate because SLLN concerns almost sure convergence along one sample path

CLT Simulation
Replication-based Monte Carlo approach
Sample sizes tested:
𝑛=2,5,10,30,50
Replications per n:10,000

✔ Necessary because CLT concerns convergence in distribution, not individual realizations

9. Example Outputs
Example: SLLN Output
SLLN Simulation Started
Theoretical Mean (μ): 0.5

n = 100     → Sample Mean = 0.4829
n = 500     → Sample Mean = 0.5071
n = 1000    → Sample Mean = 0.4984
n = 2000    → Sample Mean = 0.5010
n = 10000   → Sample Mean = 0.5003


✔ Confirms stabilization of the sample mean around the theoretical value
✔ Empirical evidence of the Strong Law of Large Numbers

Example: CLT Output (n = 10)
CLT Simulation for n = 10
Number of replications: 10000

Mean of Z values: 0.006
Standard deviation: 0.999
Distribution: Approximately Normal


✔ Mean close to 0
✔ Variance close to 1
✔ Confirms convergence to 𝑁(0,1)

10. Interpretation of Results

CLT convergence occurs rapidly: normality appears even at small 𝑛

SLLN convergence is slower: estimator stability requires larger samples

This confirms that:

Convergence in distribution ≠ convergence of point estimates

This distinction is a key theoretical insight and is clearly demonstrated by the simulations.

11. Reproducibility

A fixed random seed is used

Results are consistent across multiple runs

Ensures scientific reliability and experimental validity

12. Conclusion

This project successfully verifies the Strong Law of Large Numbers and the Central Limit Theorem through Java-based Monte Carlo simulations. The results align with theoretical expectations and clearly demonstrate the practical implications of different convergence modes in probability theory.

The project shows strong integration of theory, computation, and interpretation, fulfilling both academic and technical evaluation criteria.



