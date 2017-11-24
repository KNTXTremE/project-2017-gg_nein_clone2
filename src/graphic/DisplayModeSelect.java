package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class DisplayModeSelect extends Canvas implements Drawable {
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public DisplayModeSelect() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		setBackGround();
		setText();
		EventHandler();
	}
	
	public void setBackGround(){
		gc.setFill(Color.BLACK);
		gc.drawImage(RenderableHolder.menuBackground, 0, 0);
	}
	
	public void setText(){
		String title = "Select Your Mode";
		String diff = "Easy  Normal  Hard  Custom";
		double title_width = fontLoader.computeStringWidth(title, MAINMENU_FONT);
		double diff_width = fontLoader.computeStringWidth(diff, MAINMENU_FONT);
		gc.setFont(MAINMENU_FONT);
		gc.setFill(Color.LIME);
		gc.fillText(title, (SCENE_WIDTH - title_width)/2, SCENE_HEIGHT/3);
		gc.fillText(diff, (SCENE_WIDTH - diff_width)/2, 2*SCENE_HEIGHT/3);
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	SceneManager.gotoMainMenu();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	GameMain.gotoSongSelect();
                }
			}
		}); 
	}
}