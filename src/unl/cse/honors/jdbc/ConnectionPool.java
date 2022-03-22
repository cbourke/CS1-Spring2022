package unl.cse.honors.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

	private static final String url = "jdbc:mysql://cse.unl.edu/cbourke?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String user = "cbourke";
	private static final String pass = "1234";

	public static final int NUM_CONNECTIONS = 10;
	public static BlockingQueue<Connection> POOL = new ArrayBlockingQueue<>(NUM_CONNECTIONS);

	static {
		try {
			for (int i = 0; i < NUM_CONNECTIONS; i++) {
				Connection conn;
				conn = DriverManager.getConnection(url, user, pass);
				POOL.add(conn);
			}
		} catch (SQLException e) {
			System.err.println("could not get connection");
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() {
		try {
			return POOL.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void putConnection(Connection conn) {
		try {
			POOL.put(conn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
