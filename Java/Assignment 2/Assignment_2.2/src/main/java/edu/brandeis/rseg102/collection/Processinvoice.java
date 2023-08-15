package edu.brandeis.rseg102.collection;

import java.util.Arrays;
import java.util.Comparator;


public class Processinvoice {
   public static void main(String[] args) {
      Invoice[] invoices = {
         new Invoice(83, "Electric sander", 7, 57.98),
         new Invoice(24, "Power saw", 18, 99.99),
         new Invoice(7, "Sledge hammer", 11, 21.50),
         new Invoice(77, "Hammer", 76, 11.99),
         new Invoice(39, "Lawn mower", 3, 79.50),
         new Invoice(68, "Screwdriver", 106, 6.99),
         new Invoice(56, "Jig saw", 21, 11.00),
         new Invoice(3, "Wrench", 34, 7.50)
      };

      System.out.println("Invoices sorted by part description:");
      Arrays.stream(invoices)
         .sorted(Comparator.comparing(Invoice::getPartDescription))
         .forEach(System.out::println);

      System.out.printf("%nnInvoices sorted by price:%n");
      Arrays.stream(invoices)
         .sorted(Comparator.comparing(Invoice::getPricePerItem))
         .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and quantity:%n");
      Arrays.stream(invoices)
         .sorted(Comparator.comparing(Invoice::getQuantity))
         .map(invoice -> String.format(
            "Description: %-15s  Quantity: %d", 
            invoice.getPartDescription(), invoice.getQuantity()))
         .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and invoice amount:%n");
      Arrays.stream(invoices)
         .sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPricePerItem()))
         .map(invoice -> String.format(
            "Description: %-15s  Invoice amount: %7.2f", 
            invoice.getPartDescription(), invoice.getQuantity() * invoice.getPricePerItem()))
         .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
      Arrays.stream(invoices)
         .filter(invoice -> invoice.getQuantity() * invoice.getPricePerItem()>= 200 && invoice.getQuantity() * invoice.getPricePerItem() <= 500)
         .sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPricePerItem()))
         .map(invoice -> String.format(
            "Description: %-15s  Invoice amount: %7.2f", 
            invoice.getPartDescription(), invoice.getQuantity() * invoice.getPricePerItem()))
         .forEach(System.out::println);

      
      System.out.printf("%nInvoices in which the partDescription contains the word \"saw\":%n");
      Arrays.stream(invoices)
         .filter(invoice -> invoice.getPartDescription().contains("saw"))
         .sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPricePerItem()))
         .map(invoice -> String.format(
            "Description: %-15s  Invoice amount: %7.2f", 
            invoice.getPartDescription(), invoice.getQuantity() * invoice.getPricePerItem()))
         .forEach(System.out::println);
   }
}