package hu.marcsello.simpleLogger;

import java.sql.*;

public class DataManager {
	private final MySQLConnection dbc;
	private String table_name;
	
	
	public DataManager(MySQLConnection _dbc, String _table_name) {
		dbc = _dbc;	
		table_name = _table_name;
	}
	
	public void insertData(EventData _data) throws SQLException {
		
		dbc.open(); // can be called whenever you want
		
		PreparedStatement pstatement = dbc.prepareStatement("INSERT INTO " + table_name + " (`timestamp`, `playername`, `event`) VALUES ( ?, ?, ?)");
	
		pstatement.setTimestamp(1, _data.getTimestamp());
		pstatement.setString(2, _data.getName());
		pstatement.setString(3, _data.getType().toString());
		
		pstatement.executeUpdate();
		pstatement.close();
		
	}
	
	public void createTable() { // TODO!!!
		
	}
	
	public boolean tableExists() { // TODO!!!
		return false;
	}
	
}
