package project;

import java.util.Scanner;
public class salaryCalculator
{
 public static void main(String[] args) 
 {
  Scanner S = new Scanner(System.in);
 System.out.println("Enter basic salary");
 double basic = S.nextDouble();
 S.nextLine();
 System.out.println("Enter designation");
 String designation = S.nextLine().trim();
 S.nextLine();
 double DA = 0.40*basic;
 double HRA = 0.20*basic;
 double CCA = 350;
 double PF = 0.10*basic;
 double PT = 100;
 double bonus = 0;
 switch (designation.toLowerCase())
 {
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
double GI = basic+DA+HRA+CCA+bonus;
double IT = 0.10*GI;
double deductions = PF+PT+IT;
double NI = GI-deductions;
System.out.println("Salary Slip");
System.out.printf("Basic salary %2f%n", basic);
System.out.printf("DA(40%%):",DA);
System.out.printf("HRA(20%%):",HRA);
System.out.printf("CCA %2f%n : ",CCA);
System.out.printf("PF %2f%n: ",PF);
System.out.printf("PT %2f%n : ",PT);
System.out.printf("Bonus %2f%n",bonus);
System.out.printf("gross income %2f%n",GI);
System.out.printf(" deduction %2f%n",deductions);
System.out.printf("net income %2f%n",NI);
System.out.printf("Income Tax %2f%n",IT);
S.nextLine();
}
}
