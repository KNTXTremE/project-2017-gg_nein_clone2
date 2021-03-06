package sharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface Renderable {
	public int getZ();
	public void draw(GraphicsContext gc, int count);
	public void update();
	public boolean isPressed();
	public boolean isVisible();
}
