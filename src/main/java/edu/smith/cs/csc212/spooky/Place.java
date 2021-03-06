package edu.smith.cs.csc212.spooky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This represents a place in our text adventure.
 * @author jfoley
 *
 */
public class Place {
	/**
	 * This is a list of places we can get to from this place.
	 */
	private List<Exit> exits;
	/**
	 * This is the identifier of the place.
	 */
	private String id;
	/**
	 * What to tell the user about this place.
	 */
	private String description;
	/**
	 * What to tell the user about this place during the daytime. 
	 */
	private String dayDescription;
	/**
	 * Whether reaching this place ends the game.
	 */
	private boolean terminal;
	/**
	 * The items that a place can have 
	 */
	private List<String> items;

	/**
	 * Internal only constructor for Place. Use {@link #create(String, String)} or {@link #terminal(String, String)} instead.
	 * @param id - the internal id of this place.
	 * @param description - the user-facing description of the place.
	 * @param terminal - whether this place ends the game.
	 */
	protected Place(String id, String description, boolean terminal) {

		this.id = id;
		this.description = description;
		this.dayDescription = description;
		this.exits = new ArrayList<>();
		this.terminal = terminal;
		this.items = new ArrayList<>();

	}

	/**
	 * Create an exit for the user to navigate to another Place.
	 * @param exit - the description and target of the other Place.
	 */
	public void addExit(Exit exit) {
		
		this.exits.add(exit);
	}

	/**
	 * Allows a place to have an item that can be picked up by the player
	 * @param description- what the item is
	 */
	public void addItem(String description){
		
		this.items.add(description);
	}

	/**
	 * Allows player to get all the items in a place at once 
	 * @return all the items that a place has
	 */
	public List<String> getItems() {

		return this.items;
	}

	/**
	 * For gameplay, whether this place ends the game.
	 * @return true if this is the end.
	 */
	public boolean isTerminalState() {
		
		return this.terminal;
	}

	/**
	 * The internal id of this place, for referring to it in {@link Exit} objects.
	 * @return the id.
	 */
	public String getId() {
		
		return this.id;
	}

	/**
	 * The narrative description of this place.
	 * @return what we show to a player about this place.
	 */
	public String printDescription(GameTime hour) {

		if (hour.isNightTime()) {		
			return this.description;
		} else {
			return this.dayDescription;
		}
	}
	
	/**
	 * sets the description to the day description 
	 * @param dayDescription
	 */
	public void setDayDescription(String dayDescription) {

		this.dayDescription = dayDescription; 
	}

	/**
	 * Get a view of the exits from this Place, for navigation.
	 * @return all the exits from this place.
	 */
	public List<Exit> getVisibleExits() {
		
		List<Exit> visible = new ArrayList<>();
		for (Exit e : this.exits) {
			if (!e.isSecret()) {
				visible.add(e);
			}
		}
		return visible;
	}

	/**
	 * This is a terminal location (good or bad).
	 * @param id - this is the id of the place (for creating {@link Exit} objects that go here).
	 * @param description - this is the description of the place.
	 * @return the Place object.
	 */
	public static Place terminal(String id, String description) {
		return new Place(id, description, true);
	}

	/**
	 * Create a place with an id and description.
	 * @param id - this is the id of the place (for creating {@link Exit} objects that go here).
	 * @param description - this is what we show to the user.
	 * @return the new Place object (add exits to it).
	 */
	public static Place create(String id, String description) {
		
		return new Place(id, description, false);
	}

	/**
	 * Implements what we need to put Place in a HashSet or HashMap.
	 */
	public int hashCode() {
		
		return this.id.hashCode();
	}

	/**
	 * Give a string for debugging what place is what.
	 */
	public String toString() {
		
		return "Place("+this.id+" with "+this.exits.size()+" exits.)";
	}

	/**
	 * Whether this is the same place as another.
	 */
	public boolean equals(Object other) {
		if (other instanceof Place) {
			return this.id.equals(((Place) other).id);
		}
		return false;
	}

	// TA Lauren helped me w/ this
	/**
	 * Allows player to search for hidden exits 
	 */
	public void search() {
		// calls search in Exit because it is a Exit object
		for(Exit exit : exits) {
			exit.search();
		}
	}
}
