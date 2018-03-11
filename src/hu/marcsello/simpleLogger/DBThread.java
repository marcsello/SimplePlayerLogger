package hu.marcsello.simpleLogger;

import java.beans.Statement;
import java.sql.SQLException;
import java.util.LinkedList;

public class DBThread extends Thread {

	private final DataManager dm;
	private LinkedList<EventData> list;
	private boolean running;
	
	public DBThread(DataManager _dm) {
		dm = _dm;
		running = true;
		list = new LinkedList<EventData>();
	}
	
	@Override
	public void run() {
		
		do {
			
			EventData next = list.poll();
			
			if (next == null) {
				
				try {
					synchronized (this) {
						this.wait();
					}
				} catch (InterruptedException e) {}
				
			} else { // do something
				

				try {
					dm.insertData(next);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
					
		} while(running);
		
	}
	
	public synchronized void close() {
		running = false;
		this.notifyAll();
	}
	
	public synchronized void execute(EventData data) {
		list.add(data);
		this.notifyAll();
	}
	
}
