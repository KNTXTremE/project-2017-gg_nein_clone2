package logic;

import java.util.List;

import application.GameMain;
import graphic.CanvasManager;
import graphic.InGame;

public class GameLogic {

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
		for (int i = model.getAllSongs().get(model.getSelectedSong()).getSongDuration(); i > -1; i--) {
			if (i == model.getAllSongs().get(model.getSelectedSong()).getSongDuration()) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			updateGame(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updateGame(long elapsedTime) {
		model.getCountDownTimer().countDown();
		if (model.getCountDownTimer().getTime() == 0) {
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
