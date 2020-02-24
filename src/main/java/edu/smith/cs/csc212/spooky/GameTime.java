package edu.smith.cs.csc212.spooky;

public class GameTime {
	
	public int hour;
	
	public int hoursSpent;
	
	public GameTime() {
		this.hour = 0;	
		this.hoursSpent = 0;
	}
	
	public int getHour() {
		
		return hour;
	}
	
	public int getHoursSpent() {
		
		return hoursSpent;
	}
	
	public void increaseHour() {
		
		if(this.hour < 24) {
			this.hour += 1;
		} else {
			this.hour = 0;
		}
		this.hoursSpent += 1;
	}

}
