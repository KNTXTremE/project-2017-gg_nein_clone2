package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Note extends Items {

	private int position;
	
	
	public Note(double y, int position) {
		this.position = position;
		this.y = y;
		this.z = 100;
	}
	
	@Override
	public void draw(GraphicsContext gc, int count) {
		// TODO Auto-generated method stub
		gc.setFill(Color.YELLOW);
		gc.setStroke(Color.YELLOWGREEN);
		double Y = count*model.getSpeed() + 120*(y)  - 3500;
		gc.fillOval(90 + (position - 1)*120, Y, 50, 50); //MINUS FOR GOING UP
		gc.strokeOval(90 + (position - 1)*120, Y, 50, 50);
//		gc.fillOval(90 + (position - 1)*120, (y*model.getSpeed() + model.getAllSongs().get(model.getSelectedSong()).getSongDuration() - model.getCountDownTimer().getTimeSecond()), 50, 50);
//		gc.strokeOval(90 + (position - 1)*120, (y*model.getSpeed() + model.getAllSongs().get(model.getSelectedSong()).getSongDuration() - model.getCountDownTimer().getTimeSecond()), 50, 50);
	}

}
