package hu.marcsello.simpleLogger;

import java.sql.Timestamp;
import java.util.Date;

public class EventData {
	private String name;
	private EventType type;
	private Date date;
	
	public EventData(String _name, EventType _type) {
		name = _name;
		type = _type;
		date = new Date();
	}
	
	public EventData(Date _date, String _name, EventType _type) {
		name = _name;
		type = _type;
		date = _date;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EventType getType() {
		return type;
	}
	
	public void setType(EventType type) {
		this.type = type;
	}
	
	public Timestamp getTimestamp() {
		return new Timestamp(date.getTime());
	}
	
}
