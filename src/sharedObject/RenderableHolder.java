package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

public class RenderableHolder {
	private static final RenderableHolder holder = new RenderableHolder();

	private List<Renderable> items;
	private Comparator<Renderable> comparator;
	public static Image menuBackground;
	public static Image inGameBackground;
	public static AudioClip  music1;
	public static Font owFont;

	static {
		loadResource();
	}

	public RenderableHolder() {
		items = new ArrayList<Renderable>();
		comparator = (Renderable o1, Renderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return holder;
	}

	public static void loadResource() {
		menuBackground = new Image(ClassLoader.getSystemResource("backgrounds/menu.jpg").toString());
		inGameBackground = new Image(ClassLoader.getSystemResource("backgrounds/ingame.gif").toString());
//		inGameBackground = new Image(ClassLoader.getSystemResource("").toString());
		music1 = new AudioClip(ClassLoader.getSystemResource("musics/nyancat.mp3").toString());
		owFont = Font.loadFont(ClassLoader.getSystemResource("fonts/bignoodletoo.ttf").toString(), 50);
	}

	public void add(Renderable note) {
		items.add(note);
		Collections.sort(items, comparator);
	}

	public void update() {
		for (int i = items.size() - 1; i > -1; i--) {
			if (items.get(i).isPressed())
				items.remove(i);
		}
	}

	public List<Renderable> getItems() {
		return items;
	}
}
