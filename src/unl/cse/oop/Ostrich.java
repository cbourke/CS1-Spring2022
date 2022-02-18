package unl.cse.oop;

public class Ostrich extends Bird implements Eatable {

	@Override
	public void move() {
		System.out.println("walking...");
	}

	@Override
	public void speak() {
		System.out.println("honk!");
	}
	
	@Override
	public void eats() {
		System.out.println("eating a seed");
		
	}


}
