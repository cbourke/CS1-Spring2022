package unl.cse.honors.oop;

public abstract class Item implements Comparable<Item> {

	private final String id;
	private final String name;

	public abstract double getCost();

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param itemId
	 * @param name
	 */
	public Item(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Item that) {
		if(this.getCost() < that.getCost()) {
			return -1;
		} else if(this.getCost() > that.getCost()) {
			return 1;
		} else {
			return 0;
		}
	}
}
