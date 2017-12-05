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
	
	public static void stopInGame() {
		logic.stopGame();
		ingame.stopAnimation();
		Platform.runLater(GameMain::moveToResult);
	}
	
	private static void moveToResult() {
		SceneManager.gotoGameResult();
	}
	
}