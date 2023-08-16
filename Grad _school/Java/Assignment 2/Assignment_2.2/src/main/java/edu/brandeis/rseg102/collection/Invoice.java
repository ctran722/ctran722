package edu.brandeis.rseg102.collection;


public class Invoice {
   private final int partNumber; 
   private final String partDescription;
   private int quantity;
   private double pricePerItem;

   // constructor
   public Invoice(int partNumber, String partDescription, int quantity,
      double pricePerItem) {
      if (quantity < 0) { // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");
      }

      if (pricePerItem < 0.0) { // validate pricePerItem
         throw new IllegalArgumentException("Price per item must be >= 0");
      }

      this.quantity = quantity;
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      this.pricePerItem = pricePerItem;
   } 

   // get part number
   public int getPartNumber() {return partNumber;} 

   // get description
   public String getPartDescription() {return partDescription;} 

   // set quantity
   public void setQuantity(int quantity) {
      if (quantity < 0) { // validate quantity
         throw new IllegalArgumentException("Quantity must be >= 0");
      }

      this.quantity = quantity;
   } 

   // get quantity
   public int getQuantity() {return quantity;}

   // set price per item
   public void setPricePerItem(double pricePerItem) {
      if (pricePerItem < 0.0) {// validate pricePerItem
         throw new IllegalArgumentException("Price per item must be >= 0");
      }

      this.pricePerItem = pricePerItem;
   } 

   // get price per item
   public double getPricePerItem() {return pricePerItem;} 

   // return String representation of Invoice object
   @Override
   public String toString() {
      return String.format("Part #: %-2d  Description: %-15s  Quantity: %-4d  Price: $%,6.2f", 
    	         getPartNumber(), getPartDescription(), 
    	         getQuantity(), getPricePerItem());
   } 

   // return amount of this Invoice
   public double getInvoiceAmount() {                                                                   
      return getQuantity() * getPricePerItem(); // calculate total cost
   } 
}
