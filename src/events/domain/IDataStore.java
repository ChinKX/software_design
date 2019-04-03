package events.domain;

import java.util.List;

public interface IDataStore {
	
	public void createEvent(Event newEvent);
	public Event searchEvent(String eventTitle);
	public List<Event> getAllEvents();
	
}