class Item {
	private String itemName;
	private int quantity;
	private double price;
	public Item(String itemName, int quantity, double price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	public String getName() {
		return itemName;
	}
	public int getQuatity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
}