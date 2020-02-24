package edu.smith.cs.csc212.spooky;

public class LockedExit extends Exit {
	
	String key;
	
	public LockedExit(String target, String description, String key) {
		super(target, description);
		this.key = key;
	}
	
	@Override
	public boolean canOpen(Player player) {
		return player.inventory.contains(key);

}
}