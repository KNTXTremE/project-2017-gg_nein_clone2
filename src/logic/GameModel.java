package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyCode;
import song.Song;
import song.SongResources;

public class GameModel {
	
	private boolean touchNote;
	private int combo;
	private int score;
	private CountDownTimer countDownTimer;
	private int mode;
	private int selectedSong;
	private List<Song> allSongs;
	private boolean touchButton1;
	private boolean touchButton2;
	private boolean touchButton3;

	public static final int SCORE_PER_NOTE = 100;
	public static final int MULTIPILER = 15;
	
	public GameModel() {
		touchButton1 = false;
		touchButton2 = false;
		touchButton3 = false;
		touchNote = false;
		combo = 0;
		score = 0;
		countDownTimer = new CountDownTimer();
		mode = 0;
		selectedSong = 0;
		allSongs = new ArrayList<>();
		SongResources.addSong(allSongs);
	}

	public void scoreUp() {
		if(touchNote == true) {
			score += (mode + 1)*(SCORE_PER_NOTE + combo*MULTIPILER);
			combo++;
		}
	}
	
	public void resetCombo() {
		combo = 0;
	}

	public void setTouchButton(boolean touchButton, KeyCode keycode) {
		if(keycode.equals(KeyCode.A))
			touchButton1 = touchButton;
		if(keycode.equals(KeyCode.S))
			touchButton2 = touchButton;
		if(keycode.equals(KeyCode.D))
			touchButton3 = touchButton;
	}
	
	public boolean isTouchButton1() {
		return touchButton1;
	}
	
	public boolean isTouchButton2() {
		return touchButton2;
	}

	public boolean isTouchButton3() {
		return touchButton3;
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
	
	public int getSpeed() {
		return 5 + 15*(mode);
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
