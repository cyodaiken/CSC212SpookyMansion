package edu.smith.cs.csc212.spooky;

/**
 * This subclass represents a secret exit from a Place to 
 * another Place. The player has to search for it.
 * @author 
 *
 */

public class SecretExit extends Exit{
	/**
	 * Allows exits to be 'seen' by the player or not
	 */
	private boolean hidden;
	/**
	 * Create a new SecretExit 
	 * @param target - where it goes
	 * @param description - how it looks
	 */
	public SecretExit(String target, String description) {
		super(target, description);
		this.hidden = true; 
	}

	@Override
	/**
	 * allows game to know if the exit is secret
	 * @return true if the exit is hidden
	 */
	public boolean isSecret() {
		return hidden;	
	}

	/**
	 * if the player searches for the exit it is no longer secret 
	 */
	@Override
	public void search() {
		hidden = false;
	}
}
