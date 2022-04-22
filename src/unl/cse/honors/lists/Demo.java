package unl.cse.honors.lists;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Demo {

	public static void main(String args[]) {

		Deque<Integer> s = new LinkedList<>();
		for(int i=0; i<5; i++) {
			s.addFirst(i);
		}
		while(!s.isEmpty()) {
			System.out.println(s.removeFirst());
		}

	}
}
