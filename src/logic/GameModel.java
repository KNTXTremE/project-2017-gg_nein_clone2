package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;

public class GameModel {
	
	private boolean touch;
	private boolean touchNote;
	private int combo;
	private int score;
	private CountDownTimer countDownTimer;
	private int mode;
	private int selectedSong;
	private List<Song> allSongs;

	public static final int SCORE_PER_NOTE = 100;
	public static final int MULTIPILER = 15;
	
	public GameModel() {
		touch = false;
		touchNote = false;
		combo = 0;
		score = 0;
		countDownTimer = new CountDownTimer();
		mode = 0;
		selectedSong = 0;
		allSongs = new ArrayList<>();
		allSongs.add(new Song("Nyan cat", RenderableHolder.music1, 0, 35));
		allSongs.add(new Song("Wicked Games", RenderableHolder.music2, 1, (4*60) + 41));
	}

	public void scoreUp() {
		if(touchNote == true) {
			score += SCORE_PER_NOTE + combo*MULTIPILER;
			combo++;
		}
	}
	
	public void resetCombo() {
		combo = 0;
	}
	
	public boolean isTouch() {
		return touch;
	}

	public void setTouch(boolean touch) {
		this.touch = touch;
	}

	public boolean isTouchNote() {
		return touchNote;
	}

	public void setTouchNote(boolean touchNote) {
		this.touchNote = touchNote;
	}

	public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public CountDownTimer getCountDownTimer() {
		return countDownTimer;
	}

	public void setCountDownTimer(CountDownTimer timer) {
		this.countDownTimer = timer;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getSelectedSong() {
		return selectedSong;
	}

	public void setSelectedSong(int song) {
		this.selectedSong = song;
	}

	public List<Song> getAllSongs() {
		return allSongs;
	}

	public void setAllSongs(List<Song> allSongs) {
		this.allSongs = allSongs;
	}
}
