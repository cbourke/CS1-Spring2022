package unl.cse.trees;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Demo {

	public static void main(String[] args) {
	
		Comparator<Integer> cmp = new Comparator<>() {

			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
			
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>(cmp);
		bst.add(500);
		
		Random r = new Random();
		for(int i=0; i<10; i++) {
			bst.add(r.nextInt(1000));
		}
		
		System.out.println(bst.inorderTraversal());

		bst.remove(500);

		System.out.println(bst.inorderTraversal());
		
		System.out.println("Hello");

		
		
	}

}
