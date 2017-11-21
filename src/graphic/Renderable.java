package graphic;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

public interface Renderable {
	public static final int SCENE_WIDTH = 800;
	public static final int SCENE_HEIGHT = 600;
	public static final Font TEXT_FONT = new Font(50);
	public static final Font MAINMENU_FONT = new Font("Times new Roman Bold", 50);
	public static final Font DISPLAYMODE_FONT = new Font(50);
	FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
	public void setBackGround();
	public void setText();
}
