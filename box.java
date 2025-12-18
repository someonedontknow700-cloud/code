package logistics.box;

public class Box {

    public double width;
    public double height;
    public double depth;

    public Box() {
        width = height = depth = 0;
    }

    public Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    public Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    public double volume() {
        return width * height * depth;
    }
}




package logistics.boxweight;

import logistics.box.Box;

public class BoxWeight extends Box {

    public double weight;

    public BoxWeight() {
        super();
        weight = 0;
    }

    public BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }

    public BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }
}




package logistics.shipment;

import logistics.boxweight.BoxWeight;

public class Shipment extends BoxWeight {

    public double cost;

    public Shipment() {
        super();
        cost = 0;
    }

    public Shipment(double w, double h, double d, double m, double c) {
        super(w, h, d, m);
        cost = c;
    }

    public Shipment(Shipment ob) {
        super(ob);
        cost = ob.cost;
    }
}





package logistics.app;

import logistics.shipment.Shipment;
import java.util.Scanner;

public class LogisticsApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter width, height, depth, weight and cost for Shipment 1:");
        double w1 = input.nextDouble();
        double h1 = input.nextDouble();
        double d1 = input.nextDouble();
        double weight1 = input.nextDouble();
        double cost1 = input.nextDouble();

        Shipment shipment1 = new Shipment(w1, h1, d1, weight1, cost1);

        System.out.println("Enter width, height, depth, weight and cost for Shipment 2:");
        double w2 = input.nextDouble();
        double h2 = input.nextDouble();
        double d2 = input.nextDouble();
        double weight2 = input.nextDouble();
        double cost2 = input.nextDouble();

        Shipment shipment2 = new Shipment(w2, h2, d2, weight2, cost2);

        Shipment shipment3 = new Shipment(shipment1);

        System.out.println("\nShipment 1 details:");
        displayShipmentDetails(shipment1);

        System.out.println("\nShipment 2 details:");
        displayShipmentDetails(shipment2);

        System.out.println("\nShipment 3 (copy of Shipment 1) details:");
        displayShipmentDetails(shipment3);

        input.close();
    }

    static void displayShipmentDetails(Shipment s) {

        System.out.printf(
            "Dimensions (WxHxD): %.2f x %.2f x %.2f%n",
            s.width, s.height, s.depth
        );
        System.out.printf("Volume: %.2f%n", s.volume());
        System.out.printf("Weight: %.2f%n", s.weight);
        System.out.printf("Cost: $%.2f%n", s.cost);
    }
}
