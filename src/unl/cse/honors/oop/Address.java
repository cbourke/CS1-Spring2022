package unl.cse.honors.oop;

public class Address {


	private final String street;
	private final String city;
	private final String state;
	private final String zipCode;
	

	/**
	 * @param street
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public Address(String street, String city, String state, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
}
