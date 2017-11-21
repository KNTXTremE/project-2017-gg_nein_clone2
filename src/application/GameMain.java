package application;

import graphic.*;
import window.SceneManager;

public class GameMain {
	private static DisplayModeSelect displayModeSelectCanvas = new DisplayModeSelect();
	private static DisplaySongSelect displaySongSelectCanvas;
	private static InGame inGameCanvas;
	private static GameResult gameResultCanvas;
	
	public GameMain() {
//		displayModeSelectCanvas = new DisplayModeSelect();
//		displaySongSelectCanvas = new DisplaySongSelect();
//		inGameCanvas = new InGame();
//		gameResultCanvas = new GameResult();
		
	
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
