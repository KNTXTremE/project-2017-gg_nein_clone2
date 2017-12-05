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
		long last = System.nanoTime();
		int count = 0;
		while (isAnimationRunning) {
			long now = System.nanoTime();
			if (now - last >= LOOP_TIME) {
				last += LOOP_TIME;
				updateAnimation(count);
				count++;
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateAnimation(int count) {
		String test = "TEST";
		double test_width = calculateTextWidth(test, MAIN_FONT);
		double test_height = (count*3);
		String time = model.getCountDownTimer().toMinute();
		double font_height = calculateTextHeight(SUBMAIN_FONT); 
		double time_width = calculateTextWidth(time, SUBMAIN_FONT);

		setBackGround();
		gc.setFill(Color.WHITE);
		gc.setFont(SUBMAIN_FONT);
		gc.fillText("Score: " + model.getScore(), 10, 10 + font_height);
		gc.fillText("Combo: " + model.getCombo(), 10, 10 + 2*font_height);
		gc.fillText(time  , INGAME_WIDTH - time_width - 10, 10 + font_height);
		gc.setFont(MAIN_FONT);
		gc.fillText(test , (INGAME_WIDTH - test_width)/2, test_height);
		//gc.fillText(currentWordString.substring(0, model.getCurrentWordTypedCount()), wordX, wordY);
		
	}
	
	public void setBackGround(){
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, INGAME_WIDTH, INGAME_HEIGHT);
		//gc.drawImage(RenderableHolder.inGameBackground, 0, 0);
	}
	
	public void setText(){
		gc.setFill(Color.YELLOWGREEN);
		gc.setFont(MAIN_FONT);
		gc.fillText("TEST In Game", 600/2, 1000/2);
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				
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
