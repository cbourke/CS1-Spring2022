package unl.cse.honors.trees;

import java.util.Comparator;
import java.util.Random;

public class Demo {
	

	public static void main(String[] args) {

		Comparator<Integer> cmp = Comparator.comparing(Integer::intValue); 
		cmp = Comparator.nullsLast(cmp);

		BinarySearchTree<Integer> bst = new BinarySearchTree<>(cmp);

		Random r = new Random();
		for(int i=0; i<10; i++) {
			bst.add(r.nextInt(100));
		}
		//bst.add(null);
		System.out.println(bst);
		System.out.println(bst.getMin());
		System.out.println(bst.getMax());
		
		
	}

}
