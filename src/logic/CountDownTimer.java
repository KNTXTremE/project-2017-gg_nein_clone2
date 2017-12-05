package logic;

public class CountDownTimer {
	
	private long time;
	private static final long DEFAULT_TIME = 65000000000L;
	
	public CountDownTimer(int time) {
		this.time = time;
	}
	
	public void countDown(long elapsedTime) {
		if(time > 0) time -= elapsedTime;
	}
	
	public String toMinute() {
		return "0" + Integer.toString(time/60) + ":" + Integer.toString(time%60);
	}

	public long getTime() {
		return time;
	}
	
	public int getTimeSecond() {
		return (int)(getTime()/Math.pow(10, 9));
	}

	public void setTime(int time) {
		this.time = time;
	}
}
