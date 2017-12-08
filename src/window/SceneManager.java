package window;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import graphic.*;

public class SceneManager {
	private static Stage primaryStage;
	private static Canvas mainMenuCanvas = new MainMenu();
	private static Scene mainMenuScene = new Scene(new Pane(mainMenuCanvas));
	private static DisplayModeSelect displayModeSelectCanvas;
	private static DisplaySongSelect displaySongSelectCanvas;
	private static Pause pauseCanvas;
	private static GameResult gameResultCanvas;

	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.show();
		}
	public static void gotoMainMenu() {
		primaryStage.setScene(mainMenuScene);
		
		mainMenuCanvas.requestFocus();
	}
	public static void gotoSceneOf(Canvas canvas) {
		Scene scene = new Scene(new Pane(canvas));
		primaryStage.setScene(scene);
		canvas.requestFocus();
	}
	
	public static void newGame() {
		if(displayModeSelectCanvas == null) displayModeSelectCanvas = new DisplayModeSelect();
		if(displaySongSelectCanvas == null) displaySongSelectCanvas = new DisplaySongSelect();
		if(pauseCanvas == null) pauseCanvas = new Pause();
	}
	
	public static void newGameResult() {
		if(gameResultCanvas == null) gameResultCanvas = new GameResult();
	}
	
	public static void gotoModeSelect() {
		gotoSceneOf(displayModeSelectCanvas);
	}
	
	public static void gotoSongSelect() {
		gotoSceneOf(displaySongSelectCanvas);
	}
	
	public static void gotoPause() {
		gotoSceneOf(pauseCanvas);
	}

	public static void gotoGameResult() {
		gotoSceneOf(gameResultCanvas);
	}	

}