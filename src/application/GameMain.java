package application;

import graphic.InGame;
import javafx.application.Platform;
import logic.GameLogic;
import window.SceneManager;

public class GameMain {
	
	private static InGame ingame;
	private static GameLogic logic;
	
	public static void startInGame() {
		ingame = new InGame();
		logic = new GameLogic(ingame);
		SceneManager.gotoSceneOf(ingame);
		logic.startGame();
		ingame.startAnimation();
	}
	
	public static void stopInGame() {
		logic.stopGame();
		ingame.stopAnimation();
		Platform.runLater(GameMain::moveToResult);
	}
	
	private static void moveToResult() {
		SceneManager.newGameResult();
		SceneManager.gotoGameResult();
	}
}