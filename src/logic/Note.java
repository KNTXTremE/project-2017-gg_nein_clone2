package logic;

import graphic.CanvasManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Note extends Items {

	private int position;
	private GameModel model;
	
	public Note(double y, int position) {
		this.position = position;
		this.y = y;
		this.z = 100;
		model = CanvasManager.getModel();
	}
	
	@Override
	public void draw(GraphicsContext gc, int count) {
		// TODO Auto-generated method stub
		gc.setFill(Color.YELLOW);
		gc.setStroke(Color.YELLOWGREEN);
		gc.fillOval(90 + (position - 1)*120, count*model.getSpeed() + 120*y - 3500 - 120*model.getSpeed(), 50, 50); //MINUS FOR GOING UP
		gc.strokeOval(90 + (position - 1)*120, count*model.getSpeed() + 120*y - 3500 - 120*model.getSpeed(), 50, 50);
//		gc.fillOval(90 + (position - 1)*120, (y*model.getSpeed() + model.getAllSongs().get(model.getSelectedSong()).getSongDuration() - model.getCountDownTimer().getTimeSecond()), 50, 50);
//		gc.strokeOval(90 + (position - 1)*120, (y*model.getSpeed() + model.getAllSongs().get(model.getSelectedSong()).getSongDuration() - model.getCountDownTimer().getTimeSecond()), 50, 50);
	}

}
