package events.app;

import events.domain.*;

public class EventManagementApp {
	
	public static void main(String[] args) {
		IDataStore dataLists = new DataLists();
		
		Controller controller = new Controller();

		controller.setEventList(dataLists);
		
		AppUI userInterface = new AppUI();

		userInterface.setController(controller);

		userInterface.start();

	}
	
}