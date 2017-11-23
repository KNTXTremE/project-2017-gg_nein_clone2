package window;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import graphic.MainMenu;

public class SceneManager {
	private static Stage primaryStage;
	private static Canvas mainMenuCanvas = new MainMenu();
	private static Scene mainMenuScene = new Scene(new Pane(mainMenuCanvas));

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
}