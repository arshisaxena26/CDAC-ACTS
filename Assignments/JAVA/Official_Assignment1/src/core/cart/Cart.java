package core.cart;

public class Cart {
	// private data members
	private int quantity;
	private String title;
	private double totalprice;

	// Parameterized Constructor
	public Cart(int quantity, String title, double price) {
		this.quantity = quantity;
		this.title = title;
		this.totalprice = quantity * price;
	}

	// Overriding toString to display data member values
	@Override
	public String toString() {
		return title + "\t\t    " + quantity + "\t\t" + totalprice;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
