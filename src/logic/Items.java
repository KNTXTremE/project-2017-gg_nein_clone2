package logic;

import graphic.CanvasManager;
import sharedObject.Renderable;

public abstract class Items implements Renderable {
	
	protected int x;
	protected double y;
	protected int z;
	protected boolean isPressed, visible;
	protected GameModel model;
	
	public Items() {
		isPressed = false;
		visible = true;
		model = CanvasManager.getModel();
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
