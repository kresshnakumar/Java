class Appointment {
	private String date;
	private int duration;
	private String datee;
	private int durationn;
	private String name;
	private String venue;
	public Appointment(String date , int duration) {
		this.date = date;
		this.duration = duration;
	}
	public Appointment(String name , String date , int duration , String venue) {
		this.name = name;
		this.datee = datee;
		this.durationn = durationn;
		this.venue = venue;
	}
	public String getDatee() {
		return date;
	}
	public int getDuration(){
		return duration;
	}
	public String getDateee() {
		return datee;
	}
	public int getDurationn(){
		return durationn;
	}
	public String getVenue() {
		return venue;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return date + " - "+ Integer.toString(duration) + " mins ";
	}
}