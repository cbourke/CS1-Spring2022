package unl.cse.lists;

import java.util.Random;

public class Demo {

	public static void main(String args[]) {
		
		Random r = new Random();
		MyLinkedList<Integer> list = new MyLinkedList<>();
		//simulate adding elements as long as the size is less than 1 million
//		for(int i=0; i<1000000; i++) {
//			list.addElementToHead(r.nextInt());
//		}
		while(list.getSize() < 1000000) {
			list.addElementToHead(r.nextInt());
		}
		
		System.out.println("done");
	}
}
