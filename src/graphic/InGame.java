package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class InGame extends CanvasManager implements Drawable {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private Thread gameAnimation;
	private boolean isAnimationRunning;
	
	public InGame() {
		super(INGAME_WIDTH, INGAME_HEIGHT);
		gc = this.getGraphicsContext2D();
		isAnimationRunning = false;
		EventHandler();
	}
	
	private void getReady() {
		// TODO Auto-generated method stub
		for(int i = 3; i > -1 ;i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setBackGround();
			setText();
			String game_ready = "Game start in " + i;
			double game_ready_width = calculateTextWidth(game_ready, MAIN_FONT);
			double game_ready_height = calculateTextHeight(MAIN_FONT);
			gc.fillText(game_ready, (INGAME_WIDTH - game_ready_width)/2, (INGAME_HEIGHT - game_ready_height)/2 + game_ready_height);
			System.out.println(i);
		}
	}

	public void startAnimation() {
		gameAnimation = new Thread(this::animationLoop);
		isAnimationRunning = true;
		gameAnimation.start();
	}
	
//	public void pauseAnimation() {
//		try {
//			gameAnimation.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void resumeAnimation() {
//		Object lock = new Object();
//		synchronized(lock) {
//			lock.notifyAll();
//			try {
//				gameAnimation.join(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	public void stopAnimation() {
		isAnimationRunning = false;
	}

	private void animationLoop() {
		getReady();
		model.getAllSongs().get(model.getSelectedSong()).getSongFile().play();
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
		double time_width = calculateTextWidth(time, SUBMAIN_FONT);
		String song_name = model.getAllSongs().get(model.getSelectedSong()).getSongName();
		double song_name_width = calculateTextWidth(song_name, SUBMAIN_FONT);
		double font_height = calculateTextHeight(SUBMAIN_FONT); 

		setBackGround();
		gc.setFill(Color.WHITE);
		gc.setFont(SUBMAIN_FONT);
		gc.fillText("Score: " + model.getScore(), 10, 10 + font_height);
		gc.fillText("Combo: " + model.getCombo(), 10, 10 + 2*font_height);
		gc.fillText(song_name, INGAME_WIDTH - song_name_width - 10, 10 + font_height);
		gc.fillText(time  , INGAME_WIDTH - time_width - 10, 10 + 2*font_height);
		gc.setFont(MAIN_FONT);
		gc.fillText(test , (INGAME_WIDTH - test_width)/2, test_height);
		
	}
	
	public void setBackGround(){
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, INGAME_WIDTH, INGAME_HEIGHT);
		//gc.drawImage(RenderableHolder.inGameBackground, 0, 0);
	}
	
	public void setText(){
		gc.setFill(Color.YELLOWGREEN);
		gc.setFont(MAIN_FONT);
		//gc.fillText("Game start in ", INGAME_WIDTH/3, INGAME_HEIGHT/2);
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ESCAPE)) {
//					GameMain.pauseInGame();
					SceneManager.gotoPause();
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
