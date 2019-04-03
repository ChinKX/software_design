package events.domain;

import java.util.List;

public class Controller {
	
	private IDataStore dataLists;
	
	public Controller() {
		dataLists = new DataLists();
	}
	
	public void setEventList(IDataStore dataLists) {
		this.dataLists = dataLists;
	}
	
	public void createEvent(String title, String date, String venue, String theme) {
		Event newEvent = new Event(title, date, venue, theme);
		dataLists.createEvent(newEvent);
	}
	
	public Event searchEvent(String eventTitle) {
		return dataLists.searchEvent(eventTitle);
	}
	
	public void addTalk(Event selectedEvent, String title, String speaker, String duration) {
		Talk newTalk = new Talk(title, speaker, duration);
		selectedEvent.assignTalk(newTalk);
	}
	
	public void addGuest(Event selectedEvent, String name, String contactNo) {
		Guest newGuest = new Guest(name, contactNo);
		selectedEvent.assignGuest(newGuest);
	}
	
	public void updateGuestStatus(Guest selectedGuest, String status) {
		selectedGuest.setStatus(status);
	}
	
	public List<Event> getAllEvents() {
		return dataLists.getAllEvents();
	}
	
}
