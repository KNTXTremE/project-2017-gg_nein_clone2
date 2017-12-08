package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Pause extends CanvasManager implements Drawable {

	public Pause() {
		super(INGAME_WIDTH, INGAME_HEIGHT);
		gc = this.getGraphicsContext2D();
		setBackGround();
		setText();
		EventHandler();
	}

	@Override
	public void setBackGround() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, INGAME_WIDTH, INGAME_HEIGHT);
	}

	@Override
	public void setText() {
		String title = "- Pause -";
		String back = "ESC: Play";
		double title_width = calculateTextWidth(title, MAIN_FONT);
		double back_width = calculateTextWidth(back, SUBMAIN_FONT);
		gc.setFont(MAIN_FONT);
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillText(title, (INGAME_WIDTH - title_width)/2, INGAME_HEIGHT/3);
		gc.setFont(SUBMAIN_FONT);
		gc.fillText(back, INGAME_WIDTH - back_width - 10, INGAME_HEIGHT - 10);
		
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
				if (event.getCode().equals(KeyCode.ESCAPE)) {
					GameMain.resumeInGame();
				}
			}
		}); 
	}

}
