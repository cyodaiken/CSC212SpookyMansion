package edu.smith.cs.csc212.spooky;

public class GameTime {
	
	public int hour;
	
	public int hoursSpent;
	
	
	public GameTime() {
		this.hour = 20;	
		this.hoursSpent = 0;
	}
	
	public int getHour() {
		
		return hour;
	}
	
	public int getHoursSpent() {
		
		return hoursSpent;
	}
	
	public void increaseHour() {
		
		if(this.hour < 23) {
			this.hour += 1;
		} else {
			this.hour = 0;
		}
		this.hoursSpent += 1;
	}
	
	public boolean isNightTime() {
		
		return this.hour > 19 || this.hour < 7;
			
	}	

}
