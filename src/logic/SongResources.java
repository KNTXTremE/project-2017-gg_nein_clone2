package logic;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javafx.util.Pair;
import sharedObject.RenderableHolder;

public class SongResources {
	
	private static SortedMap<Double, Integer> songNotes1 = new TreeMap<>();
	private static SortedMap<Double, Integer> songNotes2 = new TreeMap<>();
	private static Song nyancat = new Song("Nyan Cat", RenderableHolder.music1, 0, 35, songNotes1);
	private static Song wicked_games = new Song("Wicked Games", RenderableHolder.music2, 1, (4*60) + 41, songNotes2);
	
	public static void addSong(List<Song> songs) {
		addSongNotes();
		songs.add(nyancat);
		songs.add(wicked_games);
	}
	
	private static void addSongNotes() {
		songNotes1.put(5.00, 3);
		songNotes1.put(6.00, 1);
		songNotes1.put(7.00, 2);
		songNotes1.put(8.00, 2);
		songNotes1.put(9.00, 3);
		songNotes1.put(10.00, 1);
		songNotes1.put(11.00, 1);
		songNotes1.put(12.00, 2);
		songNotes1.put(13.00, 3);
		songNotes1.put(14.00, 2);
		songNotes1.put(15.00, 2);
		songNotes1.put(16.00, 2);
		songNotes1.put(17.00, 1);
		songNotes1.put(18.00, 3);
		songNotes1.put(19.00, 1);
		songNotes1.put(20.00, 3);
		songNotes1.put(21.00, 2);
		songNotes1.put(22.00, 1);
		songNotes1.put(23.00, 3);
		songNotes1.put(24.00, 2);
		songNotes1.put(25.00, 2);
		songNotes1.put(26.00, 1);
		songNotes1.put(27.00, 3);
		songNotes1.put(28.00, 1);
		songNotes1.put(29.00, 2);
		songNotes1.put(30.00, 2);
		System.out.println(songNotes1.keySet() + "\n" + songNotes1.values() + "\n");
	}
}
