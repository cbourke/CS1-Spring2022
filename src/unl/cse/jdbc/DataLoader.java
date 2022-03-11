package unl.cse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data loader class that loads data from an SQL database
 * 
 * @author cbourke
 *
 */
public class DataLoader {

	/**
	 * Connects to the database and loads data associated with the given
	 * Director(directorId) record
	 * 
	 * @param directorId
	 * @return
	 */
	public static Director getDirectorById(int directorId) {

		Director d = null;

		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		// 1. make the connection...
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("cannot get connection");
			throw new RuntimeException(e);
		}

		// 2. Formulate your query
		String query = "select * from Director d where directorId = ?;";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, directorId);
			// 2b. execute your query:
			rs = ps.executeQuery();
			// 2c. process the results...
			while (rs.next()) {
				// process the current record (row)
				int directorIdFromDatabase = rs.getInt("directorId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				d = new Director(directorId, firstName, lastName);
			}

		} catch (SQLException e) {
			System.err.println("cannot get data");
			throw new RuntimeException(e);
		}

		// 4. clean up our resources...
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("cannot close for some reason...");
			throw new RuntimeException(e);
		}

		return d;
	}

	public static Director getDirectorByName(Director d) {

		// 1. Make a connection...
		Director result = null;

		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		// 1. make the connection...
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("cannot get connection");
			throw new RuntimeException(e);
		}
		
		// 2. Formulate your query
		String query = "select * from Director where lastName = ? and firstName = ?;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, d.getLastName());
			ps.setString(2, d.getFirstName());
			// 2b. execute your query:
			rs = ps.executeQuery();
			// 2c. process the results...
			while (rs.next()) {
				// process the current record (row)
				int directorId = rs.getInt("directorId");
				result = new Director(directorId, d.getFirstName(), d.getLastName());
			}
		} catch (SQLException e) {
			System.err.println("cannot get data");
			throw new RuntimeException(e);
		}
		
		// 4. clean up our resources...
		try {
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println("cannot close for some reason...");
			throw new RuntimeException(e);
		}

		//load all actors for each film...
		query = "select * from Actor where actorId = ???"
		

		return result;
	}

	public static List<Film> getAllFilms() {
		
		List<Film> films = new ArrayList<>();

		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		// 1. make the connection...
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("cannot get connection");
			throw new RuntimeException(e);
		}
		
		// 2. Formulate your query
		String query = "select filmId,directorId,title from Film;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query);
			// 2b. execute your query:
			rs = ps.executeQuery();
			// 2c. process the results...
			while (rs.next()) {
				// process the current record (row)	
				int filmId = rs.getInt("filmId");
				int directorId = rs.getInt("directorId");
				String title = rs.getString("title");
				Director d = getDirectorById(directorId);
				Film f = new Film(filmId, title, d);
				films.add(f);
			}
		} catch (SQLException e) {
			System.err.println("cannot get data");
			throw new RuntimeException(e);
		}
		
		// 4. clean up our resources...
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("cannot close for some reason...");
			throw new RuntimeException(e);
		}
		
		return films;
	}

	public static void main(String args[]) {

		Director d = getDirectorById(1);
		System.out.println(d);

		Director nolanKey = new Director("Christopher", "Nolan");
		Director nolan = getDirectorByName(nolanKey);
		System.out.println(nolan);

		// pull all films...
		List<Film> films = getAllFilms();
		for(Film f : films) {
			System.out.println(f);
		}
	}
}
