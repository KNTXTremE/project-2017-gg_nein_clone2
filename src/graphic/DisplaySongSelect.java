package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class DisplaySongSelect extends GameMain implements Drawable {
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public DisplaySongSelect() {
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
		String title = "Select Song";
		String back = "ESC: Back";
		double title_width = fontLoader.computeStringWidth(title, MAIN_FONT);
		double back_width = fontLoader.computeStringWidth(back, SUBMAIN_FONT);
		gc.setFont(MAIN_FONT);
		gc.setFill(Color.BLANCHEDALMOND);
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
