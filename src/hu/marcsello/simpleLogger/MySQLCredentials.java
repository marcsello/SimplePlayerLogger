package hu.marcsello.simpleLogger;

public class MySQLCredentials {

	
	private final String db;
	private final String host;
	private final String user;
	private final String password;

	public MySQLCredentials(String _host, String _user, String _password, String _db) {
		db = _db;
		host = _host;
		user = _user;
		password = _password;		
	}
	
	public String getDB() {
		return db;
	}
	
	public String getHost() {
		return host;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + password;
	}
	

}
