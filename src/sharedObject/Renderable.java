package sharedObject;

import javafx.scene.canvas.GraphicsContext;

public interface Renderable {
	public int getZ();
	public void draw(GraphicsContext gc);
	public boolean isPressed();
}
