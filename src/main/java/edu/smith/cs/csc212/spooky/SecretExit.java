package edu.smith.cs.csc212.spooky;

public class SecretExit extends Exit{
	
	private boolean hidden;

	public SecretExit(String target, String description) {
		super(target, description);
		this.hidden = true; 
	}
	
	@Override
	public boolean isSecret() {
		return hidden;	
	}
	
	@Override
	public void search() {
		hidden = false;
	}
}
