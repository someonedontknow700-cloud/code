package project;

import java.util.Scanner;

// Abstract class Solid
abstract class Solid 
{

    double radius;
    double height;

    // Constructor to initialize dimensions
    Solid(double radius, double height) 
    {
        this.radius = radius;
        this.height = height;
    }

    // Abstract methods
    abstract double surfaceArea();
    abstract double volume();
}

// Cylinder class
class Cylinder extends Solid 
{

    Cylinder(double radius, double height) 
    {
        super(radius, height);
    }

    @Override
    double surfaceArea() 
    {
        // Surface Area = 2πr(h + r)
        return 2 * Math.PI * radius * (height + radius);
    }

    @Override
    double volume() 
    {
        // Volume = πr²h
        return Math.PI * radius * radius * height;
    }
}

// Cone class
class Cone extends Solid 
{

    Cone(double radius, double height) 
    {
        super(radius, height);
    }

    @Override
    double surfaceArea() 
    {
        // Surface Area = πr(r + l)
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    double volume() 
    {
        // Volume = (1/3)πr²h
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }
}

// Sphere class
class Sphere extends Solid 
{

    Sphere(double radius) 
    {
        super(radius, 0);
    }

    @Override
    double surfaceArea() 
    {
        // Surface Area = 4πr²
        return 4 * Math.PI * radius * radius;
    }

    @Override
    double volume() 
    {
        // Volume = (4/3)πr³
        return (4.0 / 3) * Math.PI * radius * radius * radius;
    }
}

// Main class
public class CivilEngineeringTool 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);

        // Cylinder input
        System.out.println("Enter radius and height of the Cylinder:");
        double cylRadius = scanner.nextDouble();
        double cylHeight = scanner.nextDouble();
        Solid cylinder = new Cylinder(cylRadius, cylHeight);

        // Cone input
        System.out.println("Enter radius and height of the Cone:");
        double coneRadius = scanner.nextDouble();
        double coneHeight = scanner.nextDouble();
        Solid cone = new Cone(coneRadius, coneHeight);

        // Sphere input
        System.out.println("Enter radius of the Sphere:");
        double sphereRadius = scanner.nextDouble();
        Solid sphere = new Sphere(sphereRadius);

        // Output
        System.out.printf("\nCylinder Surface Area: %.2f%n", cylinder.surfaceArea());
        System.out.printf("Cylinder Volume: %.2f%n", cylinder.volume());

        System.out.printf("\nCone Surface Area: %.2f%n", cone.surfaceArea());
        System.out.printf("Cone Volume: %.2f%n", cone.volume());

        System.out.printf("\nSphere Surface Area: %.2f%n", sphere.surfaceArea());
        System.out.printf("Sphere Volume: %.2f%n", sphere.volume());

        scanner.close();
    }
}
