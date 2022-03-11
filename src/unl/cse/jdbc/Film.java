package unl.cse.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Film {

	private Integer filmId;
	private String title;
	private Director director;
	private List<Actor> cast;

	public Film(Integer filmId, String title, Director director) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.director = director;
		this.cast = new ArrayList<>();
	}

	public Film(String title, Director director) {
		this(null, title, director);
	}

	public Integer getFilmId() {
		return filmId;
	}

	public String getTitle() {
		return title;
	}

	public Director getDirector() {
		return director;
	}
	
	public void addActor(Actor a) {
		this.cast.add(a);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%s (%d) directed by %s", this.title, this.filmId, this.getDirector()));
		result.append("Starring: \n");
		for(Actor a : this.cast) {
			result.append("\t"+a+"\n");
		}
		return result.toString();
	}
}
