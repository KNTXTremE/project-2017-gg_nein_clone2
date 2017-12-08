package graphic;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import logic.GameModel;

@SuppressWarnings("restriction")
public class CanvasManager extends Canvas {

	protected static GameModel model;
	protected GraphicsContext gc;
	FontLoader fontLoader;
	
	public CanvasManager(int sceneWidth, int sceneHeight) {
		// TODO Auto-generated constructor stub
		super(sceneWidth, sceneHeight);
		fontLoader = Toolkit.getToolkit().getFontLoader();
		if(model == null) model = new GameModel();
	}
	
	public double calculateTextWidth(String text, Font font) {
		return fontLoader.computeStringWidth(text, font);
	}
	
	public double calculateTextHeight(Font font) {
		return fontLoader.getFontMetrics(font).getLineHeight();
	}

	public static GameModel getModel() {
		return model;
	}
}
