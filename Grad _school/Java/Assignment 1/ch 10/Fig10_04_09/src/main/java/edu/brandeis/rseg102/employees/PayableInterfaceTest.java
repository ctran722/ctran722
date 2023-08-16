// Fig. 10.14: PayableInterfaceTest.java
// Payable interface test program processing Invoices and 
// Employees polymorphically.

package edu.brandeis.rseg102.employees;
public class PayableInterfaceTest  {
   public static void main(String[] args) {
	// create Payable array
	  Payable[] payableobject = new Payable[6];
      payableobject[0] = new Invoice("01234", "seat", 2, 375.00);
      payableobject[1] = new Invoice("56789", "tire", 4, 79.95);
      payableobject[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
      payableobject[3] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
      payableobject[4] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
      payableobject[5] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
      System.out.println("Invoices and Employees processed polymorphically:\n"); 

      // generically process each element in array payableObjects
      for (Payable currentpayable : payableobject) {
         // output currentPayable and its appropriate payment amount
         System.out.printf("%s \n", currentpayable.toString()); 
            
         if (currentpayable instanceof BasePlusCommissionEmployee) {
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee worker = (BasePlusCommissionEmployee) currentpayable;

            double oldsalary = worker.getBaseSalary();
            worker.setBaseSalary(1.10 * oldsalary);
            System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
               worker.getBaseSalary());
         } 
         //print payment due
         System.out.printf("%s: $%,.2f\n\n","payment due", currentpayable.getPaymentAmount()); 
      }
   }
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
