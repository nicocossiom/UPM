package es.upm.pproject.sokoban.model.gamelevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import es.upm.pproject.sokoban.model.gamelevel.tiles.TileType;
import es.upm.pproject.sokoban.model.levelExceptions.invalidLevelCharacterException;

/**
 * This class is in charge of reading a level file and loading into memory
 */
public class LevelLoader {

    
    /** 
     * @param type
     * @return TileType
     */
    private static TileType charToTileType(char type) {
        switch (type) {
        case '+':
            return TileType.WALL;
        case ' ':
            return TileType.GROUND;
        case '*':
            return TileType.GOAL;
        case '#':
            return TileType.BOX;
        case 'W':
            return TileType.PLAYER;
        default:
            return null;
        }
    }

    
    /** 
     * @param path
     * @return Board
     */
    public static Board loadBoard(String path) {

        File level = new File(path);
        try (Scanner sc = new Scanner(level)) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            String skip = sc.nextLine(); // this is for skipping the first line
            Board board = new Board(rows, cols);
            for (int i = 0; sc.hasNextLine() && (i < rows); i++) {
                // StringBuilder debugLine = new StringBuilder();
                String line = sc.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j); // getting de character
                    // debugLine.append(c);
                    TileType type = charToTileType(c);
                    // Throws exception if it's an invalid character
                    if (type == null) {
                        throw new invalidLevelCharacterException("Invalid character: " + line.charAt(j));
                    }
                    if (type == TileType.GOAL) {
                        board.setGoals(board.getGoals()+1);
                    }
                    if (type == TileType.PLAYER)
                        board.setPlayerPosition(i, j);
                    board.setTile(i, j, type);
                }
                // Filling in the empty tiles on the right
                for (int k = line.length(); k < cols; k++) {
                    board.setTile(i, k, TileType.GROUND);
                }
                // System.out.println(debugLine);
            }
            board.viewBoard();
            return board;
        } catch (FileNotFoundException | invalidLevelCharacterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
