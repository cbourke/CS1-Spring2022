package unl.cse.oop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) {

		Product apples = new Product("a123", "Apple", .35, 4);
		Product bananas = new Product("b123", "Banana", .25, 8);
		Product cantelope = new Product("c345", "Cantelope", 1.25, 3);
		
		Subscription xboxLive = new Subscription("345", "X-box Live", 0.00, LocalDate.of(2022, 2, 8), LocalDate.of(2022, 12, 31));
		Subscription cheese = new Subscription("c321", "Cheese of the month", 240.00, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));
		Subscription hydro = new Subscription("ABCEE", "Tap Water", 120.00, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));

		List<Product> products = new ArrayList<>();
		products.add(apples);
		products.add(bananas);
		products.add(cantelope);
		
		double subTotal1 = StoreDemo.getTotal(products);
		
		List<Subscription> subs = new ArrayList<>();
		subs.add(xboxLive);
		subs.add(cheese);
		subs.add(hydro);

		double subTotal2 = StoreDemo.getTotal(subs);
		
		List<Item> everything = new ArrayList<>();
		everything.addAll(products);
		everything.addAll(subs);
		
		double grandTotal = StoreDemo.getTotal(everything);
		
		List<Item> badItems = new ArrayList<>();
		StoreDemo.removeZeroItems(subs, badItems);
		
		Product expensiveProduct = StoreDemo.getMostExpensiveItem(products);
		Subscription expensiveSubscription = StoreDemo.getMostExpensiveItem(subs);
		Item expensiveItem = StoreDemo.getMostExpensiveItem(everything);
		
		List<Integer> numbers = new ArrayList<>();
		List<Double> otherNumbers = new ArrayList<>();
		List<String> strings = new ArrayList<>();
		
		StoreDemo.getMax(numbers);
		StoreDemo.getMax(otherNumbers);
		StoreDemo.getMax(strings);
		StoreDemo.getMax(everything);

	}

}
