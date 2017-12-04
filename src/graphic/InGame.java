package graphic;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameModel;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class InGame extends Canvas implements Drawable {

	private GraphicsContext gc = this.getGraphicsContext2D();
	
	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private Thread gameAnimation;
	private boolean isAnimationRunning;
	
	public InGame() {
		super(INGAME_WIDTH, INGAME_HEIGHT);
		//setBackGround();
		//setText();
		this.model = model;
		isAnimationRunning = false;
		startAnimation();
		EventHandler();
	}

	public void startAnimation() {
		gameAnimation = new Thread(this::animationLoop);
		isAnimationRunning = true;
		gameAnimation.start();
	}

	public void stopAnimation() {
		isAnimationRunning = false;
	}

	private void animationLoop() {
		double count = 0;
		while (isAnimationRunning) {
			updateAnimation(count);
			count+=0.5;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateAnimation(double count) {
		String test = "TEST";
		double test_height = count + 20;
		double test_width = fontLoader.computeStringWidth(test, MAIN_FONT);
		String time = "Time Left: ";
		double score_height = fontLoader.getFontMetrics(MAIN_FONT).getLineHeight(); 
		double time_height = fontLoader.getFontMetrics(MAIN_FONT).getLineHeight(); 
		double time_width = fontLoader.computeStringWidth(time, MAIN_FONT);

		// TODO fill code
		setBackGround();
		gc.setFill(Color.WHITE);
		gc.setFont(SUBMAIN_FONT);
		gc.fillText("Score: ", 10, 10 + score_height);
		gc.fillText(time  , INGAME_WIDTH - time_width - 10, 10 + time_height);
		gc.setFont(MAIN_FONT);
		gc.fillText(test , (INGAME_WIDTH - test_width)/2, test_height);
		gc.setFill(Color.GREEN);
		//gc.fillText(currentWordString.substring(0, model.getCurrentWordTypedCount()), wordX, wordY);
		
	}
	
	public void setBackGround(){
		//gc.setFill(Color.BLACK);
		//gc.fillRect(0, 0, INGAME_WIDTH, INGAME_HEIGHT);
		gc.drawImage(RenderableHolder.inGameBackground, 0, 0);
	}
	
	public void setText(){
		gc.setFill(Color.YELLOWGREEN);
		gc.setFont(MAIN_FONT);
		gc.fillText("TEST In Game", 600/2, 1000/2);
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	//TEST ONLY!!!, IF ALREADY CODED ANIMATION, PLS CHANGE TO PAUSE MODE
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
