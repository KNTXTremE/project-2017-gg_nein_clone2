package logic;

import graphic.InGame;

public class GameLogic {
	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private static GameModel model;
	private static boolean isGameRunning;

	public GameLogic(GameModel model) {
		this.model = model;
	}

	public static void startGame() {
		isGameRunning = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
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
			
		}).start();
	}

	public static void stopGame() {
		isGameRunning = false;
	}

	private static void updateGame(long elapsedTime) {
		model.getCountDownTimer().countDown(elapsedTime);
		if(model.getCountDownTimer().getTime() == 0) {
			stopGame();
			InGame.stopAnimation();
		}
	}
}
