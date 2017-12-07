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
		this.keycode = keycode;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(isPressed == false) { //DRAW UNPRESSED
			gc.setFill(Color.RED);
			gc.setLineWidth(10);
			gc.setStroke(Color.WHITE);
			gc.strokeRect(x, y, 110, 60);
			gc.fillRect(x, y, 100, 50);
		}
		else { //DRAW PRESSED
			gc.setFill(Color.RED);
			gc.setLineWidth(10);
			gc.setStroke(Color.WHITE);
			gc.strokeRect(x, y, 110, 60);
			gc.fillRect(x + 10, y + 10, 100, 50);
		}
		
	}
	
	public void update() {
		if(InGameInput.getKeyPressed(keycode)) {
			isPressed = true;
		}
		else {
			isPressed = false;
		}
	}
}
