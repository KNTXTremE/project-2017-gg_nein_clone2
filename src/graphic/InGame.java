package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import window.SceneManager;

public class InGame extends Canvas implements Drawable {

	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public InGame() {
		super(600, 1000);
		setBackGround();
		setText();
		EventHandler();
	}
	
	public void setBackGround(){
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, INGAME_WIDTH, INGAME_HEIGHT);
	}
	
	public void setText(){
		gc.setFill(Color.YELLOWGREEN);
		gc.setFont(TEXT_FONT);
		gc.fillText("TEST In Game", 600/2, 1000/2);
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	GameMain.gotoSongSelect();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	//TEST ONLY!!!, IF ALREADY CODED COUNTDOWN TIMER, PLS REMOVE THIS LINE
                	GameMain.gotoGameResult();
                }
			}
		}); 
	}
}
