package logic;

public class CountDownTimer {
	
	private int time;
	private static final int DEFAULT_TIME = 65;
	private static final int PER_MINUTE = 60;
	
	public CountDownTimer() {
		this.time = DEFAULT_TIME;
	}
	
	public void countDown() {
		if(time > 0) time -= 1;
	}
	
	public String toMinute() {
		if(getTime() % PER_MINUTE < 10) return "0" + String.valueOf(getTime() / PER_MINUTE) + ":0" + String.valueOf(getTime() % PER_MINUTE);
		return "0" + String.valueOf(getTime() / PER_MINUTE) + ":" + String.valueOf(getTime() % PER_MINUTE);
	}

	public long getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
