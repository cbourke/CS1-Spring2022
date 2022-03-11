package unl.cse.jdbc;

public class Director {

	private Integer directorId;
	private String firstName;
	private String lastName;

	public Director(Integer directorId, String firstName, String lastName) {
		super();
		this.directorId = directorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Director(String firstName, String lastName) {
		this(null, firstName, lastName);
	}
	
	public Integer getDirectorId() {
		return directorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName + "(" + this.directorId + ")";
	}

}
