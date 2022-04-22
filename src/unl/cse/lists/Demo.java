package unl.cse.lists;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Demo {

	public static void main(String args[]) {
		
		Random r = new Random();

		Deque<Integer> queue = new ArrayDeque<>();
		long n = 100000;
		for(int i=0; i<n; i++) {
			queue.offer(i);
		}
		System.out.println("done A");
		for(int i=0; i<n; i++) {
			queue.poll();
		}
		System.out.println("done");


	}
}
