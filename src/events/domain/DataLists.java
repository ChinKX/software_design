package events.domain;

import java.util.List;
import java.util.ArrayList;

public class DataLists implements IDataStore {

	private List<Event> events;
	
	public DataLists() {
		events = new ArrayList<Event>();
	}
	
	public void createEvent(Event newEvent) {
		events.add(newEvent);
	}
	
	public Event searchEvent(String eventTitle) {
		
		Event theEvent = null;
		for (Event event: events) {
			if (event.getTitle().equals(eventTitle)) {
				theEvent = event;
				break;
			}
		}
		
		return theEvent;
		
	}
	
	public List<Event> getAllEvents() {
		return events;
	}
	
}
