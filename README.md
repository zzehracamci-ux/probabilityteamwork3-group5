# probabilityteamwork3-group5
Teamwork 3
This project aims to experimentally verify the Strong Law of Large Numbers (SLLN) and the Central Limit Theorem (CLT) using computer simulations. It also includes a practical application of SLLN through Monte Carlo $\pi$ Estimation. The project demonstrates how random variables behave at scale and how they converge to theoretical values.

Team Members 
ZEHRA CAMCI - 2311021023
FATMAGUL ARATCELFE - 2311021045
ILAYDA GUNER - 2211021042
YAGMUR SENER - 2311021013

Tasks Summary
Task 2: Strong Law of Large Numbers (SLLN) Simulation of $n=10,000$ samples from $U[0,1]$ to observe the convergence of the cumulative mean to the theoretical mean $\mu = 0.5$.
Task 3: Central Limit Theorem (CLT) Generating $m=1000$ sums for various $n$ values ($2, 5, 10, 30, 50$). The results are standardized to $Z$-scores and compared against the Standard Normal Distribution $N(0,1)$ using histograms and Q-Q plots.
Task 4: Monte Carlo Pi Estimation Estimating the value of $\pi$ by generating random points in a unit square and calculating the ratio of points falling inside a quarter circle.

Installation
To run this project, you need to have the Java Development Kit (JDK) installed on your system (Version 17 or higher is recommended).

Clone the repository:
Bash
git clone https://github.com/zzehracamci-ux/probabilityteamwork3-group5.git

Navigate to the project directory:
Bash
cd probabilityteamwork3-group5

Usage 
You can compile and run the simulation scripts using the following commands in your terminal:

SLLN Simulation:
Bash
javac src/Slln_Simulation.java
java src/Slln_Simulation

CLT Simulation:
Bash
javac src/Clt.java
java src/Clt

Monte Carlo Pi Estimation:
Bash
javac src/montecarlo.java
java src/montecarlo

Project Structure
The repository follows the required exact folder structure:
src/: Contains the Java source code files for all simulations (SLLN, CLT, and Monte Carlo).
results/figures/: Stores all generated plots, including histograms, Q-Q plots, and convergence graphs in PNG/PDF format.
reports/: Contains the technical reports documenting the findings and observations of the project.
README.md: Provides project description, team information, and instructions.
