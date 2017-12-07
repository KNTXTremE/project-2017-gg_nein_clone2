package logic;

public class CountDownTimer {
	
	private long time;
	private static final long DEFAULT_TIME = 65000000000L;
	private static final int PER_MINUTE = 60;
	
	public CountDownTimer() {
		this.time = DEFAULT_TIME;
	}
	
	public void countDown(long elapsedTime) {
		time -= elapsedTime;
	}
	
	public String toMinute() {
		if(getTimeSecond() % PER_MINUTE < 10) return "0" + String.valueOf(getTimeSecond() / PER_MINUTE) + ":0" + String.valueOf(getTimeSecond() % PER_MINUTE);
		return "0" + String.valueOf(getTimeSecond() / PER_MINUTE) + ":" + String.valueOf(getTimeSecond() % PER_MINUTE);
	}

	public int getTimeSecond() {
		return (int) (time/Math.pow(10, 9));
	}
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public void setTimeSecond(int time) {
		this.time = time*1000000000L;
	}
}
