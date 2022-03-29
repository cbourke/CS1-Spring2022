package unl.cse.honors.lists;

import java.util.Random;

public class Demo {

	public static void main(String args[]) {
		
		Random r = new Random();
		MyLinkedList<Integer> foo = new MyLinkedList<>();
		
		//add n elements to the start of the list:
//		long start = System.currentTimeMillis();
//		while(foo.getSize() < 10000000) {
//			foo.addElementToHead(r.nextInt());
//		}
//		long end = System.currentTimeMillis();
//		System.out.println( (end - start) + "ms");
		
		foo.addElementToTail(10);
		foo.addElementToTail(20);
		foo.addElementToTail(30);
		foo.addElementToTail(40);
		foo.addElementToTail(50);
		System.out.println(foo);
		foo.addElementAtIndex(42, 5);
		System.out.println(foo);
		foo.addElementToHead(101);
		System.out.println(foo);
		foo.addElementAtIndex(142, 3);
		System.out.println(foo);
		
		//TODO: does not work if you remove the head...
		int x = foo.removeElementAtIndex(0);
		System.out.println(x);

		System.out.println(foo);
	}
}
