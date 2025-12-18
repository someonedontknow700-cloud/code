package project;

import java.util.Scanner;

//Generic Stack Implementation
class Stack<E> {

 private E[] elements;
 private int top;
 private int capacity;

 @SuppressWarnings("unchecked")
 public Stack(int size) {
     capacity = size;
     elements = (E[]) new Object[size]; // generic array creation
     top = -1;
 }

 // Push operation with overflow check
 public void push(E item) {
     if (top == capacity - 1) {
         System.out.println("Stack Overflow! Cannot push: " + item);
     } else {
         elements[++top] = item;
     }
 }

 // Pop operation with underflow check
 public E pop() {
     if (top == -1) {
         System.out.println("Stack Underflow! Cannot pop.");
         return null;
     }
     return elements[top--];
 }

 // Check if stack is empty
 public boolean isEmpty() {
     return top == -1;
 }

 // Display stack contents in reverse order
 public void displayReverse() {
     if (isEmpty()) {
         System.out.println("Stack is empty.");
         return;
     }

     System.out.print("Stack contents (reverse order): ");
     for (int i = top; i >= 0; i--) {
         System.out.print(elements[i] + " ");
     }
     System.out.println();
 }
}

//Main class
public class DisasterResponseSystem {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     // Create stacks for different sensor data
     Stack<Integer> warningStack = new Stack<>(5);      // warning levels
     Stack<Double> temperatureStack = new Stack<>(5);  // temperature readings

     // Read integer warning levels
     System.out.println("Enter 3 warning levels (integers):");
     for (int i = 0; i < 3; i++) {
         warningStack.push(sc.nextInt());
     }

     // Read double temperature values
     System.out.println("Enter 3 temperature readings (doubles):");
     for (int i = 0; i < 3; i++) {
         temperatureStack.push(sc.nextDouble());
     }

     // Display data in reverse order
     System.out.println("\n--- Disaster Response Data Processing ---");

     System.out.println("Warning Levels:");
     warningStack.displayReverse();

     System.out.println("Temperature Readings:");
     temperatureStack.displayReverse();

     sc.close();
 }
}
