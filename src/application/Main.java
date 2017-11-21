package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import window.SceneManager;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SceneManager.initialize(primaryStage);
			SceneManager.gotoMainMenu();
			primaryStage.setTitle("LapLap Game");
			primaryStage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
