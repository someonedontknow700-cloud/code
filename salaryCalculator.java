package project;

import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basic = s.nextDouble();
        s.nextLine(); // consume newline

        System.out.print("Enter designation: ");
        String designation = s.nextLine().trim().toLowerCase();

        double DA = 0.40 * basic;
        double HRA = 0.20 * basic;
        double CCA = 350;
        double PF = 0.10 * basic;
        double PT = 100;
        double bonus = 0;

        switch (designation) {
            case "manager":
                bonus = 2000;
                break;
            case "team lead":
                bonus = 1500;
                break;
            case "developer":
                bonus = 1000;
                break;
            case "intern":
                bonus = 500;
                break;
            default:
                System.out.println("INVALID DESIGNATION");
        }

        double GI = basic + DA + HRA + CCA + bonus;
        double IT = 0.10 * GI;
        double deductions = PF + PT + IT;
        double NI = GI - deductions;

        System.out.println("\n----- SALARY SLIP -----");
        System.out.printf("Basic Salary : %.2f%n", basic);
        System.out.printf("DA (40%%)     : %.2f%n", DA);
        System.out.printf("HRA (20%%)    : %.2f%n", HRA);
        System.out.printf("CCA          : %.2f%n", CCA);
        System.out.printf("Bonus        : %.2f%n", bonus);
        System.out.printf("Gross Income : %.2f%n", GI);
        System.out.printf("PF           : %.2f%n", PF);
        System.out.printf("PT           : %.2f%n", PT);
        System.out.printf("Income Tax   : %.2f%n", IT);
        System.out.printf("Deductions   : %.2f%n", deductions);
        System.out.printf("Net Income   : %.2f%n", NI);

        s.close();
    }
}
