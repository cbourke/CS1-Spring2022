package unl.cse.honors.jdbc;

public class Publisher {

	private final Integer publisherId;
	private final String name;
	
	/**
	 * @param publisherId
	 * @param name
	 */
	public Publisher(Integer publisherId, String name) {
		super();
		this.publisherId = publisherId;
		this.name = name;
	}
	
	

	/**
	 * @param name
	 */
	public Publisher(String name) {
		this(null, name);
	}



	public int getPublisherId() {
		return publisherId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s (%d)",  this.name, this.publisherId);
	}
	
	
	
	
}
