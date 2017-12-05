package graphic;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class DisplaySongSelect extends GameMain implements Drawable {
	
	public DisplaySongSelect() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		gc = this.getGraphicsContext2D();
		setBackGround();
		setText();
		EventHandler();
	}
	
	public void setBackGround(){
		gc.setFill(Color.BLACK);
		gc.drawImage(RenderableHolder.menuBackground, 0, 0);
	}
	
	public void setText(){
		String title = "Select the Song";
		String back = "ESC: Back";
		double title_width = calculateTextWidth(title, MAIN_FONT);
		double back_width = calculateTextWidth(back, SUBMAIN_FONT);
		gc.setFont(MAIN_FONT);
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillText(title, (SCENE_WIDTH - title_width)/2, SCENE_HEIGHT/3);
		gc.setFont(SUBMAIN_FONT);
		gc.fillText(back, SCENE_WIDTH - back_width - 10, SCENE_HEIGHT - 10);
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	GameMain.gotoModeSelect();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	GameMain.gotoInGame();
                }
			}
		}); 
	}
}
