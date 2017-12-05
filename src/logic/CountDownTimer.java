package logic;

public class CountDownTimer {
	
	private int time;
	
	public CountDownTimer(int time) {
		this.time = time;
	}
	
	public void countDown() {
		if(time > 0) time--;
	}
	
	public String toMinute() {
		return "0" + Integer.toString(time/60) + ":" + Integer.toString(time%60);
	}
}
