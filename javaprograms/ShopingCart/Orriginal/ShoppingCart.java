/**
 * Write a description of class ShoppingCart here.
 * 
 * @author Krishna Kumar Gaddam
 * @version 17/08/2015
 */
import java.util.ArrayList;
public class ShoppingCart {
  // instance variables - replace the example below with your own
  ArrayList<Item> item;
  double totalAmount = 0.0;
  double discount = 0.0;
  double tax;
  /**
   * Constructor for objects of class ShoppingCart
   */
  public ShoppingCart() {
    // initialise instance variables
    item = new ArrayList<Item>();
  }
  /**
   * An example of a method - replace this comment with your own
   * 
   * @param  itemObject is the object of the item to add into the arraylist of item
   * @return     the sum of x and y 
   */
  public void addToCart(Item itemObject) {
    // put your code here
    item.add(itemObject);
    totalAmount = totalAmount + (itemObject.getQuantity() * itemObject.getUnitPrice());
    if(discount != 0)
    {
        discount = discount + (((itemObject.getQuantity() * itemObject.getUnitPrice())/100) * 10);
        tax = ((totalAmount - discount) / 100) * 14;
    }
  }
  public void showCart() {
    for (Item temp : item) {
      System.out.println(temp.getProductName() + ":" + temp.getQuantity());
    }
  }
  public void removeFromCart(Item itemObject) {
    for (Item temp : item) {
      if(temp.equals(itemObject) == true) {
        totalAmount = totalAmount - (temp.getQuantity() * temp.getUnitPrice());
        item.remove(temp);
        break;
      }
    }
  }
  public double getTotalAmount() {
    return totalAmount;
  }
  public void applyCoupon(String coupon) {
      if(coupon.compareTo("IND10")== 0) {
      discount = (totalAmount / 100) * 10;
    }
  }
  public void printInvoice() {
    for (Item temp : item) {
      String str = temp.getProductName() + "\t" +temp.getQuantity();
      str = str + "\t" + temp.getUnitPrice();
      str = str + "\t" + (temp.getQuantity() * temp.getUnitPrice());
      System.out.println(str);
    }
    System.out.println("\t\tTotal:" + totalAmount);
    System.out.println("\t\tDisc%:" + discount);
    System.out.println("\t\tTax:" + tax);
    System.out.println("\t\tTotal:" + (totalAmount - discount + tax));
  }
  public double getPayableAmount() {
    tax = ((totalAmount - discount)/ 100) * 14;
    return totalAmount - discount + tax;
  }
}
