package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.Song;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class DisplaySongSelect extends CanvasManager implements Drawable {
	
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
		gc.setFont(SUBMAIN_FONT);
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillText(back, SCENE_WIDTH - back_width - 10, SCENE_HEIGHT - 10);
		gc.setFont(MAIN_FONT);
		gc.fillText(title, (SCENE_WIDTH - title_width)/2, SCENE_HEIGHT/5);
		for(Song x : model.getAllSongs()) {
			if(x.getSongNo() == 0) gc.setFill(Color.LIME);
			else gc.setFill(Color.ANTIQUEWHITE);
			gc.fillText(x.getSongName(), (SCENE_WIDTH - calculateTextWidth(x.getSongName(), MAIN_FONT)) / 2, 2 * SCENE_HEIGHT / 5);
		}
		
	}

	@Override
	public void setHightLight(String selected_mode, double selected_width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnHightLight(String unsel_mode, double unsel_width) {
		// TODO Auto-generated method stub
		
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	SceneManager.gotoModeSelect();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	model.getCountDownTimer().setTimeSecond(model.getAllSongs().get(0).getSongDuration());
                	GameMain.startInGame();
                }
			}
		}); 
	}
}
