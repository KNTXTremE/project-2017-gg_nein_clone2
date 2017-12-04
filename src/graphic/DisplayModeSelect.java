package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class DisplayModeSelect extends GameMain implements Drawable {

	private GraphicsContext gc = this.getGraphicsContext2D();
	private String easy_mode = "Easy";
	private String normal_mode = "Normal";
	private String hard_mode = "Hard";
	double easy_width = fontLoader.computeStringWidth(easy_mode, MAINMENU_FONT);
	double normal_width = fontLoader.computeStringWidth(normal_mode, MAINMENU_FONT);
	double hard_width = fontLoader.computeStringWidth(hard_mode, MAINMENU_FONT);

	public DisplayModeSelect() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		setBackGround();
		setText();
		EventHandler();
	}

	public void setBackGround() {
		gc.setFill(Color.BLACK);
		gc.drawImage(RenderableHolder.menuBackground, 0, 0);
	}

	public void setText() {
		String title = "Select the difficulity";
		double title_width = fontLoader.computeStringWidth(title, MAINMENU_FONT);
		gc.setFont(MAINMENU_FONT);
		gc.setFill(Color.WHITE);
		gc.fillText(title, (SCENE_WIDTH - title_width) / 2, SCENE_HEIGHT / 5);
		gc.fillText(easy_mode, (SCENE_WIDTH - easy_width) / 2, 2 * SCENE_HEIGHT / 5);
		gc.fillText(normal_mode, (SCENE_WIDTH - normal_width) / 2, 3 * SCENE_HEIGHT / 5);
		gc.fillText(hard_mode, (SCENE_WIDTH - hard_width) / 2, 4 * SCENE_HEIGHT / 5);
		gc.setFill(Color.LIME);
		gc.fillText(easy_mode, (SCENE_WIDTH - easy_width) / 2, 2 * SCENE_HEIGHT / 5);
	}

	private void setHightLight(String selected_mode, double selected_width) {
		gc.setFill(Color.LIME);
		gc.fillText(selected_mode, (SCENE_WIDTH - selected_width) / 2, (2 + model.getMode()) * SCENE_HEIGHT / 5);
	}

	private void setUnHightLight(String unsel_mode, double unsel_width) {
		gc.setFill(Color.WHITE);
		gc.fillText(unsel_mode, (SCENE_WIDTH - unsel_width) / 2, (2 + model.getMode()) * SCENE_HEIGHT / 5);
	}

	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ESCAPE)) {
					SceneManager.gotoMainMenu();
				} else if (event.getCode().equals(KeyCode.ENTER)) {
					model.setMode(model.getMode());
					System.out.println(model.getMode());
					GameMain.gotoSongSelect();
				} else if (event.getCode().equals(KeyCode.DOWN)) {
					if (model.getMode() == 0) {
						setUnHightLight(easy_mode, easy_width);
						model.setMode(1);
						setHightLight(normal_mode, normal_width);
					} else if (model.getMode() == 1) {
						setUnHightLight(normal_mode, normal_width);
						model.setMode(2);
						setHightLight(hard_mode, hard_width);
					}

				} else if (event.getCode().equals(KeyCode.UP)) {
					if (model.getMode() == 1) {
						setUnHightLight(normal_mode, normal_width);
						model.setMode(0);
						setHightLight(easy_mode, easy_width);
					} else if (model.getMode() == 2) {
						setUnHightLight(hard_mode, hard_width);
						model.setMode(1);
						setHightLight(normal_mode, normal_width);
					}
				}
			}
		});
	}
}