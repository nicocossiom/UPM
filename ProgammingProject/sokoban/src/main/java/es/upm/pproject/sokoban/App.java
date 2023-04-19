package es.upm.pproject.sokoban;

import java.io.File;
import java.io.FileInputStream;

import es.upm.pproject.sokoban.model.gamelevel.Board;
import es.upm.pproject.sokoban.model.gamelevel.Level;
import es.upm.pproject.sokoban.view.ViewManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    static Stage currentStage;

    /**
     * @param stage
     */
    @Override
    public void start(Stage stage) {
        try {
            currentStage = stage;
            stage.getIcons().add(new Image(new FileInputStream("resources/sokovinhi.png")));
            stage.setTitle("SokoVinh");
            Level level = new Level("resources/Levels/level3.txt");
            Board board = level.getBoard();
            ViewManager.setGUIBoardSize(board);
            ViewManager.loadImages();
            stage.setScene(ViewManager.loadLevelState(level));
            stage.show();
            Media sound = new Media(new File("resources/audio/gameMusic.mp3").toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param newScene
     */
    public static void setNewScene(Scene newScene) {
        currentStage.setScene(newScene);
        currentStage.show();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}
