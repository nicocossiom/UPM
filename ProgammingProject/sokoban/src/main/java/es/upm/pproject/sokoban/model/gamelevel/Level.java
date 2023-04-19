package es.upm.pproject.sokoban.model.gamelevel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Level {
    private Board board;
    private Integer moves;
    StringProperty movesString = new SimpleStringProperty();

    // TODO undo stack
    public Level(String levelPath) {
        this.board = LevelLoader.loadBoard(levelPath);
        this.moves = 0;
        this.movesString.set(moves.toString());
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the moves
     */
    public Integer getMoves() {
        return moves;
    }

    /**
     * @param moves the moves to set
     */
    public void setMoves(Integer moves) {
        this.moves = moves;
    }

    public void addOneMove() {
        this.moves++;
        this.movesString.set(moves.toString());
    }

    public void subtractOneMove() {
        this.moves--;
        this.movesString.set(moves.toString());
    }

    /**
     * @return the strMoves
     */
    public StringProperty getStrMoves() {
        return this.movesString;
    }

    public void setStrMoves() {
        this.movesString.set("YOU HAVE WON");
    }
}
