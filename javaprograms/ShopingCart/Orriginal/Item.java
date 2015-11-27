
/**
 * Write a description of class Item here.
 * 
 * @author Krishna Kumar Gaddam 
 * @version 17/8/2015
 */

public class Item {
  // instance variables - replace the example below with your own
  private String productName;
  private int quantity;
  private double unitPrice;
  /**
  * Constructor for objects of class Item
  */
  public Item(String productName,int quantity,double unitPrice) {
    // initialise instance variables
    this.productName = productName;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }
  public String getProductName() {
   return productName;
  }
  public int getQuantity() {
    return quantity;
  }
  public double getUnitPrice() {
    return unitPrice;
  }    
}
