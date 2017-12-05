package application;

import graphic.InGame;
import javafx.application.Platform;
import logic.GameLogic;
import logic.GameModel;
import window.SceneManager;

public abstract class GameMain {
	
	private static InGame ingame;
	private static GameLogic logic;
	private static GameModel model;
	
	public static void startInGame() {
		model = new GameModel();
		ingame = new InGame(model);
		logic = new GameLogic(model, ingame);
		SceneManager.gotoSceneOf(ingame);
		logic.startGame();
		ingame.startAnimation();
	}
	
	public static void resumeInGame() {
		SceneManager.gotoSceneOf(ingame);
		logic.resumeGame();
		ingame.resumeAnimation();
	}
	
	public static void pauseInGame() {
		logic.stopGame();
		ingame.stopAnimation();
	}
	
	public static void stopInGame() {
		logic.stopGame();
		ingame.stopAnimation();
		Platform.runLater(GameMain::moveToResult);
	}
	
	private static void moveToResult() {
		SceneManager.gotoGameResult();
	}
	
}