package unl.cse.algos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListDemo {
	
	public static BigInteger sum(List<Integer> numbers) {
		BigInteger result = BigInteger.ZERO;
		for(int i=0; i<numbers.size(); i++) {
			result = result.add(BigInteger.valueOf(numbers.get(i)));
		}
		return result;		
	}

	public static void main(String args[]) {

		Random r = new Random();
		long n = 1000000l;
		List<Integer> numbers = new ArrayList<>();
		for(int i=0; i<n; i++) {
			numbers.add(r.nextInt());
		}
		System.out.printf("Summing %d random numbers...\n", n);
		long start = System.nanoTime();
		BigInteger s = ListDemo.sum(numbers);
		long end = System.nanoTime();
		double duration = (end-start) / 1000000000.0;
		System.out.println("Sum     = " + s);
		System.out.println("time(s) = " + duration);
		
	}
	
}
