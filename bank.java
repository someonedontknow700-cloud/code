package project;

import java.util.Scanner;

// Interface for fixed deposit
interface FixedDeposit 
{

    double calculateMaturityAmount(double principal, double rate, int years);
}

// Bank A implementation
class BankA implements FixedDeposit 
{

    @Override
    public double calculateMaturityAmount(double principal, double rate, int years) 
    {
        // Compound interest formula: A = P(1 + r/100)^t
        return principal * Math.pow(1 + rate / 100, years);
    }
}

// Bank B implementation with quarterly compounding
class BankB implements FixedDeposit 
{

    @Override
    public double calculateMaturityAmount(double principal, double rate, int years) 
    {
        int n = 4; // compounded quarterly
        return principal * Math.pow(1 + (rate / (n * 100)), n * years);
    }
}

public class bank 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter principal amount:");
        double principal = scanner.nextDouble();

        System.out.println("Enter annual interest rate (in %):");
        double rate = scanner.nextDouble();

        System.out.println("Enter number of years:");
        int years = scanner.nextInt();

        FixedDeposit bankA = new BankA();
        FixedDeposit bankB = new BankB();

        double maturityA = bankA.calculateMaturityAmount(principal, rate, years);
        double maturityB = bankB.calculateMaturityAmount(principal, rate, years);

        System.out.printf("Maturity amount in Bank A: %.2f%n", maturityA);
        System.out.printf(
            "Maturity amount in Bank B (quarterly compounding): %.2f%n",
            maturityB
        );

        scanner.close();
    }
}
