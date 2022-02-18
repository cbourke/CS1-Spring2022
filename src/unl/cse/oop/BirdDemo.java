package unl.cse.oop;

import java.util.HashSet;
import java.util.Set;

public class BirdDemo {
	

	public static void main(String[] args) {

		//not possible:
		//Bird b = new Bird();
		Ostrich o = new Ostrich();
		Bird b1 = new Ostrich();
		
		Bird b2 = new Robin();
		
		b2.move();
		b2.speak();
		
		Bird b3 = b1;
		
		b3.move();
		b3.speak();
		
		if(b2 instanceof Robin) {
			Robin r = (Robin) b2;
			System.out.println("Safe!");
		} else {			
			System.out.println("Not safe! Out!");
		}
		
		
	}

}
