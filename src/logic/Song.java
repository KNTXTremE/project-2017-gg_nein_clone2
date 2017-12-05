package logic;

import javafx.scene.media.AudioClip;

public class Song {
	private String songName;
	private AudioClip songFile;
	private int songNo;
	private int songDuration;
	
	public Song(String songName, AudioClip songFile, int songNo, int songDuration) {
		this.songName = songName;
		this.songFile = songFile;
		this.songNo = songNo;
		this.songDuration = songDuration;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public AudioClip getSongFile() {
		return songFile;
	}

	public void setSongFile(AudioClip songFile) {
		this.songFile = songFile;
	}

	public int getSongNo() {
		return songNo;
	}

	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}

	public int getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(int songDuration) {
		this.songDuration = songDuration;
	}
	
	
}
