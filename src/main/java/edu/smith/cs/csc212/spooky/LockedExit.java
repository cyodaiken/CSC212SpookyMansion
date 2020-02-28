package edu.smith.cs.csc212.spooky;

/**
 * This subclass represents an exit from a Place to another Place.
 * @author 
 *
 */

public class LockedExit extends Exit {
	/**
	 * 'stuff' the player needs to open a locked exit
	 */
	private String key;

	/**
	 * create a new locked exit
	 * @param target - where it goes
	 * @param description - how it looks
	 * @param key - what player needs to open exit
	 */
	public LockedExit(String target, String description, String key) {
		super(target, description);
		this.key = key;
	}

	/**
	 * return true if the exit can open (if the player has the key)
	 */
	@Override
	public boolean canOpen(Player player) {
		return player.inventory.contains(key);

	}
}