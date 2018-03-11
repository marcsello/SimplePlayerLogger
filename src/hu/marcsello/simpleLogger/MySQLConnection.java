package hu.marcsello.simpleLogger;

import java.sql.*;

public class MySQLConnection {
	
	private final MySQLCredentials credentials; 
	private java.sql.Connection dbc = null;
	private boolean auto_commit;

	public MySQLConnection(MySQLCredentials c, boolean _auto_commit) throws ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); // Init mysql driver into this class
		
		credentials = c;
		
		auto_commit = _auto_commit;
		
	}
	
	public void open() throws SQLException { // can be called anytime
		if (!isOpen()) {
			dbc = DriverManager.getConnection(credentials.toString());
			dbc.setAutoCommit(auto_commit);
		}
	}
	
	public void close() throws SQLException {
		if (dbc != null) 
			dbc.close();
		dbc = null;
	}
	
	public boolean isOpen() {
		
		try {
			
			return (dbc != null) && (dbc.isClosed());
			
		} catch (SQLException e) {
			
			return false;
		}
		
	}
	
	public Statement createStatement() throws SQLException {
		return dbc.createStatement();
	}
	
	public PreparedStatement prepareStatement(String query) throws SQLException {
		return dbc.prepareStatement(query);
	}
	
	public void setAutoCommit(boolean _auto_commit) throws SQLException {
		auto_commit = _auto_commit;
		if (isOpen()) {
			dbc.setAutoCommit(auto_commit);
		}
	}
	
	public boolean getAutoCommit() {
		return auto_commit;
	}
	
}
