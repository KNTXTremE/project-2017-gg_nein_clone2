package graphic;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import application.GameMain;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import window.SceneManager;

public class MainMenu extends Canvas implements Renderable {
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public MainMenu() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		setBackGround(gc);
		setText(gc);
		EventHandler();
	}
	
	public void setBackGround(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}

	public void setText(GraphicsContext gc) {
		String title = "Welcome to LapLap Game";
		String desc = "Press Enter to Start";
		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		double title_width = fontLoader.computeStringWidth(title, MAINMENU_FONT);
		double desc_width = fontLoader.computeStringWidth(desc, MAINMENU_FONT);
		gc.setFont(MAINMENU_FONT);
		gc.setFill(Color.AQUA);
		gc.fillText(title, (SCENE_WIDTH - title_width)/2, SCENE_HEIGHT/3);
		gc.fillText(desc, (SCENE_WIDTH - desc_width)/2, 2*SCENE_HEIGHT/3);
		EventHandler();
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	Platform.exit();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	GameMain.gotoModeSelect();
                }
			}
		}); 
	}
}