package project;

import java.util.Scanner;

class ClimateVariable {

    // Measurable value (e.g., temperature)
    double realPart;

    // Anomaly or uncertainty factor
    double imaginaryPart;

    // Default constructor - no initial data
    public ClimateVariable() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    // Constructor with only real data, uncertainty assumed zero
    public ClimateVariable(double realPart) {
        this.realPart = realPart;
        this.imaginaryPart = 0.0;
    }

    // Constructor with real and imaginary parts
    public ClimateVariable(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // Copy constructor for duplicating an existing ClimateVariable
    public ClimateVariable(ClimateVariable other) {
        this.realPart = other.realPart;
        this.imaginaryPart = other.imaginaryPart;
    }

    // Method to display the climate variable in standard complex format
    @Override
    public String toString() {
        return String.format("%.2f + %.2fi", realPart, imaginaryPart);
    }

    // Method to add another ClimateVariable's values
    public ClimateVariable add(ClimateVariable other) {
        return new ClimateVariable(
            this.realPart + other.realPart,
            this.imaginaryPart + other.imaginaryPart
        );
    }
}

public class climatesimulation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter real part for partial data ClimateVariable:");
        double realOnly = scanner.nextDouble();

        System.out.println("Enter real and imaginary parts for full data ClimateVariable:");
        double realFull = scanner.nextDouble();
        double imagFull = scanner.nextDouble();

        ClimateVariable cvDefault = new ClimateVariable();
        ClimateVariable cvPartial = new ClimateVariable(realOnly);
        ClimateVariable cvFull = new ClimateVariable(realFull, imagFull);
        ClimateVariable cvCopy = new ClimateVariable(cvFull);

        System.out.println("\nClimate Variables:");
        System.out.println("Default (no initial data): " + cvDefault);
        System.out.println("Partial data (real only): " + cvPartial);
        System.out.println("Full data (real + imaginary): " + cvFull);
        System.out.println("Copy of full data variable: " + cvCopy);

        ClimateVariable sumVariable = cvPartial.add(cvFull);
        System.out.println(
            "\nSum of partial and full climate variables: " + sumVariable
        );

        scanner.close();
    }
}
