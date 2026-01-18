# IE221 - Simulation of Limit Theorems (SLLN & CLT)
Teamwork5
This project aims to experimentally verify the **Strong Law of Large Numbers (SLLN)** and the **Central Limit Theorem (CLT)** using computer simulations. The project demonstrates how random variables behave at scale and how they converge to theoretical values across different probability distributions.

## 👥 Team Members
* **ZEHRA CAMCI** - 2311021023
* **FATMAGUL ARATCELFE** - 2311021045
* **ILAYDA GUNER** - 2211021042
* **YAGMUR SENER** - 2311021013

## 📌 Project Overview
The goal of this project is to investigate how different probability distributions behave under the two fundamental theorems of statistics. We simulate five distinct distributions to observe their convergence properties:
* **Uniform (0,1):** Symmetric, finite moments.
* **Exponential (λ=1):** Skewed, finite moments.
* **Pareto (α=3) Heavy-tailed, finite variance.
* **Pareto (α=1.5):** Heavy-tailed, infinite variance.
* **Cauchy:** Undefined moments (Pathological case).

## 📂 Repository Structure
* **`src/`**: Contains the Java implementation (`IE221_Teamwork5.java`) used for data generation.
* **`results/`**: Organized folders containing Histograms and Q-Q Plots for each distribution.
* **`reports/`**: The final 15-20 page technical report in PDF format.

## 🛠 Methodology
* **Language:** Java (JDK 17).
* **RNG Technique:** Inverse Transform Sampling.
* **Simulations:**
    * **SLLN:** 10,000 observations per distribution.
    * **CLT:** 1,000 replications for sample sizes n {2, 5, 10, 30, 50, 100\}.

## 📊 Key Findings
* **Convergence Success:** Uniform, Exponential, and Pareto (α=3) successfully converged to normality as n increased, validating the CLT.
* **The Infinite Variance Barrier:** Pareto (α=1.5) failed to reach normality despite having a finite mean, proving the necessity of finite variance.
* **The Cauchy Anomaly:** The Cauchy distribution showed zero convergence, as its moments do not exist, making both SLLN and CLT inapplicable.
