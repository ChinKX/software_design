package events.domain;

public class Talk {
	
	private String title;
	private String speaker;
	private String duration;
	
	public Talk(String title, String speaker, String duration) {
		this.title = title;
		this.speaker = speaker;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpeaker() {
		return speaker;
	}
	
	public String getDuration() {
		return duration;
	}
	
}