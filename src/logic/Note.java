package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Note extends Items {

	private int position;
	
	public Note(double y, int position) {
		this.position = position;
		this.y = y;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.YELLOW);
		gc.setStroke(Color.YELLOWGREEN);
		gc.fillOval(95 + (position - 1)*120, y*60, 50, 50);
		gc.strokeOval(95 + (position - 1)*120, y*60, 50, 50);
	}

}
