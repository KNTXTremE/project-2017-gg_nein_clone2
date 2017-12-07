package logic;

import java.util.List;
import java.util.SortedMap;

import javafx.scene.media.AudioClip;
import javafx.util.Pair;

public class Song {
	private String songName;
	private AudioClip songFile;
	private int songNo;
	private int songDuration;
	private SortedMap<Double, Integer> songNotes;
	
	public Song(String songName, AudioClip songFile, int songNo, int songDuration, SortedMap<Double, Integer> songNotes1) {
		this.songName = songName;
		this.songFile = songFile;
		this.songNo = songNo;
		this.songDuration = songDuration;
		this.songNotes = songNotes1;
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

	public SortedMap<Double, Integer> getSongNotes() {
		return songNotes;
	}

	public void setSongNotes(SortedMap<Double, Integer> songNotes) {
		this.songNotes = songNotes;
	}
}
