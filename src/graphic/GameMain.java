package graphic;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import logic.GameModel;

public abstract class GameMain extends Canvas {
	protected GameModel model;
	protected GraphicsContext gc;
	FontLoader fontLoader;
	
	public GameMain(int sceneWidth, int sceneHeight) {
		// TODO Auto-generated constructor stub
		super(sceneWidth, sceneHeight);
		fontLoader = Toolkit.getToolkit().getFontLoader();
		model = new GameModel();
	}
	
	public double calculateTextWidth(String text, Font font) {
		return fontLoader.computeStringWidth(text, font);
	}
	
	public double calculateTextHeight(Font font) {
		return fontLoader.getFontMetrics(font).getLineHeight();
	}
	
}