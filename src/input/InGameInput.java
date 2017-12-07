package input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class InGameInput {
	private static ArrayList<KeyCode> keyPressed = new ArrayList<>();

	public static void setKeyPressed(KeyCode keyCode) {
		if(!keyPressed.contains(keyCode)){
			keyPressed.add(keyCode);
			System.out.println("\"" + keyCode + "\"" + " PRESSED");
		}
	}
	
	public static boolean getKeyPressed(KeyCode keyCode) {
		return keyPressed.contains(keyCode);
	}
	
	public static void setKeyReleased(KeyCode keyCode) {
		keyPressed.remove(keyCode);
		System.out.println("\"" + keyCode + "\"" + " RELEASED");
	}
}
