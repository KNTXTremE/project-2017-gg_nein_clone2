package logic;

public class GameLogic {
	
	private boolean touch;
	private boolean touchNote;
	private int combo;
	private int score;
	public static final int SCORE_PER_NOTE = 100;
	
	public GameLogic() {
		touch = false;
		touchNote = false;
		combo = 0;
		score = 0;
	}

	public void scoreUp() {
		if(touchNote == true) {
			score += SCORE_PER_NOTE + combo*15;
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
	
	
}
