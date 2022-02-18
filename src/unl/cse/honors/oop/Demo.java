package unl.cse.honors.oop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Demo {

	public static void main(String[] args) {
		

		Product apples = new Product("a123", "Apple", .35, 0);
		Product bananas = new Product("b123", "Banana", .25, 8);
		Product cantelope = new Product("c345", "Cantelope", 1.25, 3);
		
		Subscription xboxLive = new Subscription("345", "X-box Live", 0.00, LocalDate.of(2022, 2, 8), LocalDate.of(2022, 12, 31));
		Subscription cheese = new Subscription("c321", "Cheese of the month", 240.00, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));
		Subscription hydro = new Subscription("ABCEE", "Tap Water", 120.00, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));

		List<Product> products = new ArrayList<>();
		products.add(apples);
		products.add(bananas);
		products.add(cantelope);
		
		double subtotal1 = StoreDemo.getTotal(products);

		Set<Product> setOfProducts = new HashSet<>();
		setOfProducts.add(apples);
		setOfProducts.add(bananas);
		setOfProducts.add(cantelope);
		
		double subtotal2 = StoreDemo.getTotal(setOfProducts);

				
		List<Subscription> subs = new ArrayList<>();
		subs.add(xboxLive);
		subs.add(cheese);
		subs.add(hydro);

		double subtotal3 = StoreDemo.getTotal(subs);
		
		List<Item> everything = new ArrayList<>();
		everything.addAll(products);
		everything.addAll(subs);

		double grandTotal = StoreDemo.getTotal(everything);


		//filter purhcases...
		Set<Item> badOnes = new HashSet<>();
		StoreDemo.filterBad(products, badOnes);
		StoreDemo.filterBad(subs, badOnes);

		Item max = StoreDemo.getMax(everything);
		System.out.println(max);
		
	}

}
