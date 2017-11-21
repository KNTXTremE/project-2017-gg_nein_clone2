package application;

import graphic.*;
import window.SceneManager;

public class GameMain {
	private static DisplayModeSelect displayModeSelectCanvas;
	private static DisplaySongSelect displaySongSelectCanvas;
	private static InGame inGameCanvas;
	private static GameResult gameResultCanvas;
	
	public GameMain() {
		displayModeSelectCanvas = new DisplayModeSelect();
	
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
