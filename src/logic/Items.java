package logic;

import sharedObject.Renderable;

public abstract class Items implements Renderable {
	
	protected int x;
	protected double y;
	protected int z;
	protected boolean isPressed, visible;
	
	public Items() {
		isPressed = false;
		visible = true;
	}

	public int getZ() {
		return z;
	}
	
	public boolean isPressed() {
		return isPressed;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
}
