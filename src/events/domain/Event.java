package events.domain;

import java.util.List;
import java.util.ArrayList;

public class Event {
	
	private String title;
	private String date;
	private String venue;
	private String theme;
	private List<Talk> talks;
	private List<Guest> guests;
	
	public Event(String title, String date, String venue, String theme) {
		this.title = title;
		this.date = date;
		this.venue = venue;
		this.theme = theme;
		talks = new ArrayList<Talk>();
		guests = new ArrayList<Guest>();
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public String getTheme() {
		return theme;
	}
	
	public void assignTalk(Talk newTalk) {
		talks.add(newTalk);
	}
	
	public void assignGuest(Guest newGuest) {
		guests.add(newGuest);
	}
	
	public List<Talk> retrieveTalks() {
		return talks;
	}
	
	public List<Guest> retrieveGuests() {
		return guests;
	}
	
	public Guest searchGuest(String guestName) {
		
		Guest selectedGuest = null;
		
		for (Guest guest: guests) {
			if (guest.getName().equals(guestName)) {
				selectedGuest = guest;
				break;
			}
		}
		
		return selectedGuest;
		
	}
	
}
