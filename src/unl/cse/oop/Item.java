package unl.cse.oop;

public abstract class Item implements Comparable<Item> {

	private final String id;
	private final String name;

	public Item(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public abstract double getCost();
	
	public String getId() {
		return this.id;
	
	}
	public String getName() {
		return this.name;
	}
	
	@Override
	public int compareTo(Item that) {
		if(this.getCost() > that.getCost() ) {
			return 1;
		} else if(this.getCost() > that.getCost() ) {
			return -1;
		} else {
			return 0;
		}
	}


}
