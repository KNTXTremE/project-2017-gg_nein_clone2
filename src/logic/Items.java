package logic;

import sharedObject.Renderable;

public abstract class Items implements Renderable {
	
	protected int x, y;
	protected int z;
	protected boolean isPressed;
	
	public Items() {
		this.isPressed = false;
	}

	public int getZ() {
		return z;
	}
	
	public boolean isPressed() {
		return isPressed;
	}
	
}
