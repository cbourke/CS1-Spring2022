package unl.cse.oop;

public class Square extends Rectangle {

	public Square(double width) {
		super(width, width);
	}
	
	public static void main(String args[]) {
		
		Square s = new Square(10);
		s.setHeight(5);
		
		System.out.println(s.getArea());
		
		if(s instanceof Square) {
			System.out.println("s is still a square");
		}
	}
}
