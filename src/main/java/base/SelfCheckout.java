package base;

import java.util.Scanner;

public class SelfCheckout {
  Scanner input = new Scanner(System.in);
  final double taxRate = 5.5;
  public static void main(String[] args) {
    SelfCheckout newCheckout = new SelfCheckout();
    int i;
    double subtotal = 0;
    for (i = 1; i <= 3; i++){
      subtotal += (newCheckout.itemPrice(i) * newCheckout.itemQuantity(i));
    }
    System.out.printf("Total: $%.2f%n", newCheckout.getTotal(subtotal));
  }

  public double itemPrice(int n){
    System.out.printf("Enter the price of item %d: ", n);
    String num = input.next();
    try {
      Double.parseDouble(num);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid Number! Try Again!");
      return itemPrice(n);
    }
    return Double.parseDouble(num);
  }

  public double itemQuantity(int n){
    System.out.printf("Enter the quantity of item %d: ", n);
    String num = input.next();
    try {
      Double.parseDouble(num);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid Number! Try Again!");
      return itemQuantity(n);
    }
    return Double.parseDouble(num);
  }

  public double getTotal(double subtotal){
    System.out.printf("Subtotal: $%.2f%n", subtotal);
    double taxAmt = taxRate * subtotal / 100;
    System.out.printf("Tax: $%.2f%n", taxAmt);
    return subtotal + taxAmt;
  }
}
