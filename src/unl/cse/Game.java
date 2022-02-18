package unl.cse;

import java.util.Comparator;

public record Game(String game, String publisher, String year, String platform) {
	
	public static Comparator<Game> foo = null;
}
