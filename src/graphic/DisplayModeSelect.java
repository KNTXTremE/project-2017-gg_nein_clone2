package graphic;

import java.awt.FontFormatException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import window.SceneManager;

public class DisplayModeSelect extends Canvas implements Renderable {
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public DisplayModeSelect() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		setBackGround(gc);
		setText(gc);
		//EventHandler();
	}
	
	public void setBackGround(GraphicsContext gc){
		gc.setFill(Color.DARKBLUE);
		gc.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT);
	}
	public void setText(GraphicsContext gc){
	gc.setFill(Color.YELLOWGREEN);
	gc.setFont(TEXT_FONT);
	gc.fillText("TEST", SCENE_WIDTH/2, SCENE_HEIGHT/2);
	}
}
