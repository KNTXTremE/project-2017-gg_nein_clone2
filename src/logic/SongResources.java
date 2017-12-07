package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;

public class SongResources {
	
	private static List<Pair<Double, Integer>> songNotes1 = new ArrayList<>();
	private static List<Pair<Double, Integer>> songNotes2 = new ArrayList<>();
	private static Song nyancat = new Song("Nyan Cat", RenderableHolder.music1, 0, 35, songNotes1);
	private static Song wicked_games = new Song("Wicked Games", RenderableHolder.music2, 1, (4*60) + 41, songNotes2);
	
	public static void addSong(List<Song> songs) {
		addSongNotes();
		songs.add(nyancat);
		songs.add(wicked_games);
	}
	
	private static void addSongNotes() {
		songNotes1.add(new Pair(5.00, 3));
		songNotes1.add(new Pair(6.00, 1));
		songNotes1.add(new Pair(7.00, 2));
		songNotes1.add(new Pair(8.00, 2));
		songNotes1.add(new Pair(9.00, 3));
		songNotes1.add(new Pair(10.00, 1));
		songNotes1.add(new Pair(11.00, 1));
		songNotes1.add(new Pair(12.00, 2));
		songNotes1.add(new Pair(13.00, 3));
		songNotes1.add(new Pair(14.00, 2));
		songNotes1.add(new Pair(15.00, 2));
		songNotes1.add(new Pair(16.00, 2));
		songNotes1.add(new Pair(17.00, 1));
		songNotes1.add(new Pair(18.00, 3));
		songNotes1.add(new Pair(19.00, 1));
		songNotes1.add(new Pair(20.00, 3));
		songNotes1.add(new Pair(21.00, 2));
		songNotes1.add(new Pair(22.00, 1));
		songNotes1.add(new Pair(23.00, 3));
		songNotes1.add(new Pair(24.00, 2));
		songNotes1.add(new Pair(25.00, 2));
		songNotes1.add(new Pair(26.00, 1));
		songNotes1.add(new Pair(27.00, 3));
		songNotes1.add(new Pair(28.00, 1));
		songNotes1.add(new Pair(29.00, 2));
		songNotes1.add(new Pair(30.00, 2));
		System.out.println(songNotes1);
	}
}
