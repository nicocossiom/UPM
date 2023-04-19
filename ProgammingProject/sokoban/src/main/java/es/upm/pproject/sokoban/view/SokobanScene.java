package es.upm.pproject.sokoban.view;

import es.upm.pproject.sokoban.controller.movements.Inputs;
import es.upm.pproject.sokoban.model.gamelevel.Level;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SokobanScene extends Scene {

    private ImageView[][] imageGrid;
    private GridPane boardGrid;
    private HBox hbox;
    private Label moves;
    private Label movesVal;
    private Level level;

    public SokobanScene(double width, double height, int boardSize, Level level) {
        super(new HBox(5), width, height);
        this.level = level;
        Inputs.setInputHandler(this);
        // Crate scene components infrastructure
        VBox gridContainer = new VBox(); // Contains the graphical representation of the board status
        this.boardGrid = new GridPane(); // Graphical representation of the board status // code bellow
        this.imageGrid = new ImageView[boardSize][boardSize];
        moves = new Label();
        moves.setStyle("-fx-font: 24 arial;");
        moves.setText("Moves:\t");
        movesVal = new Label();
        movesVal.setStyle("-fx-font: 24 arial;");
        movesVal.textProperty().bind(level.getStrMoves());
        gridContainer.getChildren().addAll(boardGrid);
        this.hbox = (HBox) this.getRoot();
        VBox stats = new VBox();
        HBox movesBox = new HBox();
        movesBox.getChildren().addAll(moves, movesVal);
        stats.getChildren().addAll(movesBox);
        this.hbox.getChildren().addAll(gridContainer, stats);
    }

    /**
     * @return the imageGrid
     */
    public ImageView[][] getImageGrid() {
        return imageGrid;
    }

    /**
     * @param imageGrid the imageGrid to set
     */
    public void setImageGrid(ImageView[][] imageGrid) {
        this.imageGrid = imageGrid;
    }

    /**
     * @return the boardGrid
     */
    public GridPane getBoardGrid() {
        return boardGrid;
    }

    /**
     * @param boardGrid the boardGrid to set
     */
    public void setBoardGrid(GridPane boardGrid) {
        this.boardGrid = boardGrid;
    }

    /**
     * @return the hbox
     */
    public HBox getHbox() {
        return hbox;
    }

    /**
     * @param hbox the hbox to set
     */
    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }
}
