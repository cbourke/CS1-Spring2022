package unl.cse.honors.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GameDataLoader {
	
	public static final Map<Integer, Publisher> PUBLISHER_MAP;
	public static final Map<Integer, Platform> PLATFORM_MAP;
	
	static {
		List<Publisher> pubs = getAllPublishers(); 
		PLATFORM_MAP = getAllPlatforms(); 
		PUBLISHER_MAP = new HashMap<>();
		for(Publisher p : pubs) {
			PUBLISHER_MAP.put(p.getPublisherId(), p);
		}
	}
	
	public static Map<Integer, Platform> getAllPlatforms() {
		
		Map<Integer, Platform> result = new HashMap<>();
		
		// 1. make your connection
		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("could not get connection");
			throw new RuntimeException(e);
		}

		// 2. prepare your query
		String query = "select platformId, name from platform";
		PreparedStatement ps;
		ResultSet rs;
		
		
		try {
			ps = conn.prepareStatement(query);
			// execute your query:
			rs = ps.executeQuery();
			while (rs.next()) {
				// process the current record...
				int platformId = rs.getInt("platformId");
				String platformName = rs.getString("name");
				Platform p = new Platform(platformId, platformName);
				result.put(platformId, p);
			}
		} catch (SQLException e) {
			System.err.println("could not get data!");
			throw new RuntimeException(e);
		}

		// 4. close your resources...
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("could not close connection");
			throw new RuntimeException(e);
		}
		
		return result;
	}

	public static Publisher getPublisherById(int publisherId) {

		Publisher p = null;
		// 1. make your connection
		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("could not get connection");
			throw new RuntimeException(e);
		}

		// 2. prepare your query
		String query = "select * from publisher where publisherId = ?;";
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, publisherId);
			// execute your query:
			rs = ps.executeQuery();
			if (rs.next()) {
				// process the current record...
				String publisherName = rs.getString("name");
				p = new Publisher(publisherId, publisherName);
			}
			if (rs.next()) {
				throw new RuntimeException(" multiple publisher with id = "+ publisherId);
			}
		} catch (SQLException e) {
			System.err.println("could not get data!");
			throw new RuntimeException(e);
		}

		// 4. close your resources...
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("could not close connection");
			throw new RuntimeException(e);
		}
		
//		if(p == null) {
//			throw new RuntimeException("no such publisher with ID = " + publisherId);
//		}

		return p;
	}
	
	public static List<Publisher> getAllPublishers() {
		List<Publisher> result = new ArrayList<>();
		// 1. make your connection
		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("could not get connection");
			throw new RuntimeException(e);
		}

		// 2. prepare your query
		String query = "select publisherId,name as publisherName from publisher;";
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(query);
			// execute your query:
			rs = ps.executeQuery();
			while (rs.next()) {
				// process the current record...
				int publisherId = rs.getInt("publisherId");
				String name = rs.getString("publisherName");
				Publisher p = new Publisher(publisherId, name);
				result.add(p);
			}
		} catch (SQLException e) {
			System.err.println("could not get data!");
			throw new RuntimeException(e);
		}

		// 4. close your resources...
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("could not close connection");
			throw new RuntimeException(e);
		}
		
		return result;
	}

	public static Publisher getPublisherByName(Publisher p) {

		Publisher result = null;
		// 1. make your connection
		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("could not get connection");
			throw new RuntimeException(e);
		}

		// 2. prepare your query
		String query = "select publisherId from publisher where name = ?;";
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getName());
			// execute your query:
			rs = ps.executeQuery();
			if (rs.next()) {
				// process the current record...
				int publisherId = rs.getInt("publisherId");
				result = new Publisher(publisherId, p.getName());
			}
		} catch (SQLException e) {
			System.err.println("could not get data!");
			throw new RuntimeException(e);
		}

		// 4. close your resources...
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("could not close connection");
			throw new RuntimeException(e);
		}
		
		return result;
	}

	public static List<Game> getAllGames() {

		List<Game> result = new ArrayList<>();
		
		// 1. make your connection
		String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "cbourke";
		String pass = "1234";

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.err.println("could not get connection");
			throw new RuntimeException(e);
		}

		// 2. prepare your query
		String query = "select gameId,name,publisherId from game g";
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(query);
			// execute your query:
			rs = ps.executeQuery();
			while (rs.next()) {
				int gameId = rs.getInt("gameId");
				String name = rs.getString("name");
				int publisherId = rs.getInt("publisherId");
				Game g = new Game(gameId,name,PUBLISHER_MAP.get(publisherId));
				result.add(g);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println("could not get data!");
			throw new RuntimeException(e);
		}
		
		query = "select platformId from availability where gameId = ?;";
		
		try {
			ps = conn.prepareStatement(query);
			for(Game g : result) {
				ps.setInt(1, g.getGameId());
				rs = ps.executeQuery();
				while(rs.next()) {
					int platformId = rs.getInt("platformId");
					Platform p = PLATFORM_MAP.get(platformId);
					g.addPlatform(p);
				}
				rs.close();
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println("could not get data!");
			throw new RuntimeException(e);
		}
		
		// 4. close your resources...
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
			conn.close();
		} catch (SQLException e) {
			System.err.println("could not close connection");
			throw new RuntimeException(e);
		}
		
		return result;
	}

	public static void main(String args[]) {

//		Publisher p = getPublisherById(1);
//		System.out.println(p);
//		
//		Publisher atariKey = new Publisher("Atari");
//		Publisher atari = getPublisherByName(atariKey);
//		System.out.println(atari);
//		
//		for(Publisher pub : getAllPublishers()) {
//			System.out.println(pub);
//		}
		for(Game g : getAllGames()) {
			System.out.println(g);
		}

	}

}
