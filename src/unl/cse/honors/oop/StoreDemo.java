package unl.cse.honors.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class StoreDemo {

	/**
	 * This method totals the cost of all items 
	 * @param items
	 * @return
	 */
	public static <T extends Item> double getTotal(Collection<T> stuff) {
		
		double total = 0.0;
		for(T s : stuff) {
			total += s.getCost();
		}
		return total;
	}


	/**
	 * This method filters all items that have a cost of zero
	 * @param items
	 * @return
	 */
	public static <T extends Item> void filterBad(
			Collection<T> stuff, Collection<? super Item> invalid) {
		
		for(T s : stuff) {
			if(s.getCost() == 0) {
				invalid.add(s);
			}
		}
	}

	/**
	 * This method returns the most expensive item
	 * @param items
	 * @return
	 */
	public static <T extends Comparable<T>> T getMax(Collection<T> items ) {
				
		Collections.min(items);
		Collections.max(items);
		
		T max = items.iterator().next();
		for(T p : items) {
			if(p.compareTo(max) > 0) {
				max = p;
			}
		}
		return max;
	}
	


}
