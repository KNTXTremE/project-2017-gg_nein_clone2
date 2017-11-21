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
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		setBackGround(gc);
		setText(gc);
		//EventHandler();
	}
	
	public void setBackGround(GraphicsContext gc){
		gc.setFill(Color.DARKBLUE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}
	public void setText(GraphicsContext gc){
	gc.setFill(Color.YELLOWGREEN);
	gc.setFont(MAINMENU_FONT);
	}
}
