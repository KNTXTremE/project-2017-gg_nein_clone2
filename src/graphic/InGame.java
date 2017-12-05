package graphic;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.GameModel;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class InGame extends CanvasManager implements Drawable {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private Thread gameAnimation;
	private boolean isAnimationRunning;
	
	public InGame(GameModel model) {
		super(INGAME_WIDTH, INGAME_HEIGHT);
		super.model = model;
		gc = this.getGraphicsContext2D();
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
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateAnimation(double count) {
		String test = "TEST";
		double test_height = count + 20;
		double test_width = calculateTextWidth(test, MAIN_FONT);
		String time = "Time Left: " + model.getTime().toMinute();
		double score_height = calculateTextHeight(MAIN_FONT); 
		double time_height = calculateTextHeight(MAIN_FONT); 
		double time_width = calculateTextWidth(time, MAIN_FONT);

		// TODO fill code
		setBackGround();
		gc.setFill(Color.WHITE);
		gc.setFont(SUBMAIN_FONT);
		gc.fillText("Score: ", 10, 10 + score_height);
		gc.fillText(time  , INGAME_WIDTH - time_width - 10, 10 + time_height);
		gc.setFont(MAIN_FONT);
		gc.fillText(test , (INGAME_WIDTH - test_width)/2, test_height);
		model.getTime().countDown();
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
                	SceneManager.gotoSongSelect();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	//TEST ONLY!!!, IF ALREADY CODED COUNTDOWN TIMER, PLS REMOVE THIS LINE
                	SceneManager.gotoGameResult();
                }
			}
		}); 
	}

	@Override
	public void setHightLight(String selected_mode, double selected_width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnHightLight(String unsel_mode, double unsel_width) {
		// TODO Auto-generated method stub
		
	}
}
