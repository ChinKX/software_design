package events.app;

import java.util.List;
import java.util.Scanner;
import events.domain.*;

public class AppUI {
	
	private Scanner scanner;
	private Controller controller;
	
	public AppUI() {
		scanner = new Scanner(System.in);
		controller = null;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void start() {
		
		int choice;

		do {
			System.out.println("Welcome to TechNerds' Event Management System");
			System.out.println("1. Create an event");
			System.out.println("2. Add talk for an event");
			System.out.println("3. Add guest to invite for an event");
			System.out.println("4. Update status of the invited guest");
			System.out.println("5. Display all events");
			System.out.println("6. Display list of talks for an event");
			System.out.println("7. Display list of guests for an event");
			System.out.println("8. Exit");

			System.out.print("Enter your choice (1-8): ");
			choice = scanner.nextInt();
			while (choice < 1 || choice > 8) {
				System.out.println("Invalid choice.");
				System.out.print("Enter your choice (1-8): ");
				choice = scanner.nextInt();
			}

			switch(choice) {
			case 1: createEvent(); break;
			case 2: addTalkForEvent(); break;
			case 3: addGuestForEvent(); break;
			case 4: updateGuestStatus(); break;
			case 5: displayAllEvents(); break;
			case 6: displayTalksForEvent(); break;
			case 7: displayGuestsForEvent(); break;
			case 8: break;
			}

			System.out.println();

		} while (choice != 8);

	}
	
	public void createEvent() {
		
		System.out.print("Enter title: ");
		String skip = scanner.nextLine();
		String title = scanner.nextLine();
		System.out.print("Enter date (DD/MM/YY): ");
		String date = scanner.nextLine();
		System.out.print("Enter venue: ");
		String venue = scanner.nextLine();
		System.out.print("Enter theme: ");
		String theme = scanner.nextLine();
		
		controller.createEvent(title, date, venue, theme);
		
		System.out.print("Event added successfully");
		System.out.println();
	}
	
	private Event selectEvent() {
		
		System.out.print("Enter event title to select: ");
		String skip = scanner.nextLine();
		String eventTitle = scanner.nextLine();
		
		Event selectedEvent = controller.searchEvent(eventTitle);
		
		if (selectedEvent != null) {
			System.out.println("The title of the event is: " + selectedEvent.getTitle());
			System.out.println("The date of the event is: " + selectedEvent.getDate());
			System.out.println("The venue of the event is: " + selectedEvent.getVenue());
			System.out.println("The theme of the event is: " + selectedEvent.getTheme());
		} else {
			System.out.println("No event with title \"" + eventTitle  + "\" found");
		}
		System.out.println();
		
		return selectedEvent;
	}
	
	private Guest selectGuestInEvent() {
		
		Event selectedEvent = selectEvent();
		
		Guest selectedGuest = null;
		
		if (selectedEvent != null) {
			System.out.print("Enter guest name to select: ");
			//String skip = scanner.nextLine();
			String guestName = scanner.nextLine();
			
			selectedGuest = selectedEvent.searchGuest(guestName);
			
			if (selectedGuest != null) {
				System.out.println("The name of the guest is: " + selectedGuest.getName());
				System.out.println("The contact number of the guest is: " + selectedGuest.getContactNo());
				System.out.println("The status of the guest is Pending");
			} else {
				System.out.println("No guest with name \"" + guestName  + "\" found");
			}
			System.out.println();
		}
		
		return selectedGuest;
		
	}
	
	public void addTalkForEvent() {
		
		Event selectedEvent = selectEvent();
		
		if (selectedEvent != null) {
			System.out.print("Enter talk title: ");
			//String skip = scanner.nextLine();
			String title = scanner.nextLine();
			System.out.print("Enter talk speaker: ");
			String speaker = scanner.nextLine();
			System.out.print("Enter talk duration (hours): ");
			String duration = scanner.nextLine();

			controller.addTalk(selectedEvent, title, speaker, duration);
			System.out.println("Talk added to the event.");
		}
		System.out.println();
		
	}
	
	public void addGuestForEvent() {
		
		Event selectedEvent = selectEvent();
		
		if (selectedEvent != null) {
			System.out.print("Enter guest name: ");
			//String skip = scanner.nextLine();
			String name = scanner.nextLine();
			System.out.print("Enter guest contact number: ");
			String contactNo = scanner.nextLine();

			controller.addGuest(selectedEvent, name, contactNo);
			System.out.println("Guest added to the event.");
		}
		System.out.println();
		
	}
	
	public void updateGuestStatus() {
		
		Guest selectedGuest = selectGuestInEvent();
		
		if (selectedGuest != null) {
			System.out.print("Enter new guest status (A/a for accpeted OR D/d for declined): ");
			//String skip = scanner.nextLine();
			String status = scanner.nextLine();

			controller.updateGuestStatus(selectedGuest,status);
			System.out.println("Guest status updated.");
		}
		System.out.println();
		
	}
	
	public void displayAllEvents() {
		
		List<Event> events = controller.getAllEvents();
		
		if (events.size() != 0) {
			Event event;
			
			System.out.println("Events List");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			System.out.println("No.\tTitle\t\t\tDate\t\t\t\tVenue\t\t\tTheme");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
			for (int i = 0; i < events.size(); i++) {
				event = events.get(i);
				System.out.println((i + 1) + ".\t" + event.getTitle() + "\t\t\t" + event.getDate() + "\t\t\t" + event.getVenue() + "\t\t\t"
						+ event.getTheme());
			}
		} else {
			System.out.println("No events to show");
		}
		
	}
	
	public void displayTalksForEvent() {
		
		Event selectedEvent = selectEvent();
		
		if (selectedEvent != null) {
			
			List<Talk> talks = selectedEvent.retrieveTalks();
			
			if (talks.size() != 0) {
				Talk talk;
				
				System.out.println("Talks List for " + selectedEvent.getTitle());
				System.out.println("--------------------------------------------------------------------------------------------");
				System.out.println("No.\tTitle\t\t\t\tSpeaker\t\t\tDuration");
				System.out.println("--------------------------------------------------------------------------------------------");
				
				for (int i = 0; i < talks.size(); i++) {
					talk = talks.get(i);
					System.out.println((i + 1) + ".\t" + talk.getTitle() + "\t\t\t" + talk.getSpeaker() + "\t\t\t" + talk.getDuration() + " hours");
				}
			} else {
				System.out.println("No talks to show");
			}
			
		}
		System.out.println();
		
	}
	
	public void displayGuestsForEvent() {
		
		Event selectedEvent = selectEvent();
		
		if (selectedEvent != null) {
			
			List<Guest> guests = selectedEvent.retrieveGuests();
			
			if(guests.size() != 0) {
				Guest guest;
				
				System.out.println("Guests List for " + selectedEvent.getTitle());
				System.out.println("--------------------------------------------------------------------------------------------");
				System.out.println("No.\tName\t\t\tContact Number\t\t\tStatus");
				System.out.println("--------------------------------------------------------------------------------------------");
				
				for (int i = 0; i < guests.size(); i++) {
					guest = guests.get(i);
					
					System.out.println((i + 1) + ".\t" + guest.getName() + "\t\t\t" + guest.getContactNo() + "\t\t\t" + guest.getStatus().toString());
				}
			} else {
				System.out.println("No guests to show");
			}
			
		}
		System.out.println();
		
	}
	
}
