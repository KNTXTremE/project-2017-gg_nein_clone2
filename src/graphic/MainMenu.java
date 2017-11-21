package graphic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import window.SceneManager;

public class MainMenu extends Canvas implements Renderable {
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public MainMenu() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		setBackGround(gc);
		setText(gc);
		EventHandler();
	}
	
	public void setBackGround(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}

	public void setText(GraphicsContext gc) {
		gc.setFont(start_font);
		gc.setFill(Color.AQUA);
		gc.fillText("Welcome to LapLap Game", SCENE_WIDTH/5, SCENE_HEIGHT/2);
		gc.setTextAlign(TextAlignment.CENTER);
		EventHandler();
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	Platform.exit();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
//		    	 primarystage.setscene();
                }
			}
		}); 
	}
}