package edu.smith.cs.csc212.spooky;

public class LockedExit extends Exit {
	
	boolean key;
	
	public LockedExit(String target, String description) {
		super(target, description);
		this.key = false;
	}
	
	@Override
	public boolean canOpen() {
		
		return key;
	}

}
