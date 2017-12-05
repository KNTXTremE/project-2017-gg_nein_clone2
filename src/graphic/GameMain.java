package graphic;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import logic.GameModel;

	private static DisplayModeSelect displayModeSelectCanvas;
	private static DisplaySongSelect displaySongSelectCanvas;
	private static InGame inGameCanvas;
	private static GameResult gameResultCanvas;
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

	public static void newGame() {
		if(displayModeSelectCanvas == null) displayModeSelectCanvas = new DisplayModeSelect();
		if(displaySongSelectCanvas == null) displaySongSelectCanvas = new DisplaySongSelect();
		if(inGameCanvas == null) inGameCanvas = new InGame();
		if(gameResultCanvas == null) gameResultCanvas = new GameResult();
	}
	
	public static void gotoModeSelect() {
		SceneManager.gotoSceneOf(displayModeSelectCanvas);
	public double calculateTextWidth(String text, Font font) {
		return fontLoader.computeStringWidth(text, font);
	}
	
	public static void gotoSongSelect() {
		SceneManager.gotoSceneOf(displaySongSelectCanvas);
	public double calculateTextHeight(Font font) {
		return fontLoader.getFontMetrics(font).getLineHeight();
	}
	
	public static void gotoInGame() {
		SceneManager.gotoSceneOf(inGameCanvas);
	}

	public static void gotoGameResult() {
		SceneManager.gotoSceneOf(gameResultCanvas);
	}	
}