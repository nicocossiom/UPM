package es.upm.pproject.sokoban.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import es.upm.pproject.sokoban.App;
import es.upm.pproject.sokoban.model.gamelevel.Board;
import es.upm.pproject.sokoban.model.gamelevel.Level;
import es.upm.pproject.sokoban.model.gamelevel.tiles.Tile;
import es.upm.pproject.sokoban.model.gamelevel.tiles.TileType;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;

public class ViewManager {

    static SokobanScene CURRENTSCENE = null;

    /**
     * @return Scene
     */
    public static Scene getStartingScene() {
        Image back = new Image("file:resources/titleImage.png");
        ImageView background = new ImageView();
        Group root = new Group();
        Scene scene = new Scene(root);
        background.fitWidthProperty().bind(scene.widthProperty());
        background.setImage(back);
        background.setPreserveRatio(true);
        background.setSmooth(true);
        background.setCache(true);
        root.getChildren().add(background);
        return scene;
    }

    private static Image boxImage;
    private static Image goalImage;
    private static Image groundImage;
    private static Image playerRightImage;
    private static Image playerLeftImage;
    private static Image wallImage;
    private static Image boxInGoalImage;

    private static int boardSize;
    private static int tileSize;
    private static Board CURRENTBOARD;
    private static boolean GOALTILE; // this variable is true when the player is in a goaltile
    private static Level CURRENTLEVEL;
    private static int WIDTH = 960;
    private static int HEIGHT = 720;

    /**
     * @param board
     */
    public static void setGUIBoardSize(Board board) {
        int col = board.getCols();
        int row = board.getRows();
        if (col >= row)
            boardSize = col;
        else
            boardSize = row;
    }

    /**
     * @return int
     */
    public static int getGUIBoardSize() {
        return boardSize;
    }

    /**
     * @throws FileNotFoundException
     */
    public static void loadImages() throws FileNotFoundException {
        tileSize = 720 / boardSize;
        boxImage = new Image(new FileInputStream("resources/Tiles/box.png"), tileSize, tileSize, true, false);
        goalImage = new Image(new FileInputStream("resources/Tiles/goal.png"), tileSize, tileSize, true, false);
        groundImage = new Image(new FileInputStream("resources/Tiles/ground.png"), tileSize, tileSize, true, false);
        playerRightImage = new Image(new FileInputStream("resources/Tiles/playerright.png"), tileSize, tileSize, true,
                false);
        playerLeftImage = new Image(new FileInputStream("resources/Tiles/playerleft.png"), tileSize, tileSize, true,
                false);
        wallImage = new Image(new FileInputStream("resources/Tiles/wall.png"), tileSize, tileSize, true, false);
        boxInGoalImage = new Image(new FileInputStream("resources/Tiles/boxingoal.png"), tileSize, tileSize, true,
                false);
    }

