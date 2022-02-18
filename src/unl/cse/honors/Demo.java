package unl.cse.honors;

import java.time.Duration;
import java.util.Arrays;

public class Demo {
	
	public static void main(String args[]) {

		
		
		Isotope sampleA = new Isotope(38, "Strontium", "Sr", 28.9, 10);
		Isotope sampleB = new Isotope(sampleA, 5);
	

		Duration oneYear = Duration.ofDays( (long) (1 * 365.25) );
		for (int i = 0; i <= 30; i++) {
			System.out.println(sampleA);
			sampleA.decay(oneYear);
		}

		

	}

}
