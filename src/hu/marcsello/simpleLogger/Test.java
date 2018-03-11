package hu.marcsello.simpleLogger;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		MySQLConnection conn = new MySQLConnection(new MySQLCredentials("192.168.0.53", "root", "password", "foo"), true);
		
		DBThread thread = new DBThread(new DataManager(conn,"simple_logger"));
		
		thread.start();
		
		EventData data = new EventData("Yoloman",EventType.JOIN);
		thread.execute(data);
		
		data = new EventData("Yoloman",EventType.LEAVE);
		thread.execute(data);
		
		data = new EventData("Kisnigger",EventType.JOIN);
		thread.execute(data);
		
		data = new EventData("Kisnigger",EventType.LEAVE);
		thread.execute(data);
		
		//Thread.sleep(500);
		
		thread.close();
		conn.close();
		
	}
	
}
