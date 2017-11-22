package graphic;

import application.GameMain;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class MainMenu extends Canvas implements Drawable {
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public MainMenu() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		setBackGround();
		setText();
		EventHandler();
	}
	
	public void setBackGround() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT);
	}

	public void setText() {
		String title = "Welcome to LapLap!";
		String desc = "Press Enter to Start";
		double title_width = fontLoader.computeStringWidth(title, MAINMENU_FONT);
		double desc_width = fontLoader.computeStringWidth(desc, MAINMENU_FONT);
		gc.setFont(MAINMENU_FONT);
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillText(title, (SCENE_WIDTH - title_width)/2, SCENE_HEIGHT/3);
		gc.fillText(desc, (SCENE_WIDTH - desc_width)/2, 2*SCENE_HEIGHT/3);
		
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	Platform.exit();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	GameMain.newGame();
                	GameMain.gotoModeSelect();
                }
			}
		}); 
	}
}