package logic;

import java.util.List;

import application.GameMain;
import graphic.CanvasManager;
import graphic.InGame;

public class GameLogic {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private InGame ingame;
	private Thread gameLogic;
	private List<Note> notes;
	private List<Button> buttons;
	private static boolean isGameRunning;

	public GameLogic(InGame ingame) {
		model = CanvasManager.getModel();
		this.ingame = ingame;
		isGameRunning = false;
	}

	public void startGame() {
		isGameRunning = true;
		gameLogic = new Thread(this::gameLoop);
		gameLogic.start();
	}

	// public void pauseGame() {
	// try {
	// gameLogic.wait();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// public void resumeGame() {
	// //gameLogic.notify();
	// }

	public void stopGame() {
		isGameRunning = false;
	}

	private void gameLoop() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long lastLoopStartTime = System.nanoTime();
		while (isGameRunning) {
			long elapsedTime = System.nanoTime() - lastLoopStartTime;
			if (elapsedTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;
				updateGame(elapsedTime);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void updateGame(long elapsedTime) {
		model.getCountDownTimer().countDown(elapsedTime);
		if (model.getCountDownTimer().getTimeSecond() == 0) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GameMain.stopInGame();
		}
	}
}
