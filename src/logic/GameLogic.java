package logic;

public class GameLogic {
	
	private boolean touch;
	private boolean touchNote;
	private int combo;
	private int score;
	
	public GameLogic() {
		touch = false;
		touchNote = false;
		combo = 0;
		score = 0;
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
