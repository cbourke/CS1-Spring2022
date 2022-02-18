package unl.cse.oop;

import java.time.LocalDate;

public class Student {

	private String firstName;
	private String lastName;
	private String nuid;
	private double gpa;
	private LocalDate birthDate;
	private Address address;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param nuid
	 * @param gpa
	 */
	public Student(String firstName, String lastName, String nuid, double gpa) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nuid = nuid;
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", nuid=" + nuid + ", gpa=" + gpa + "]";
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNuid() {
		return nuid;
	}
	public double getGpa() {
		return gpa;
	}
	
	
	
}
