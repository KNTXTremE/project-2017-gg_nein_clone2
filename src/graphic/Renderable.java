package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

public interface Renderable {
	public static final int SCENE_WIDTH = 800;
	public static final int SCENE_HEIGHT = 600;
	public static final Font start_font = new Font("Times new Roman", 50);
	public void setBackGround(GraphicsContext gc);
	public void setText(GraphicsContext gc);
	//public void EventHandler();
}
