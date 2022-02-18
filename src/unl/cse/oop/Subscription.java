package unl.cse.oop;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Subscription extends Item {
	
	private final double annualRate;
	private final LocalDate startDate;
	private final LocalDate endDate;

	/**
	 * @param subscriptionId
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
	
	
	@Override
	public double getCost() {
		double x =  Utils.roundToCents( this.annualRate * (this.startDate.until(this.endDate, ChronoUnit.DAYS) / 365.0) );
		return x;
	}
	
	

}
