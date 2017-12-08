package logic;

import input.InGameInput;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Button extends Items {

	private KeyCode keycode;
	
	public Button(int x, int y, KeyCode keycode) {
		this.x = x;
		this.y = y;
		this.z = 50;
		this.keycode = keycode;
	}
	
	@Override
	public void draw(GraphicsContext gc, int count) {
		// TODO Auto-generated method stub
		if(isPressed == false) { //DRAW UNPRESSED
			gc.setFill(Color.RED);
			gc.setLineWidth(10);
			gc.setStroke(Color.WHITE);
			gc.strokeRect(x, y, 110, 60);
			gc.fillRect(x, y, 100, 50);
		}
		else { //DRAW PRESSED
			gc.setFill(Color.ORANGE);
			gc.setLineWidth(10);
			gc.setStroke(Color.WHITE);
			gc.strokeRect(x, y, 110, 60);
			gc.fillRect(x + 10, y + 10, 100, 50);
		}
		
	}
	
	public void update() {
		if(InGameInput.getKeyPressed(keycode)) {
			isPressed = true;
			model.setTouchButton(true, keycode);
			Song selectedSong = model.getAllSongs().get(model.getSelectedSong());
			int time_now = selectedSong.getSongDuration() - model.getCountDownTimer().getTimeSecond();
			if(selectedSong.getSongNoteMaps().containsKey((Double) (double) time_now) && isVisible()) {
				if(keycode.equals(KeyCode.A) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 1) {
					model.setTouchNote(true);
					model.scoreUp();
					System.out.println("Score: " + model.getScore() + "\tCombo:" + model.getCombo());
				}
				if(keycode.equals(KeyCode.S) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 2) {
					model.setTouchNote(true);
					model.scoreUp();
					System.out.println("Score: " + model.getScore() + "\tCombo:" + model.getCombo());
				}
				if(keycode.equals(KeyCode.D) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 3) {
					model.setTouchNote(true);
					model.scoreUp();
					System.out.println("Score: " + model.getScore() + "\tCombo:" + model.getCombo());
				}
				else if ((keycode.equals(KeyCode.A) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 2) ||
						(keycode.equals(KeyCode.A) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 3)){
					model.setTouchNote(false);
					model.resetCombo();
				}
				else if ((keycode.equals(KeyCode.S) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 1) ||
						(keycode.equals(KeyCode.S) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 3)){
					model.setTouchNote(false);
					model.resetCombo();
				}
				else if ((keycode.equals(KeyCode.D) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 1) ||
						(keycode.equals(KeyCode.D) && selectedSong.getSongNoteMaps().get((Double) (double) time_now) == 2)){
					model.setTouchNote(false);
					model.resetCombo();
				}
				else {
					model.setTouchNote(false);
				}
			}
			
		}
		else {
			isPressed = false;
			model.setTouchButton(false, keycode);
		}
	}
}
