package unl.cse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveData {

	/**
	 * This method returns the Director with the given firstName/lastName (in the
	 * given director d) loaded from the database. If no such record exists, it
	 * persists it to the database and then loads it.
	 * 
	 * @param d
	 */
	public static Director getOrInsertDirector(Director d) {

		Director result = DataLoader.getDirectorByName(d);
		if(result == null) {			
			//TODO: insert the record and then reload (?) it to return it...
			String insertDirectorQuery = "insert into Director (firstName, lastName) values (?, ?);";
			
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
			
			// 2. prepare you query
			try {
				PreparedStatement ps = conn.prepareStatement(insertDirectorQuery, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, d.getFirstName());
				ps.setString(2, d.getLastName());
				ps.executeUpdate();
				
				//get the generated keys...
				ResultSet keys = ps.getGeneratedKeys();
				keys.next();
				int directorId = keys.getInt(1);
				result = new Director(directorId, d.getFirstName(), d.getLastName());				
				keys.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				System.err.println("cannot get data");
				throw new RuntimeException(e);
			}


			// 3 load the record you just saved...
			//result = DataLoader.getDirectorByName(d);
			// alternative: load the ids of the newly inserted records

		}
		return result;
	}

	public static void insertFilm(Film f) {
		
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
		
		String insertFilmQuery = "insert into Film (title,eidr,directorId) values (?,?,?);";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(insertFilmQuery);
			ps.setString(1, f.getTitle());
			ps.setString(2, "12345");
			ps.setInt(3, f.getDirector().getDirectorId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("cannot insert data");
			throw new RuntimeException(e);
		}

		// 4. clean up our resources...
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("cannot close for some reason...");
			throw new RuntimeException(e);
		}
	}

	public static void main(String args[]) {
		
		Director key = new Director("James", "Gunn");
		Director d = getOrInsertDirector(key);
		System.out.println(d);
		
		Film suicideSquade = new Film(null, "Suicide Squade", d);
		insertFilm(suicideSquade);

	}
}
