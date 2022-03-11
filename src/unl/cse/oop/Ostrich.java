package unl.cse.oop;

public class Ostrich extends Bird implements Eatable, Nestable {

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

	@Override
	public void makeNest() {
		// TODO Auto-generated method stub
		
	}


}
