package application;

import graphic.*;
import javafx.scene.canvas.Canvas;
import logic.GameModel;
import window.SceneManager;

public class GameMain extends Canvas {
	private static DisplayModeSelect displayModeSelectCanvas;
	private static DisplaySongSelect displaySongSelectCanvas;
	private static InGame inGameCanvas;
	private static GameResult gameResultCanvas;
	
	public GameMain(int sceneWidth, int sceneHeight) {
		// TODO Auto-generated constructor stub
		super(sceneWidth, sceneHeight);
	}

	public static void newGame() {
		if(displayModeSelectCanvas == null) displayModeSelectCanvas = new DisplayModeSelect();
		if(displaySongSelectCanvas == null) displaySongSelectCanvas = new DisplaySongSelect();
		if(inGameCanvas == null) inGameCanvas = new InGame();
		if(gameResultCanvas == null) gameResultCanvas = new GameResult();
	}
	
	public static void gotoModeSelect() {
		SceneManager.gotoSceneOf(displayModeSelectCanvas);
	}
	
	public static void gotoSongSelect() {
		SceneManager.gotoSceneOf(displaySongSelectCanvas);
	}
	
	public static void gotoInGame() {
		SceneManager.gotoSceneOf(inGameCanvas);
	}

	public static void gotoGameResult() {
		SceneManager.gotoSceneOf(gameResultCanvas);
	}	
}