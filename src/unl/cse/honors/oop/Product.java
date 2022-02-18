package unl.cse.honors.oop;

public class Product extends Item {

	private final double price;
	private final Integer quantity;
	
	/**
	 * @param productId
	 * @param name
	 * @param price
	 * @param quantity
	 */
	public Product(String id, String name, double price, Integer quantity) {
		super(id, name);
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * @param productId
	 * @param name
	 * @param price
	 */
	public Product(String productId, String name, double price) {
		this(productId, name, price, null);
	}

	public Product(Product p, int quantity) {
		this(p.getId(), p.getName(), p.price, quantity);
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public double getCost() {
		return this.price * this.quantity;
	}



	
	
	
	
}
