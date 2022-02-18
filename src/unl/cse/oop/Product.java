package unl.cse.oop;

/**
 * Class to represent a product in our point of sale system.
 * @author cbourke
 *
 */
public class Product extends Item {

	private final double price;
	private final Integer quantity;

	public Product(Product p, int quantity) {
		this(p.getId(), p.getName(), p.price, quantity);
	}
	
	/**
	 * @param id
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
	
	public double getCost() {
		return this.price * this.quantity;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	
}
