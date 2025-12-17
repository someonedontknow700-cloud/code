package project;

import java.util.Scanner;

/* Helper class for rocket calculations */
class Rocket {
    private double a; // Acceleration due to gravity
    private double b; // Initial upward velocity
    private double c; // Initial height

    // Constructor
    public Rocket(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Method to calculate ground times
    public double[] getGroundTimes() {
        // Quadratic: a*t^2 + b*t + c = 0
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return new double[0];
        } 
        else if (discriminant == 0) {
            double t = -b / (2 * a);
            return (t >= 0) ? new double[]{t} : new double[0];
        } 
        else {
            double sqrtDisc = Math.sqrt(discriminant);
            double t1 = (-b + sqrtDisc) / (2 * a);
            double t2 = (-b - sqrtDisc) / (2 * a);

            if (t1 >= 0 && t2 >= 0)
                return new double[]{t1, t2};
            else if (t1 >= 0)
                return new double[]{t1};
            else if (t2 >= 0)
                return new double[]{t2};
            else
                return new double[0];
        }
    }

    // Height at time t
    public double heightAtTime(double t) {
        return a * t * t + b * t + c;
    }
}

/* Main class */
public class RocketTrajectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter acceleration due to gravity (a, negative): ");
        double a = scanner.nextDouble();

        System.out.print("Enter initial upward velocity (b): ");
        double b = scanner.nextDouble();

        System.out.print("Enter initial height (c): ");
        double c = scanner.nextDouble();

        Rocket rocket = new Rocket(a, b, c);

        double[] groundTimes = rocket.getGroundTimes();

        if (groundTimes.length == 0) {
            System.out.println("The rocket never reaches the ground.");
        } else {
            System.out.println("Time(s) when rocket reaches the ground:");
            for (double t : groundTimes) {
                System.out.printf("t = %.2f seconds\n", t);
            }
        }

        scanner.close();
    }
}
