package unl.cse.honors.oop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Subscription extends Item {
	
	double annualRate;
	LocalDate startDate;
	LocalDate endDate;

	/**
	 * @param id
	 * @param name
	 * @param annualRate
	 * @param startDate
	 * @param endDate
	 */
	public Subscription(String id, String name, double annualRate, LocalDate startDate, LocalDate endDate) {
		super(id, name);
		this.annualRate = annualRate;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public double getCost() {
		return annualRate * (startDate.until(endDate, ChronoUnit.DAYS) / 365.0);
	}
	
	
	
}
