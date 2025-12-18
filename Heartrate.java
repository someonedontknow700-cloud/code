package project;

import java.util.Scanner;

public class Heartrate {

    private int[] heartRates;

    // Constructor
    public Heartrate(int[] heartrates) {
        this.heartRates = heartrates;
    }

    // Method to calculate the summary value based on readings count
    public int calculateSummary() {
        int n = heartRates.length;

        if (n == 0) {
            return 0;
        }

        if (n % 2 == 1) {
            // Odd number of readings: sum first, middle, and last
            int middleIndex = n / 2;
            return heartRates[0] + heartRates[middleIndex] + heartRates[n - 1];
        } else {
            // Even number of readings: sum first and last
            return heartRates[0] + heartRates[n - 1];
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of heart rate readings: ");
        int n = scanner.nextInt();

        int[] readings = new int[n];

        System.out.println("Enter heart rate readings:");
        for (int i = 0; i < n; i++) {
            readings[i] = scanner.nextInt();
        }

        Heartrate monitor = new Heartrate(readings);
        int summaryValue = monitor.calculateSummary();

        System.out.println(
            "Summary value based on heart rate readings: " + summaryValue
        );

        scanner.close();
    }
}
