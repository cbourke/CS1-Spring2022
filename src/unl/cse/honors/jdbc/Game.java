package unl.cse.honors.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private int gameId;
	private String title;
	private Publisher publisher;
	private List<Platform> systems;

	/**
	 * @param gameId
	 * @param title
	 * @param publisher
	 */
	public Game(int gameId, String title, Publisher publisher) {
		super();
		this.gameId = gameId;
		this.title = title;
		this.publisher = publisher;
		this.systems = new ArrayList<>();
	}
	
	

	/**
	 * @param title
	 * @param publisher
	 */
	public Game(String title, Publisher publisher) {
		super();
		this.title = title;
		this.publisher = publisher;
	}



	public int getGameId() {
		return gameId;
	}

	public String getTitle() {
		return title;
	}

	public Publisher getPublisher() {
		return publisher;
	}
	
	public void addPlatform(Platform p) {
		this.systems.add(p);
	}

	@Override
	public String toString() {
		String s = String.format("%s (%d) by %s\n", this.title, this.gameId, this.publisher);
		for(Platform p : systems) {
			s += "\t" + p + "\n";
		}
		return s;
	}

}
