package unl.cse;

/**
 * Date: 2022/01/25
 * 
 * Computes a radioactive decay table given a radioactive element's properties.
 * 
 * More info can be found
 * <a href="https://en.wikipedia.org/wiki/Half-life">here</a>.
 * 
 * @author cbourke
 *
 */
public class IsotopeDemo {

	public static double C = Math.exp(-0.693);

	/**
	 * 
	 * Computes the mass after the given number of <code>years</code> (starting with
	 * the initial <code>mass</code>) of a radioactive element with the given
	 * <code>halfLife</code>.
	 * 
	 * For more information, see
	 * <a href="https://en.wikipedia.org/wiki/Half-life">wikipedia</a>.
	 * 
	 * @param mass     - initial mass in kilograms
	 * @param years
	 * @param halfLife
	 * @return
	 */
	public static double getMass(double mass, double years, double halfLife) {
		double remaining = mass * Math.pow(C, (years / halfLife));
		return remaining;
	}

	public static void main(String args[]) {

		if (args.length != 5) {
			System.err.println("Error provide atomicNumber name atomicSymbol halfLife mass");
			System.exit(1);
		}

		int atomicNumber = Integer.parseInt(args[0]);
		String name = args[1];
		String symbol = args[2];
		double halfLife = Double.parseDouble(args[3]);
		double initialMass = Double.parseDouble(args[4]);

		System.out.printf("  %s (%d-%s)\n", name, atomicNumber, symbol);
		System.out.printf("%s \t%s\n", "Elapsed Years", "Amount");
		System.out.println("-=-=-=-=-=-=-=-=--==-=-=-=-==--=");

		int n = (int) Math.round(halfLife);
		for (int i = 0; i <= n; i++) {
			double newMass = IsotopeDemo.getMass(initialMass, i, halfLife);
			System.out.printf("%d \t%fg\n", i, newMass);
		}

	}
}
