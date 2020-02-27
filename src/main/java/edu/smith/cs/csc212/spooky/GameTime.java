package edu.smith.cs.csc212.spooky;

/**
 * This represents time system of the game.
 * @author 
 *
 */

public class GameTime {
	/**
	 * This is the time when the game starts
	 */
	private int hour;
	/**
	 * This is the elapsed time of the game. 
	 */
	private int hoursSpent;
	/**
	 * constructor for GameTime
	 */
	public GameTime() {

		this.hour = 20;	
		this.hoursSpent = 0;
	}
	/** 
	 *
	 * @return the time in the game
	 */
	public int getHour() {

		return hour;
	}
	/**
	 * 
	 * @return the elapsed time once the game is over
	 */
	public int getHoursSpent() {

		return hoursSpent;
	}
	/**
	 * Increases the time and the elapsed time 
	 */
	public void increaseHour() {

		if(this.hour < 23) {
			this.hour += 1;
		} else {
			this.hour = 0;
		}
		this.hoursSpent += 1;
	}
	/**
	 * For InteractiveFiction, whether it is night or not.
	 * @return true if it is night time.
	 */
	public boolean isNightTime() {

		return this.hour > 19 || this.hour < 7;

	}	

}
