package logic;

public class GameModel {
	
	private boolean touch;
	private boolean touchNote;
	private int combo;
	private int score;
	private CountDownTimer countDownTimer;
	private int mode;
	private int song;

	public static final int SCORE_PER_NOTE = 100;
	public static final int MULTIPILER = 15;
	
	public GameModel() {
		touch = false;
		touchNote = false;
		combo = 0;
		score = 0;
		countDownTimer = new CountDownTimer(60);
		countDownTimer = new CountDownTimer();
		mode = 0;
		song = 0;
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

	public int getSong() {
		return song;
	}

	public void setSong(int song) {
		this.song = song;
	}
	
}
