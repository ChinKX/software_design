package events.domain;

public class Guest {
	
	private String name;
	private String contactNo;
	private Status status;
	
	public Guest(String name, String contactNo) {
		this.name = name;
		this.contactNo = contactNo;
		status = Status.Pending;
	}
	
	public String getName() {
		return name;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		if (status.toLowerCase().equals("a"))
			this.status = Status.Accepted;
		else
			this.status = Status.Declined;
	}
	
}
