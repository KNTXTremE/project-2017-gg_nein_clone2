package graphic;

import javafx.scene.text.Font;

public interface Drawable {
	public static final int SCENE_WIDTH = 800;
	public static final int SCENE_HEIGHT = 600;
	public static final int INGAME_WIDTH = 480;
	public static final int INGAME_HEIGHT = 800;
	public static final Font MAIN_FONT = new Font("Monospace", 50);
	public static final Font SUBMAIN_FONT = new Font("Monospace", 25);
	public void setBackGround();
	public void setText();
	public void setHightLight(String selected_mode, double selected_width);
	public void setUnHightLight(String unsel_mode, double unsel_width);
}
