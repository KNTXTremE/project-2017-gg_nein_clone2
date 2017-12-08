package logic;

import java.util.ArrayList;
import java.util.List;
import logic.Pair;

import application.GameMain;
import graphic.CanvasManager;
import graphic.InGame;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;

public class GameLogic {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	@SuppressWarnings("unused")
	private InGame ingame;
	private Thread gameLogic;
	private List<Items> gameObj;
	private Button button1, button2, button3;
	private Note note;
	private List<Pair<Double, Integer>> songNotes;
	private Song selectedSong;

	private static boolean isGameRunning;

	public GameLogic(InGame ingame) {
		model = CanvasManager.getModel();
		this.ingame = ingame;
		gameObj = new ArrayList<Items>();
		button1 = new Button(60, 700, KeyCode.A);
		button2 = new Button(180, 700, KeyCode.S);
		button3 = new Button(300, 700, KeyCode.D);
		selectedSong = model.getAllSongs().get(model.getSelectedSong());
		songNotes = selectedSong.getSongNotes();
		for(int i = 0; i < songNotes.size(); i++) {
			note = new Note(songNotes.get(i).getFirst(), songNotes.get(i).getSecond());
			addObj(note);
		}
		addObj(button1);
		addObj(button2);
		addObj(button3);
		isGameRunning = false;
	}

	private void addObj(Items item) {
		gameObj.add(item);
		RenderableHolder.getInstance().add(item);
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
		button1.update();
		button2.update();
		button3.update();
		for(Items x : gameObj) {
			if(x instanceof Note && x.isVisible()) ((Note) x).update();
		}
		model.getCountDownTimer().countDown(elapsedTime);
		if (model.getCountDownTimer().getTimeSecond() == 0) {
			GameMain.stopInGame();
		}
	}
}
