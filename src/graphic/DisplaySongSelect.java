package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.Song;
import sharedObject.RenderableHolder;
import window.SceneManager;

public class DisplaySongSelect extends CanvasManager implements Drawable {

	public DisplaySongSelect() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		gc = this.getGraphicsContext2D();
		setBackGround();
		setText();
		EventHandler();
	}

	public void setBackGround() {
		gc.setFill(Color.BLACK);
		gc.drawImage(RenderableHolder.menuBackground, 0, 0);
	}

	public void setText() {
		String title = "Select the Song";
		String back = "ESC: Back";
		double title_width = calculateTextWidth(title, MAIN_FONT);
		double back_width = calculateTextWidth(back, SUBMAIN_FONT);
		gc.setFont(SUBMAIN_FONT);
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillText(back, SCENE_WIDTH - back_width - 10, SCENE_HEIGHT - 10);
		gc.setFont(MAIN_FONT);
		gc.fillText(title, (SCENE_WIDTH - title_width) / 2, SCENE_HEIGHT / (5 + model.getAllSongs().size()));
		for (Song x : model.getAllSongs()) {
			if (x.getSongNo() == 0)
				gc.setFill(Color.LIME);
			else
				gc.setFill(Color.ANTIQUEWHITE);
			gc.fillText(x.getSongName(), (SCENE_WIDTH - calculateTextWidth(x.getSongName(), MAIN_FONT)) / 2,
					(2 + x.getSongNo()) * SCENE_HEIGHT / (5 + model.getAllSongs().size()));
		}

	}

	@Override
	public void setHightLight(String selected_mode, double selected_width) {
		gc.setFill(Color.LIME);
		gc.fillText(selected_mode, (SCENE_WIDTH - selected_width) / 2,
				(2 + model.getSelectedSong()) * SCENE_HEIGHT / (5 + model.getAllSongs().size()));
	}

	@Override
	public void setUnHightLight(String unsel_mode, double unsel_width) {
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillText(unsel_mode, (SCENE_WIDTH - unsel_width) / 2,
				(2 + model.getSelectedSong()) * SCENE_HEIGHT / (5 + model.getAllSongs().size()));
	}

	public void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ESCAPE)) {
					SceneManager.gotoModeSelect();
				} else if (event.getCode().equals(KeyCode.ENTER)) {
					model.getCountDownTimer().setTimeSecond(model.getAllSongs().get(model.getSelectedSong()).getSongDuration());
					System.out.println("Song NO: " + model.getSelectedSong());
					GameMain.startInGame();
				} else if (event.getCode().equals(KeyCode.DOWN)) {
					if (model.getSelectedSong() == 0) {
						setUnHightLight(model.getAllSongs().get(0).getSongName(), calculateTextWidth(model.getAllSongs().get(0).getSongName(), MAIN_FONT));
						model.setSelectedSong(1);
						setHightLight(model.getAllSongs().get(1).getSongName(), calculateTextWidth(model.getAllSongs().get(1).getSongName(), MAIN_FONT));
					}

				} else if (event.getCode().equals(KeyCode.UP)) {
					if (model.getSelectedSong() == 1) {
						setUnHightLight(model.getAllSongs().get(1).getSongName(), calculateTextWidth(model.getAllSongs().get(1).getSongName(), MAIN_FONT));
						model.setSelectedSong(0);
						setHightLight(model.getAllSongs().get(0).getSongName(), calculateTextWidth(model.getAllSongs().get(0).getSongName(), MAIN_FONT));
					}
				}
			}
		});
	}
}
