package unl.cse.jdbc;

public class Actor {

	private int actorId;
	private String firstName;
	private String lastName;

	public Actor(int actorId, String firstName, String lastName) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getActorId() {
		return actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return lastName + ", " + firstName;
	}
}
