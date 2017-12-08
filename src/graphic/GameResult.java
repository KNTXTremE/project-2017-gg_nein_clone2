package graphic;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class GameResult extends CanvasManager implements Drawable {
	
	public GameResult() {
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
		gc.setFill(Color.ANTIQUEWHITE);
		gc.setFont(MAIN_FONT);
		String result = "Your score is: " + model.getScore();
		String back = "ESC: Exit";
		double result_width = calculateTextWidth(result, MAIN_FONT);
		double back_width = calculateTextWidth(back, SUBMAIN_FONT);
		double font_height = calculateTextHeight(MAIN_FONT);
		gc.fillText(result, (SCENE_WIDTH - result_width) / 2, (SCENE_HEIGHT - font_height) / 2 + font_height);
		gc.setFont(SUBMAIN_FONT);
		gc.fillText(back, SCENE_WIDTH - back_width - 10, SCENE_HEIGHT - 10);
		if(model.getCombo() == model.getAllSongs().get(model.getSelectedSong()).getSongNotes().size()) 
			new Alert(AlertType.NONE, "YOU GOT AN ALL COMBO! CONGRATULATIONS!.", ButtonType.OK).showAndWait();
	}
	
	@Override
	public void setHightLight(String selected_mode, double selected_width) {
		
	}

	@Override
	public void setUnHightLight(String unsel_mode, double unsel_width) {
		
	}
	
	public void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	Platform.exit();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	Platform.exit();
                }
			}
		}); 
	}
}
