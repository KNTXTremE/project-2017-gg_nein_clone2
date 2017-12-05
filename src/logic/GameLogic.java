package logic;

import application.GameMain;
import graphic.InGame;

public class GameLogic {
	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private InGame ingame;
	private Thread gameLogic;
	private static boolean isGameRunning;

	public GameLogic(GameModel model, InGame ingame) {
		this.model = model;
		this.ingame = ingame;
	}

	public void startGame() {
		isGameRunning = true;
		gameLogic = new Thread(this::gameLoop);
		gameLogic.start();
	}
	
//	public void pauseGame() {
//		try {
//			gameLogic.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void resumeGame() {
//		//gameLogic.notify();
//	}

	public void stopGame() {
		isGameRunning = false;
	}

	private void gameLoop() {
		long lastLoopStartTime = System.nanoTime();
		while (isGameRunning) {
			long elapsedTime = System.nanoTime() - lastLoopStartTime;
			if (elapsedTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;
				updateGame(elapsedTime);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void updateGame(long elapsedTime) {
		model.getCountDownTimer().countDown(elapsedTime);
		if(model.getCountDownTimer().getTimeSecond() == 0) {
			GameMain.stopInGame();
		}
	}
}
