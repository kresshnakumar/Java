import java.util.ArrayList;
class ShoppingCart {
	double totalAmount = 0;
	double discount = 0;
	double tax = 0;
	ArrayList<Item> ial = new ArrayList<Item>();
	public ShoppingCart() {}
	public void addToCart(Item i) {
		ial.add(i);
		if(totalAmount)
	}
	public void showCart() {
		for(Item temp : ial) {
			System.out.println(temp.getName() + " : " + temp.getQuantity());
		}
	}
	public void getTotalAmount() {
		for(Item temp : ial) {
			double amount = temp.getQuantity() * temp.getPrice();
			totalAmount = totalAmount + amount;
			//System.out.println(temp.getName() + " : " + temp.getQuantity());
		}
	}
	public double getPayableAmount() {
		tax = (totalAmount / 100) * 14;
		return tax;
	}
	public void applyCoupon(String str) {
		if(str.compareTo("IND10") == 0) {
			discount = (totalAmount / 100 ) * 10;
		}
	}
	public void printInvoice() {
		
	}
}