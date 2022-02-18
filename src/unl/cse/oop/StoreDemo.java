package unl.cse.oop;

import java.util.ArrayList;
import java.util.List;

public class StoreDemo {

	public static <T extends Item> T getMostExpensiveItem(List<T> items) {

		T maxItem = items.get(0);
		for(T x : items) {
			if(x.getCost() > maxItem.getCost()) {
				maxItem = x;
			}
		}
		return maxItem;
	}
	
	public static <T extends Comparable<T>> T getMax(List<T> things) {

		T maxItem = things.get(0);
		for(T x : things) {
			if(x.compareTo(maxItem) > 0) {
				maxItem = x;
			}
		}
		return maxItem;
		

	}
	
	
	
	public static double getTotal(List<? extends Item> items) {
		
		double total = 0.0;
		for(int i=0; i<items.size(); i++) {
			total += items.get(i).getCost();
		}
		return total;
		
	}
	
	/**
	 * This method removes all items that have a cost of zero
	 * @param items
	 * @return
	 */
	public static <T extends Item> void removeZeroItems(List<T> items, List<? super Item> badItems) {

		for(T x : items) {
			if(x.getCost() == 0) {
				badItems.add(x);
			}
		}
		
	}
	


}