    /**
     * @param level
     * @return Scene
     * @throws FileNotFoundException
     */
    public static Scene loadLevelState(Level level) throws FileNotFoundException {

        SokobanScene scene = new SokobanScene(WIDTH, HEIGHT, boardSize, level); // This is the object to be returned,
                                                                                // must be
        CURRENTSCENE = scene;
        CURRENTBOARD = level.getBoard();
        CURRENTLEVEL = level;
        ImageView[][] imageGrid = scene.getImageGrid();
        // TODO Read level board and load the tiles to the graphical interface
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Tile tile = CURRENTBOARD.getTile(i, j);
                if (tile != null) {
                    switch (tile.getTileType()) {
                        case BOX:
                            imageGrid[i][j] = new ImageView(boxImage);
                            break;
                        case GOAL:
                            imageGrid[i][j] = new ImageView(goalImage);
                            break;
                        case PLAYER:
                            imageGrid[i][j] = new ImageView(playerRightImage);
                            break;
                        case WALL:
                            imageGrid[i][j] = new ImageView(wallImage);
                            break;
                        default:
                            imageGrid[i][j] = new ImageView(groundImage);
                            break;
                    }
                    scene.getBoardGrid().add(imageGrid[i][j], j, i);
                } else {
                    scene.getBoardGrid().add(new ImageView(groundImage), j, i);
                }
            }
        }

        return scene;
    }

    /**
     * @param direction
     */
    public static void updateSceneOnInput(KeyCode direction) {
        ImageView[][] imageGrid = CURRENTSCENE.getImageGrid();
        int tileToReplaceI = directionToIRow(direction, CURRENTBOARD.getPlayerPositionI());
        int tileToReplaceJ = directionToJCol(direction, CURRENTBOARD.getPlayerPositionJ());
        // TODO finish movement checking and image setting for the possible distinct
        // cases
        executeMovementIfPossible(direction, tileToReplaceI, tileToReplaceJ);
    }

    /**
     * @param direction
     * @param j
     * @return int
     */
    private static int directionToJCol(KeyCode direction, int j) {
        switch (direction) {
            case LEFT:
                j--;
                break;

            case RIGHT:
                j++;
                break;
            default:
                // LOGGER.error("Unknown input with no appropiate handle");
                break;
        }
        return j;
    }

    /**
     * @param direction
     * @param i
     * @return int
     */
    private static int directionToIRow(KeyCode direction, int i) {
        switch (direction) {
            case UP:
                i--;
                break;
            case DOWN:
                i++;
                break;
            default:
                // LOGGER.error("Unknown input with no appropiate handle");
                break;
        }
        return i;
    }

    /**
     * @param i1
     * @param j1
     * @param i2
     * @param j2
     */
    public static void exchangeTilesAndImageGrid(int i1, int j1, int i2, int j2) {
        TileType toMoveTo = CURRENTBOARD.getTile(i2, j2).getTileType();
        TileType origin = CURRENTBOARD.getTile(i1, j1).getTileType();
        boolean normalMove = true;
        if (toMoveTo.equals(TileType.GROUND) && origin.equals(TileType.BOXINGOAL)) {
            CURRENTBOARD.setTile(i2, j2, TileType.BOX);
            CURRENTBOARD.setTile(i1, j1, TileType.GOAL);
            CURRENTBOARD.setGoals(CURRENTBOARD.getGoals() + 1);

            normalMove = false;
        }
        if (toMoveTo.equals(TileType.GROUND) && origin.equals(TileType.PLAYERINGOAL)) {
            CURRENTBOARD.setTile(i2, j2, TileType.PLAYER);
            CURRENTBOARD.setTile(i1, j1, TileType.GOAL);
            normalMove = false;
        }
        if (toMoveTo.equals(TileType.GOAL) && origin.equals(TileType.BOX)) {
            // update the goaltile type so we know next move we only update the next tile to
            // player
            // We change the goaltile to the player but the old player one stays the same
            CURRENTBOARD.setTile(i2, j2, TileType.BOXINGOAL);
            CURRENTBOARD.setTile(i1, j1, TileType.GROUND);
            int goals = CURRENTBOARD.getGoals();
            CURRENTBOARD.setGoals(goals - 1);
            SokobanSounds.playCorrectSound();
            if (CURRENTBOARD.getGoals() == 0) {
                showWinnerScene();
            }
            normalMove = false;
        }
        // 1. player wants to move to a goal tile
        if (toMoveTo.equals(TileType.GOAL) && origin.equals(TileType.PLAYER)) {
            // update the goaltile type so we know next move we only update the next tile to
            // player
            // We change the goaltile to the player but the old player one stays the same
            CURRENTBOARD.setTile(i2, j2, TileType.PLAYERINGOAL);
            CURRENTBOARD.setTile(i1, j1, TileType.GROUND);
            normalMove = false;
        }
        // 3. Normal case when we just exchange a player tile with a ground tile
        if (normalMove) {
            CURRENTBOARD.exchangeTiles(i1, j1, i2, j2);
        }
        TileType one = CURRENTBOARD.getTile(i1, j1).getTileType();
        TileType two = CURRENTBOARD.getTile(i2, j2).getTileType();
        // we also have to update the player position, tiles can be exchanged and
        // neither have to be a player necessarily
        if (two.equals(TileType.PLAYER) || two.equals(TileType.PLAYERINGOAL)) {
            CURRENTBOARD.setPlayerPosition(i2, j2);
        }
        // we have done the move in the board but we have to update the images
        CURRENTSCENE.getImageGrid()[i2][j2].setImage(getImage(two));
        CURRENTSCENE.getImageGrid()[i1][j1].setImage(getImage(one));
    }

    private static void showWinnerScene() {
        SokobanSounds.playWinnerSound();
        Label winnerText = new Label();
        winnerText.setText("You have won");
        winnerText.setStyle("-fx-font: 70 arial;");
        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(winnerText);
        Scene newScene = new Scene(root, WIDTH, HEIGHT);
        App.setNewScene(newScene);
    }

    /**
     * @param tiletype
     * @return Image
     */
    private static Image getImage(TileType tiletype) {
        if (tiletype == TileType.PLAYER) {
            return playerRightImage;
        }
        if (tiletype == TileType.BOX) {
            return boxImage;
        }
        if (tiletype == TileType.GOAL) {
            return goalImage;
        }
        if (tiletype == TileType.BOXINGOAL) {
            return boxInGoalImage;
        }
        if (tiletype == TileType.PLAYERINGOAL) {
            return playerRightImage;
        }
        return groundImage;
    }

    /**
     * @param direction
     * @param tileToReplaceIRow
     * @param tileToReplaceJCol
     */
    private static void executeMovementIfPossible(KeyCode direction, int tileToReplaceIRow, int tileToReplaceJCol) {
        if (CURRENTBOARD.getTile(tileToReplaceIRow, tileToReplaceJCol).getTileType().isMoveable()) {
            // player want to move a box
            int tileToReplaceINext = directionToIRow(direction, tileToReplaceIRow);
            int tileToReplaceJNext = directionToJCol(direction, tileToReplaceJCol);
            // we get the next tile to the box in the direction
            // check if the next tile can be replaced
            if (CURRENTBOARD.getTile(tileToReplaceINext, tileToReplaceJNext).getTileType().isReplaceable()) {
                // let's exchange them
                exchangeTilesAndImageGrid(tileToReplaceIRow, tileToReplaceJCol, tileToReplaceINext, tileToReplaceJNext);
                SokobanSounds.playBoxMovingSound();
            }
        }
        if (CURRENTBOARD.getTile(tileToReplaceIRow, tileToReplaceJCol).getTileType().isReplaceable()) {
            exchangeTilesAndImageGrid(CURRENTBOARD.getPlayerPositionI(), CURRENTBOARD.getPlayerPositionJ(),
                    tileToReplaceIRow,
                    tileToReplaceJCol);
            CURRENTLEVEL.addOneMove();
            SokobanSounds.playPlayerMovingSound();
        } else {
            SokobanSounds.playWallSound();
        }
    }
}
